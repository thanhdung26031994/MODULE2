package case_study_furama_resort.views;

import case_study_furama_resort.controllers.FacilityController;
import case_study_furama_resort.utils.Regex;

import java.util.Scanner;

public class FacilityView {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static FacilityController facilityController = new FacilityController();
    private static final String PATH_CODEVILLA = "^SVVL-[0-9]{4}$";
    private static final String PATH_CODEHOUSE = "^SVHO-[0-9]{4}$";
    private static final String PATH_CODEROOM = "^SVRO-[0-9]{4}$";
    private static final String PATH_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}(?<=^.{1,50}$)$";

    public static void facilityMenu() {
        do {
            try {
                System.out.println("1. Hiển thị danh sách cơ sở\n" +
                        "2. Thêm cơ sở mới\n" +
                        "3. Hiển thị danh sách bảo trì cơ sở\n" +
                        "4. Xóa cơ sở\n" +
                        "5. Quay lại menu chính");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        displayFacility();
                        break;
                    case 2:
                        addFacility();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Vui lòng nhập đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println("Bạn đã nhập "+e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (true);
    }

    private static void displayFacility() {

    }

    private static void addFacility() {
        do {
            try {
                System.out.println("--------------------");
                System.out.println("1. Thêm mới Villa.");
                System.out.println("2. Thêm mới House.");
                System.out.println("3. Thêm mới Room");
                System.out.println("4. Quay lại.");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        addVilla();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println("Bạn đã nhập "+e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }while (true);
    }

    private static void addVilla() {
        String code = inputCodeFacility();
        String name = inputNameFacility();
        Double acreage = inputAcreageFacility();
        Long costsRental = inputCostsRentalFacility();
        Integer maximumPeople = inputMaximumPeopleFacility();
        String rentalType = inputRentalTypeFacility();
        String roomStandards = inputRoomStandards();


    }

    private static String inputRoomStandards() {
        String roomStandards = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập tiêu chuẩn phòng: ");
            roomStandards = scanner.nextLine();

        }
        return roomStandards;
    }

    private static String inputRentalTypeFacility() {
        String rentalType = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập loại hình thức thuê: ");
            rentalType = scanner.nextLine();
            if (rentalType.equals("giờ") || rentalType.equals("ngày") ||rentalType.equals("tháng") ||rentalType.equals("năm")){
                valid = true;
            }else {
                System.out.println("Loại hình thức thuê theo giờ, ngày, tháng, năm.");
            }
        }
        return rentalType;
    }

    private static Integer inputMaximumPeopleFacility() {
        Integer maximumPeople = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập số lượng người tối đa: ");
            maximumPeople = Integer.valueOf(scanner.nextLine());
            if (maximumPeople < 20 || maximumPeople > 0){
                valid = true;
            }else {
                System.out.println("Số lượng người tối đa phải > 0 và nhỏ hơn < 20");
            }
        }
        return maximumPeople;
    }

    private static Long inputCostsRentalFacility() {
        Long costsRental = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập chi phí thuê: ");
            costsRental = Long.valueOf(scanner.nextLine());
            if(costsRental > 0 ){
                valid = true;
            }else {
                System.out.println("Chi phí thuê phải là số dương");
            }
        }
        return costsRental;
    }

    private static Double inputAcreageFacility() {
        Double acreage = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập diện tích phòng: ");
            acreage = Double.valueOf(scanner.nextLine());
            if (acreage > 30){
                valid = true;
            }else {
                System.out.println("Diện tích sử dụng phải là số thực lớn hơn 30m2");
            }
        }
        return acreage;
    }

    private static String inputNameFacility() {
        String name = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập tên dich vụ: ");
            name = scanner.nextLine();
            if (Regex.checkRegexStr(PATH_NAME, name)){
                valid = true;
            }else {
                System.out.println("Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường");
            }
        }
        return name;
    }

    private static String inputCodeFacility() {
        String code = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập mã dịch vụ: ");
            code = scanner.nextLine();
            if (Regex.checkRegexStr(PATH_CODEVILLA, code)){
                valid = true;
            }else if (Regex.checkRegexStr(PATH_CODEHOUSE, code)){
                valid = true;
            }else if (Regex.checkRegexStr(PATH_CODEROOM, code)){
                valid = true;
            }else {
                System.out.println("Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:\n" +
                        "+ Nếu là Villa thì XX sẽ là VL\n" +
                        "+ Nếu là House thì XX sẽ là HO\n" +
                        "+ Nếu Room thì XX sẽ là RO");
            }
        }
        return code;
    }
}
