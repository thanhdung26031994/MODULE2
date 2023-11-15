package ss10_dsa_list.view;

import ss10_dsa_list.controller.FruitController;
import ss10_dsa_list.model.Fruit;

import java.util.List;
import java.util.Scanner;

public class FruitMenu {
    private static  FruitController fruitController = new FruitController();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-------Chức năng--------");
            System.out.println("1. Thêm mới.");
            System.out.println("2. Hiển thị danh sách.");
            System.out.println("3. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 1:
                    addFruit();
                    break;
                case 2:
                    displayFruit();
                    break;
                case 3:
                    System.exit(3);
                default:
                    System.out.println("Vui lòng chọn đúng.");
            }
        }while (true);


    }

    private static void displayFruit() {
        List<Fruit> fruits = fruitController.getAllFruit();
        System.out.println(fruits);
    }

    private static void addFruit() {
        String name = inputName();
        String type = inputType();
        String data = inputData();
        String expiry = inputExpiry();
        String origin = inputOrigin();
        Double price = inputPrice();
        fruitController.addFruit(new Fruit(name, type, data, expiry, origin, price));
    }

    private static Double inputPrice() {
        Double price = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập giá: ");
            price = Double.parseDouble(input.nextLine());
            if (!price.isNaN()){
                valid = true;
            }else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return price;
    }

    private static String inputOrigin() {
        String origin = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập xuất sứ: ");
            origin = input.nextLine();
            if (!origin.isEmpty()){
                valid = true;
            }else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return origin;
    }

    private static String inputExpiry() {
        String expiry = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập hạn sử dụng: ");
            expiry = input.nextLine();
            if (!expiry.isEmpty()){
                valid = true;
            }else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return expiry;

    }

    private static String inputData() {
        String data = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập ngày sản xuất: ");
            data = input.nextLine().trim();
            if (!data.isEmpty()){
                valid = true;
            }else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return data;
    }

    private static String inputType() {
        String type = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập loại trái cây: ");
            type = input.nextLine();
            if (!type.isEmpty()){
                valid = true;
            }else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return type;
    }

    private static String inputName() {
        String name = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Nhập tên trái cây: ");
                name = input.nextLine().trim();
                if (!name.isEmpty()){
                    valid= true;
                }else {
                    System.out.println("Vui lòng nhập lại.");
                }
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        return name;
    }
}
