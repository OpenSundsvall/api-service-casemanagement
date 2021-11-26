package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PlanningPermissionFacility extends Facility {

    @NotNull
    private FacilityType facilityType;
    private boolean mainFacility;

}
