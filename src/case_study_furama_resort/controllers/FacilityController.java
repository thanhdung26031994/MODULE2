package case_study_furama_resort.controllers;

import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.services.IFacilityService;
import case_study_furama_resort.services.impl.FacilityService;

import java.util.Map;

public class FacilityController {
    private static IFacilityService iFacilityService = new FacilityService();


    public void addFacility(Facility facility1, Facility facility) {
        iFacilityService.addFacility(facility1, facility);
    }

    public Map<Facility, Integer> getAll() {
        return iFacilityService.getAll();
    }

    public boolean checkCode(String code) {
        return iFacilityService.checkCode(code);
    }

    public Map<Facility, Integer> displayMaintenance() {
        return iFacilityService.displayMaintenance();
    }

    public void deleteFacility(String code) {
        iFacilityService.deleteFacility(code);
    }
}
