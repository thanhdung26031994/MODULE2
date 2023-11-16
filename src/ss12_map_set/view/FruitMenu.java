package ss12_map_set.view;

import ss12_map_set.controller.FruitController;
import ss12_map_set.model.Fruit;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FruitMenu {
    private static Scanner in = new Scanner(System.in);
    private static FruitController fruitController = new FruitController();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("--------Chức năng-------");
            System.out.println("1.Hiển thị danh sách (keySet)");
            System.out.println("2.Hiển thị danh sách (entrySet)");
            System.out.println("3.Thêm.");
            System.out.println("4.Xoá.");
            System.out.println("5.Sửa.");
            System.out.println("0.Thoát.");
            System.out.print("Vui lòng chọn: ");
            choice = Integer.parseInt(in.nextLine());
            switch (choice){
                case 1:
                    displayFruitKeySet();
                    break;
                case 2:
                    displayFruitEntrySet();
                    break;
                case 3:
                    addFruit();
                    break;
                case 4:
                    deleteFruit();
                    break;
                case 5:
                    editFruit();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đúng.");
            }
        }while (true);


    }

    private static void editFruit() {
        System.out.println("Nhập mã muốn sửa: ");
        Integer id = Integer.parseInt(in.nextLine());
        if (fruitController.checkId(id)){
            System.out.println("Nhập tên trái cây: ");
            String name = in.nextLine();
            System.out.println("Nhập loại trái cây: ");
            String type = in.nextLine();
            System.out.println("Nhập ngày sản xuất: ");
            String data = in.nextLine();
            System.out.println("Nhập hạn sử dụng: ");
            String expiry = in.nextLine();
            System.out.println("Nhập xuất xứ: ");
            String origin = in.nextLine();
            System.out.println("Nhập giá: ");
            Double price = Double.parseDouble(in.nextLine());
            fruitController.editFruit(id, new Fruit(name, type, data, expiry, origin, price));
        }else {
            System.out.println("Không có mã muốn sửa.");
        }

    }

    private static void deleteFruit() {
        System.out.println("Nhập mã muốn xoá: ");
        Integer id = Integer.parseInt(in.nextLine());
        if (fruitController.checkId(id)){
            fruitController.removeFruit(id);
            System.out.println("Xoá thành công.");
        }else {
            System.out.println("Không có mã muốn xoá.");
        }
    }

    private static void addFruit() {
        System.out.println("Nhập mã: ");
        Integer id = Integer.parseInt(in.nextLine());
        System.out.println("Nhập tên trái cây: ");
        String name = in.nextLine();
        System.out.println("Nhập loại trái cây: ");
        String type = in.nextLine();
        System.out.println("Nhập ngày sản xuất: ");
        String data = in.nextLine();
        System.out.println("Nhập hạn sử dụng: ");
        String expiry = in.nextLine();
        System.out.println("Nhập xuất xứ: ");
        String origin = in.nextLine();
        System.out.println("Nhập giá: ");
        Double price = Double.parseDouble(in.nextLine());
        fruitController.addFruitMap(id, new Fruit(name, type, data, expiry, origin, price));
        System.out.println("Thêm thành công.");
    }

    private static void displayFruitEntrySet() {
        Map<Integer, Fruit> fruitSet = fruitController.getAllEntrySet();
        for (Map.Entry<Integer, Fruit> entry: fruitSet.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    private static void displayFruitKeySet() {
        Map<Integer, Fruit> fruitSet = fruitController.getAllKeySet();
        Set<Integer> set = fruitSet.keySet();
        for (Integer key: set){
            System.out.println(key + " " + fruitSet.get(key));
        }
    }
}
