package case_study_furama_resort.repositories;

import case_study_furama_resort.models.facility.Facility;

import java.util.Map;

public interface IFacilityRepository {

    void addFacility(Facility facility1, Facility facility);


    Map<Facility, Integer> getAll();

    boolean checkCode(String code);

    Map<Facility, Integer> displayMaintenance();

    void deleteFacility(String code);
}
