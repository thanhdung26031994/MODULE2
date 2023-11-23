package case_study_furama_resort.models.person;

public class Person {
    private String code;
    private String name;
    private String data;
    private String gender;
    private String idNumber;
    private String phone;
    private String email;


    public Person() {
    }

    public Person(String code, String name, String data, String gender, String idNumber, String phone, String email) {
        this.code = code;
        this.name = name;
        this.data = data;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phone = phone;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Mã: " + code +
                ", Tên: " + name +
                ", Ngày sinh: " + data +
                ", Giới tính: " + gender +
                ", Số CMND: " + idNumber +
                ", Số điện thoại: " + phone +
                ", Email: " + email;
    }
}
