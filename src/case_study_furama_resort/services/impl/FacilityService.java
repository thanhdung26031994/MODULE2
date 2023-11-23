package case_study_furama_resort.services.impl;

import case_study_furama_resort.repositories.IFacilityRepository;
import case_study_furama_resort.repositories.impl.FacilityRepository;
import case_study_furama_resort.services.IFacilityService;

public class FacilityService implements IFacilityService {
    private static IFacilityRepository iFacilityRepository = new FacilityRepository();
}
