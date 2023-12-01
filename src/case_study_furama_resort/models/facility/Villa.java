package case_study_furama_resort.models.facility;

public class Villa extends Facility{
    private String roomStandards;
    private Integer swimmingArea;
    private Integer floorsNumber;

    public Villa(String roomStandards, Integer swimmingArea, Integer floorsNumber) {
        this.roomStandards = roomStandards;
        this.swimmingArea = swimmingArea;
        this.floorsNumber = floorsNumber;
    }



    public Villa(String codeService, String nameService, Double acreage, Long costsRental, Integer maximumPeople, String rentalType, String roomStandards, Integer swimmingArea,Integer floorsNumber) {
        super(codeService, nameService, acreage, costsRental, maximumPeople, rentalType);
        this.roomStandards = roomStandards;
        this.swimmingArea = swimmingArea;
        this.floorsNumber = floorsNumber;
    }

    public Integer getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public Integer getSwimmingArea() {
        return swimmingArea;
    }

    public void setSwimmingArea(Integer swimmingArea) {
        this.swimmingArea = swimmingArea;
    }

    @Override
    public String toString() {
        return "Villa: "+ super.toString() + "\n"+
                ", Tiêu chuẩn phòng: " + roomStandards +
                ", Diện tích hồ bơi: " + swimmingArea +
                ", Số tầng: " + floorsNumber;
    }
}
