package ss13_search.model;

import java.io.Serializable;

public class Job implements Serializable {
    private String code;
    private String name;
    private String data;
    private Long money;
    private String describe;

    public Job() {
    }

    public Job(String code, String costName, String data, Long money, String describe) {
        this.code = code;
        this.name = costName;
        this.data = data;
        this.money = money;
        this.describe = describe;
    }

    public Job(String name, String data, Long money, String describe) {
        this.name = name;
        this.data = data;
        this.money = money;
        this.describe = describe;
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

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return  "Mã: " + code +
                ", Tên: " + name +
                ", Ngày chi: " + data +
                ", Số tiền: " + money +
                ", Mô tả: " + describe;
    }

}
