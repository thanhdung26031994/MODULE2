package case_study_furama_resort.repositories.impl;

import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.facility.House;
import case_study_furama_resort.models.facility.Room;
import case_study_furama_resort.models.facility.Villa;
import case_study_furama_resort.repositories.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<Facility, Integer>();
    static {
        facilityMap.put(new Villa("SVVL-0001", "Villa Diamond", 25.0, 2000L, 10, "Năm", "Vip", 35, 3), 0);
        facilityMap.put(new House("SVHO-0001", "House Diamond", 25.0, 700L, 5, "Ngày", "Often", 3), 0);
        facilityMap.put(new Room("SVRO-0001", "Room Diamond", 25.0, 400L, 2, "Giờ", "Miễn phí chai nước suối"),0);
    }
}
