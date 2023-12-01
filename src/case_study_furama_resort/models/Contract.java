package case_study_furama_resort.models;

public class Contract {
    private String someContracts;
    private String BookingCode;
    private Double advanceDepositAmount;
    private Double totalPaymentAmount;

    public Contract() {
    }

    public Contract(String someContracts, String bookingCode, Double advanceDepositAmount, Double totalPaymentAmount) {
        this.someContracts = someContracts;
        BookingCode = bookingCode;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getSomeContracts() {
        return someContracts;
    }

    public void setSomeContracts(String someContracts) {
        this.someContracts = someContracts;
    }

    public String getBookingCode() {
        return BookingCode;
    }

    public void setBookingCode(String bookingCode) {
        BookingCode = bookingCode;
    }

    public Double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(Double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public Double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(Double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "someContracts='" + someContracts + '\'' +
                ", BookingCode='" + BookingCode + '\'' +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                '}';
    }
}
