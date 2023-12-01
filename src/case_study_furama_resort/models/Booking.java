package case_study_furama_resort.models;

public class Booking {
    private String codeBooking;
    private String dateBooking;
    private String rentalStartDate;
    private String rentalEndDate;
    private String customerCode;
    private String serviceCode;

    public Booking() {
    }

    public Booking(String codeBooking, String dateBooking, String rentalStartDate, String rentalEndDate, String customerCode, String serviceCode) {
        this.codeBooking = codeBooking;
        this.dateBooking = dateBooking;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", dateBooking='" + dateBooking + '\'' +
                ", rentalStartDate='" + rentalStartDate + '\'' +
                ", rentalEndDate='" + rentalEndDate + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                '}';
    }
}
