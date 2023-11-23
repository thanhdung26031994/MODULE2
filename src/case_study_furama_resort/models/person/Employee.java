package case_study_furama_resort.models.person;

public class Employee extends Person{
    private String level;
    private String location;
    private Long wage;

    public Employee() {
    }

    public Employee(String level, String location, Long wage) {
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String code, String name, String data, String gender, String idNumber, String phone, String email, String level, String location, Long wage) {
        super(code, name, data, gender, idNumber, phone, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Nhân viên: " + super.toString() + "\n"+
                ", Trình độ: " + level +
                ", Vị trí: " + location +
                ", Mức lương: " + wage +"VND";
    }
}
