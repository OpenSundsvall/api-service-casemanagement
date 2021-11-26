package se.sundsvall;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import se.sundsvall.vo.CaseMapping;
import se.sundsvall.vo.SystemType;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
class CaseDaoTest {

    @Inject
    CaseDao caseDao;

    @ParameterizedTest
    @CsvSource({"123,", "123,''", ",321","' ',321", "123,321"})
    void testGetCaseMapping(String externalCaseId, String caseId) {
        CaseMapping caseMappingInput = new CaseMapping("123", "321", SystemType.BYGGR);
        caseDao.postCaseMapping(caseMappingInput);

        // Hämta med externalCaseId
        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(externalCaseId, caseId);

        // Rensa
        caseDao.deleteCaseMapping(caseMappingInput);

        Assertions.assertEquals(1, caseMappingList.size());
        Assertions.assertEquals(caseMappingInput, caseMappingList.get(0));
    }

    @Test
    void testGetCaseMappingNoHit() {
        CaseMapping caseMappingInput = new CaseMapping("123", "321", SystemType.ECOS);
        caseDao.postCaseMapping(caseMappingInput);

        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(null, "322");

        // Rensa
        caseDao.deleteCaseMapping(caseMappingInput);

        Assertions.assertEquals(0, caseMappingList.size());
    }

}
