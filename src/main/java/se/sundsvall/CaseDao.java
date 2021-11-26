package se.sundsvall;

import se.sundsvall.vo.CaseMapping;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CaseDao {

    @Inject
    EntityManager em;

    @Transactional
    public void postCaseMapping(CaseMapping caseMapping) {
        validateUniqueCase(caseMapping.getExternalCaseId());
        em.persist(caseMapping);
    }

    @Transactional
    public void deleteCaseMapping(CaseMapping caseMapping) {
        em.remove(em.contains(caseMapping) ? caseMapping : em.merge(caseMapping));
    }

    public List<CaseMapping> getCaseMapping(String externalCaseId, String caseId) {

        TypedQuery<CaseMapping> caseMappingList = em
                .createQuery("SELECT c FROM CaseMapping c WHERE c.externalCaseId LIKE :externalCaseId AND c.caseId LIKE :caseId",
                        CaseMapping.class)
                .setParameter("externalCaseId", setWildcardIfNotPresent(externalCaseId))
                .setParameter("caseId", setWildcardIfNotPresent(caseId));

        return caseMappingList.getResultList();
    }


    private String setWildcardIfNotPresent(String value) {
        if (value == null || value.isBlank() || value.isEmpty()) {
            value = "%";
        }
        return value;
    }

    /**
     * @throws EntityExistsException if a resources already exists with the same
     *                               externalCaseId
     */
    public void validateUniqueCase(String externalCaseId) throws EntityExistsException {
        if (externalCaseId != null) {

            TypedQuery<CaseMapping> caseMappingList = em
                    .createQuery("SELECT c FROM CaseMapping c WHERE c.externalCaseId LIKE :externalCaseId",
                            CaseMapping.class)
                    .setParameter("externalCaseId", externalCaseId);

            if (!caseMappingList.getResultList().isEmpty()) {
                throw new EntityExistsException(
                        "A resources already exists with the same externalCaseId: " + externalCaseId);
            }
        }
    }

}
