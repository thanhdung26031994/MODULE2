package case_study_furama_resort.services;

import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.facility.Villa;

import java.util.Map;
import java.util.Set;

public interface IFacilityService {

    void addFacility(Facility facility1, Facility facility);


    Map<Facility, Integer> getAll();

    boolean checkCode(String code);

    Map<Facility, Integer> displayMaintenance();


    void deleteFacility(String code);
}
