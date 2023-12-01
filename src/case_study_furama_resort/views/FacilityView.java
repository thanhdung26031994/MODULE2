package case_study_furama_resort.views;

import case_study_furama_resort.controllers.FacilityController;
import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.facility.House;
import case_study_furama_resort.models.facility.Room;
import case_study_furama_resort.models.facility.Villa;
import case_study_furama_resort.utils.Regex;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityView {
    private static final Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static final FacilityController facilityController = new FacilityController();
    private static final String PATH_VILLA = "^SVVL-[0-9]{4}$";
    private static final String PATH_HOUSE = "^SVHO-[0-9]{4}$";
    private static final String PATH_ROOM = "^SVRO-[0-9]{4}$";
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
                        displayMaintenance();
                        break;
                    case 4:
                        deleteFacility();
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

    private static void deleteFacility() {
        System.out.println("Nhập thông tin để xoá.");
        String code = inputCodeFacility();
        if (facilityController.checkCode(code)){
            System.out.println("Bạn có chắc muốn xoá: \n" +
                    "1. Vâng \n" +
                    "2. Không");
            System.out.println("Vui lòng chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    facilityController.deleteFacility(code);
                    System.out.println("Xoá thành công.");
                    break;
                case 2:
                    System.out.println("Đã huỷ.");
                default:
                    System.out.println("Vui lòng nhập đúng");
            }
        }else {
            System.out.println("Không có sản phẩm bạn muốn xoá.");
        }

    }

    private static void displayMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.displayMaintenance();
        Set<Facility> set = facilityIntegerMap.keySet();
        if (facilityIntegerMap.isEmpty()){
            System.out.println("Hiện không có sản phẩm nào bảo trì.");
        }else {
            System.out.println("Danh sách sản phẩm bảo trì.");
            for (Facility facility: set){
                System.out.println(facility);
            }
        }
    }

    public static void displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityController.getAll();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        if (facilityIntegerMap.isEmpty()){
            System.out.println("Hiện tại chưa có dịch vụ nào cả.");
        }else {
            for (Facility facility: facilitySet){
                if (facility instanceof Villa){
                    System.out.println("Mã dịch vụ: " + facility.getCodeService() +
                            ", Tên dịch vụ:" + facility.getNameService() +
                            ", Diện tích cho thuê: " + facility.getAcreage() +
                            ", Chi phí thuê: " + facility.getCostsRental() +
                            ", Số người tối đa: " + facility.getMaximumPeople() +
                            ", Kiểu thuê: " + facility.getRentalType() +
                            ", Tiêu chuẩn phòng: " + ((Villa) facility).getRoomStandards() +
                            ", Diện tích hồ bơi: " + ((Villa) facility).getSwimmingArea() +
                            ", Số tầng: " + ((Villa) facility).getFloorsNumber() +
                            ", Số lần sử dụng: " + facilityIntegerMap.get(facility));
                }else if (facility instanceof House){
                    System.out.println("Mã dịch vụ: " + facility.getCodeService() +
                            ", Tên dịch vụ:" + facility.getNameService() +
                            ", Diện tích cho thuê: " + facility.getAcreage() +
                            ", Chi phí thuê: " + facility.getCostsRental() +
                            ", Số người tối đa: " + facility.getMaximumPeople() +
                            ", Kiểu thuê: " + facility.getRentalType() +
                            ", Tiêu chuẩn phòng: " + ((House) facility).getRoomStandards() +
                            ", Số tầng: " + ((House) facility).getFloorsNumber() +
                            ", Số lần sử dụng: " + facilityIntegerMap.get(facility));
                }else if (facility instanceof Room){
                    System.out.println("Mã dịch vụ: " + facility.getCodeService() +
                            ", Tên dịch vụ:" + facility.getNameService() +
                            ", Diện tích cho thuê: " + facility.getAcreage() +
                            ", Chi phí thuê: " + facility.getCostsRental() +
                            ", Số người tối đa: " + facility.getMaximumPeople() +
                            ", Kiểu thuê: " + facility.getRentalType() +
                            ", Dịch vụ miễn phí đi kèm: " + ((Room) facility).getFreeService()+
                            ", Số lần sử dụng: " + facilityIntegerMap.get(facility));
                }
            }
        }
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
                        addHouse();
                        break;
                    case 3:
                        addRoom();
                        break;
                    case 4:
                        return;
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

    private static void addRoom() {
        Facility facility = inputInformFacility();
        String freeService = inputFreeService();
        Facility facility1 = new Room(freeService);
        facilityController.addFacility(facility1, facility);
        System.out.println("Thêm thành công.");

    }

    private static String inputFreeService() {
        String freeService = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Chọn dịch vụ miễn phí đi kèm:");
                System.out.println("1. Miễn phí buffer buổi sáng.\n" +
                        "2. Miễn phí vé massage. \n" +
                        "3. Miễn phí vé xem phim tại bãi biển. ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        freeService = "Miễn phí buffer buổi sáng";
                        valid = true;
                        break;
                    case 2:
                        freeService = "Miễn phí vé massage.";
                        valid = true;
                        break;
                    case 3:
                        freeService = "Miễn phí vé xem phim tại bãi biển.";
                        valid = true;
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                e.getMessage();
            }
        }
        return freeService;
    }

    private static void addHouse() {
        Facility facility = inputInformFacility();
        String roomStandards = inputRoomStandards();
        Integer floorsNumber = inputFloorsNumber();
        Facility facility1 = new House(roomStandards, floorsNumber);
        facilityController.addFacility(facility1, facility);
        System.out.println("Thêm thành công.");
    }

    private static Facility inputInformFacility() {
        String code = inputCodeFacility();
        if (facilityController.checkCode(code)){
            String name = inputNameFacility();
            Double acreage = inputAcreageFacility();
            Long costsRental = inputCostsRentalFacility();
            Integer maximumPeople = inputMaximumPeopleFacility();
            String rentalType = inputRentalTypeFacility();
            return new Facility(code, name, acreage, costsRental, maximumPeople, rentalType);
        }else {
            System.out.println("Đã có mã phòng này.");
        }
        return null;
    }

    private static void addVilla() {
        Facility facility = inputInformFacility();
        String roomStandards = inputRoomStandards();
        Integer swimmingArea = inputSwimmingArea();
        Integer floorsNumber = inputFloorsNumber();
        Facility facility1 = new Villa(roomStandards, swimmingArea, floorsNumber);
        facilityController.addFacility(facility1, facility);
        System.out.println("Thêm thành công.");
    }

    private static Integer inputFloorsNumber() {
        Integer floorsNumber = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập số tầng: ");
            floorsNumber = Integer.valueOf(scanner.nextLine());
            if (floorsNumber > 0) {
                valid = true;
            } else if (floorsNumber >= 20) {
                System.out.println("Số tầng phải lớn hơn 0  và nhỏ hơn 20.");
            } else {
                valid = true;
            }
        }
        return floorsNumber;
    }

    private static Integer inputSwimmingArea() {
        Integer swimmingArea = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập diện tích hồ bơi: ");
            swimmingArea = Integer.valueOf(scanner.nextLine());
            if (swimmingArea > 30){
                valid = true;
            }else {
                System.out.println("Diện tích phải lớn hơn 30m2");
            }
        }
        return swimmingArea;
    }

    private static String inputRoomStandards() {
        String roomStandards = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập tiêu chuẩn phòng: ");
            roomStandards = scanner.nextLine();
            if (roomStandards.equalsIgnoreCase("sup") || roomStandards.equalsIgnoreCase("dlx") || roomStandards.equalsIgnoreCase("sut")){
                valid = true;
            }else {
                System.out.println("Phòng Superior (SUP), Phòng Deluxe (DLX), Phòng Suite (SUT) \n" +
                        "Nhập theo từ viết tắc. Cảm ơn.");
            }
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
            if (Regex.checkRegexStr(PATH_VILLA, code)){
                valid = true;
            }else if (Regex.checkRegexStr(PATH_HOUSE, code)){
                valid = true;
            }else if (Regex.checkRegexStr(PATH_ROOM, code)){
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
