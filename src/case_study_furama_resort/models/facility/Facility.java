package case_study_furama_resort.models.facility;

public class Facility {
    private String codeService;
    private String nameService;
    private Double acreage;
    private Long costsRental;
    private Integer maximumPeople;
    private String rentalType;
    public Facility() {
    }

    public Facility(String codeService, String nameService, Double acreage, Long costsRental, Integer maximumPeople, String rentalType) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.acreage = acreage;
        this.costsRental = costsRental;
        this.maximumPeople = maximumPeople;
        this.rentalType = rentalType;
    }


    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Long getCostsRental() {
        return costsRental;
    }

    public void setCostsRental(Long costsRental) {
        this.costsRental = costsRental;
    }

    public Integer getMaximumPeople() {
        return maximumPeople;
    }

    public void setMaximumPeople(Integer maximumPeople) {
        this.maximumPeople = maximumPeople;
    }

    @Override
    public String toString() {
        return "Mã dịch vụ: " + codeService +
                ", Tên dịch vụ:" + nameService +
                ", Diện tích cho thuê: " + acreage +
                ", Chi phí thuê: " + costsRental +
                ", Số người tối đa: " + maximumPeople +
                ", Kiểu thuê: " + rentalType;
    }
}
