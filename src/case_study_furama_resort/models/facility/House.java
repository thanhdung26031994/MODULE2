package case_study_furama_resort.models.facility;

public class House extends Facility{
    private String roomStandards;
    private Integer floorsNumber;
    public House(){

    }

    public House(String roomStandards, Integer floorsNumber) {
        this.roomStandards = roomStandards;
        this.floorsNumber = floorsNumber;
    }

    public House(String codeService, String nameService, Double acreage, Long costsRental, Integer maximumPeople, String rentalType, String roomStandards, Integer floorsNumber) {
        super(codeService, nameService, acreage, costsRental, maximumPeople, rentalType);
        this.roomStandards = roomStandards;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public Integer getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    @Override
    public String toString() {
        return "House: "+ super.toString() +"\n" +
                ", Tiêu chuẩn phòng: " + roomStandards +
                ", Số tầng: " + floorsNumber;
    }
}
