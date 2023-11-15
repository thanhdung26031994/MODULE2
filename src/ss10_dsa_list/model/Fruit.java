package ss10_dsa_list.model;

public class Fruit {
    private String name;
    private String typeFruit;
    private String data;
    private String expiry;
    private String origin;
    private Double price;

    public Fruit() {
    }

    public Fruit(String name, String typeFruit, String data, String expiry, String origin, Double price) {
        this.name = name;
        this.typeFruit = typeFruit;
        this.data = data;
        this.expiry = expiry;
        this.origin = origin;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeFruit() {
        return typeFruit;
    }

    public void setTypeFruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Trái cây: " +
                "Tên: " + name +
                ", Loại: " + typeFruit +
                ", Ngày sản xuất: " + data +
                ", Hạn sử dụng: " + expiry +
                ", Xuất xứ: " + origin +
                ", Giá: " + price;
    }
}
