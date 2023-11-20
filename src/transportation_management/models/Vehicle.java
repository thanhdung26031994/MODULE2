package transportation_management.models;

public class Vehicle {
    private String sea;
    private String name;
    private String year;
    private String owner;

    public Vehicle() {
    }

    public Vehicle(String sea, String name, String year, String owner) {
        this.sea = sea;
        this.name = name;
        this.year = year;
        this.owner = owner;
    }

    public String getSea() {
        return sea;
    }

    public void setSea(String sea) {
        this.sea = sea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "sea='" + sea + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
