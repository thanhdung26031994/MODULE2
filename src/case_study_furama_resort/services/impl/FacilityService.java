package case_study_furama_resort.services.impl;

import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.facility.Villa;
import case_study_furama_resort.repositories.IFacilityRepository;
import case_study_furama_resort.repositories.impl.FacilityRepository;
import case_study_furama_resort.services.IFacilityService;

import java.util.Map;
import java.util.Set;

public class FacilityService implements IFacilityService {
    private static IFacilityRepository iFacilityRepository = new FacilityRepository();


    @Override
    public void addFacility(Facility facility1, Facility facility) {
        iFacilityRepository.addFacility(facility1, facility);
    }

    @Override
    public Map<Facility, Integer> getAll() {
        return iFacilityRepository.getAll();
    }

    @Override
    public boolean checkCode(String code) {
        return iFacilityRepository.checkCode(code);
    }

    @Override
    public Map<Facility, Integer> displayMaintenance() {
        return iFacilityRepository.displayMaintenance();
    }

    @Override
    public void deleteFacility(String code) {
        iFacilityRepository.deleteFacility(code);
    }

}
