package case_study_furama_resort.repositories.impl;

import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.facility.House;
import case_study_furama_resort.models.facility.Room;
import case_study_furama_resort.models.facility.Villa;
import case_study_furama_resort.repositories.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FacilityRepository implements IFacilityRepository {
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<Facility, Integer>();
    static {
        facilityMap.put(new Villa("SVVL-0001", "Villa Diamond", 25.0, 2000L, 10, "Năm", "Vip", 35, 3), 5);
        facilityMap.put(new House("SVHO-0001", "House Diamond", 25.0, 700L, 5, "Ngày", "Often", 3), 0);
        facilityMap.put(new Room("SVRO-0001", "Room Diamond", 25.0, 400L, 2, "Giờ", "Miễn phí chai nước suối"),0);
    }


    @Override
    public void addFacility(Facility facility1, Facility facility) {
        Facility facility2 = null;
        if (facility1 instanceof Villa){
            facility2 = new Villa(facility.getCodeService(),
                    facility.getNameService(),
                    facility.getAcreage(),
                    facility.getCostsRental(),
                    facility.getMaximumPeople(),
                    facility.getRentalType(),
                    ((Villa) facility1).getRoomStandards(),
                    ((Villa) facility1).getSwimmingArea(),
                    ((Villa) facility1).getFloorsNumber());
        }else if (facility1 instanceof House){
            facility2 = new House(facility.getCodeService(),
                    facility.getNameService(),
                    facility.getAcreage(),
                    facility.getCostsRental(),
                    facility.getMaximumPeople(),
                    facility.getRentalType(),
                    ((House) facility1).getRoomStandards(),
                    ((House) facility1).getFloorsNumber());
        }else if (facility1 instanceof Room){
            facility2 = new Room(facility.getCodeService(),
                    facility.getNameService(),
                    facility.getAcreage(),
                    facility.getCostsRental(),
                    facility.getMaximumPeople(),
                    facility.getRentalType(),
                    ((Room) facility1).getFreeService());
        }
        facilityMap.put(facility2, facilityMap.getOrDefault(facility2, -1) + 1);
    }

    @Override
    public Map<Facility, Integer> getAll() {
        return facilityMap;
    }

    @Override
    public boolean checkCode(String code) {
        Set<Map.Entry<Facility, Integer>> facilities = facilityMap.entrySet();
        for (Map.Entry<Facility, Integer> entry: facilities){
            if (entry.getKey().getCodeService().equals(code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Facility, Integer> displayMaintenance() {
        Map<Facility, Integer> map = new LinkedHashMap<>();
        Set<Facility> facilitySet = facilityMap.keySet();
        for (Facility facility: facilitySet){
            if (facilityMap.get(facility) == 5){
                map.put(facility, facilityMap.get(facility));
            }
        }
        return map;
    }

    @Override
    public void deleteFacility(String code) {
        Set<Facility> set = facilityMap.keySet();
        for (Facility facility: set){
            if (facility.getCodeService().equals(code)){
                set.remove(facility);
                return;
            }
        }
    }
}
