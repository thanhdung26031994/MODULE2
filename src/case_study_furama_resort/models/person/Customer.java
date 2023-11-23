package case_study_furama_resort.models.person;

public class Customer extends Person{
    private String typeGuest;
    private String address;


    public Customer(String typeGuest, String address) {
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public Customer(String code, String name, String data, String gender, String idNumber, String phone, String email, String typeGuest, String address) {
        super(code, name, data, gender, idNumber, phone, email);
        this.typeGuest = typeGuest;
        this.address = address;
    }

    public String getTypeGuest() {
        return typeGuest;
    }

    public void setTypeGuest(String typeGuest) {
        this.typeGuest = typeGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Khách hàng: " + super.toString()+"\n"+
                ", Loại Khách: " + typeGuest +
                ", Địa chỉ: " + address;
    }
}
