package case_study_furama_resort.models.facility;

public class Room extends Facility{
    private String freeService;

    public Room(){

    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String codeService, String nameService, Double acreage, Long costsRental, Integer maximumPeople, String rentalType, String freeService) {
        super(codeService, nameService, acreage, costsRental, maximumPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room: "+ super.toString() +"\n"+
                ", Dịch vụ miễn phí đi kèm: " + freeService;
    }
}
