package case_study_furama_resort.views;

import case_study_furama_resort.controllers.CustomerController;
import case_study_furama_resort.models.person.Customer;
import case_study_furama_resort.utils.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static Scanner in = new Scanner(System.in);
    private static CustomerController customerController = new CustomerController();
    private static int choice;
    private static final String PATH_CODE = "^KH-[0-9]{4}$";
    public static final String PATH_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}(?<=^.{1,50}$)$";
    private static final String PATH_IDNUMBER = "^[0-9]{9}|[0-9]{12}$";
    private static final String PATH_PHONE = "^0[0-9]{9}$";
    private static final String PATH_EMAIL = "^[A-Za-z0-9\\._]{6,32}@([A-Za-z0-9]{2,12}\\.){1,2}[A-Za-z0-9]{2,12}$";
    public static void customerMenu() {
        do {
            try {
                System.out.println("-------------------------------------");
                System.out.println("1. Hiển thị danh sách khách hàng\n" +
                        "2. Thêm khách hàng mới\n" +
                        "3. Chỉnh sửa khách hàng\n" +
                        "4. Xóa khách hàng\n" +
                        "5. Tìm kiếm theo tên khách hàng\n" +
                        "6. Quay lại menu chính");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        displayCustomer();
                        break;
                    case 2:
                        addCustomer();
                        break;
                    case 3:
                        editCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        searchByNameCustomer();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }while (true);
    }

    private static void searchByNameCustomer() {
        String name = inputNameCus();
        if (customerController.checkName(name)){
            List<Customer> customers = customerController.findByName(name);
            System.out.println("-----------------------------------");
            System.out.println("Thông tin khách hàng muốn tìm theo tên: ");
            System.out.println(customers);
        }else {
            System.out.println("Không có tên khách hàng này.");
        }

    }

    private static void deleteCustomer() {
        System.out.println("---------------------------------");
        System.out.println("Nhập thông tin để xoá khách hàng.");
        String code  = inputCodeCus();
        if (customerController.checkCodeCus(code)){
            List<Customer> customers = customerController.findByCode(code);
            System.out.println(customers);
            System.out.println("Bạn có muốn xoá khách hàng này chọn Đúng(y) hoặc Không(n): ");
            String yesNo = in.nextLine();
            if (yesNo.equalsIgnoreCase("y")){
                customerController.removeCustomer(code);
                System.out.println("Xoá thành công.");
            }else if (yesNo.equalsIgnoreCase("n")){
                System.out.println("Bạn không xoá khách hàng này.");
                return;
            }
        }else {
            System.out.println("Không có khách hàng này trong danh sách.");
        }
    }

    private static void editCustomer() {
        String code = inputCodeCus();
        if (customerController.checkCodeCus(code)){
            inputInformCus(code);
        }else {
            System.out.println("Không có mã khách hàng này.");
        }
    }

    private static void inputInformCus(String code) {
        List<Customer> customers;
        do {
            try {
                customers = customerController.findByCode(code);
                System.out.println("---------------------------------");
                System.out.println("Thông tin khách hàng muốn sửa: ");
                System.out.println(customers);
                System.out.println("Chọn danh mục muốn sửa: \n" +
                        "1. Tên khách hàng.\n" +
                        "2. Ngày sinh. \n" +
                        "3. Giới tính.\n" +
                        "4. Số CMND. \n" +
                        "5. Số điên thoại.\n" +
                        "6. Email.\n" +
                        "7. Loại khách.\n" +
                        "8. Địa chỉ.\n" +
                        "0. Quay lại.");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        String nameUp = inputNameCus();
                        customerController.editCustomer(code, nameUp, "name");
                        System.out.println("Sửa tên thành công.");
                        break;
                    case 2:
                        String dateUp = inputDateCus();
                        customerController.editCustomer(code, dateUp, "date");
                        System.out.println("Sửa ngày sinh thành công.");
                        break;
                    case 3:
                        String genderUp = inputGenderCus();
                        customerController.editCustomer(code, genderUp, "gender");
                        System.out.println("Sửa giới tính thành công.");
                        break;
                    case 4:
                        String idNumberUp = inputIdNumberCus();
                        customerController.editCustomer(code, idNumberUp, "idNumber");
                        System.out.println("Sửa số CMND thành công.");
                        break;
                    case 5:
                        String phoneUp = inputPhoneCus();
                        customerController.editCustomer(code, phoneUp, "phone");
                        System.out.println("Sửa số điện thoại thành công");
                        break;
                    case 6:
                        String emailUp = inputEmailCus();
                        customerController.editCustomer(code, emailUp, "email");
                        System.out.println("Sửa email thành công");
                        break;
                    case 7:
                        String guestTypeUp = inputGuestCus();
                        customerController.editCustomer(code, guestTypeUp, "guest");
                        System.out.println("Sửa loại khách thành công");
                        break;
                    case 8:
                        System.out.println("Nhập địa chỉ khách: ");
                        String addressUp = in.nextLine();
                        customerController.editCustomer(code, addressUp, "address");
                        System.out.println("Sửa địa chỉ thành công.");
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }while (true);
    }

    private static void addCustomer() {
        String code = inputCodeCus();
        if (!customerController.checkCodeCus(code)){
            String name = inputNameCus();
            String date = inputDateCus();
            String gender = inputGenderCus();
            String idNumber = inputIdNumberCus();
            String phone = inputPhoneCus();
            String email = inputEmailCus();
            String guestType = inputGuestCus();
            System.out.println("Nhập địa chỉ khách: ");
            String address = in.nextLine();
            customerController.addCustomer(new Customer(code, name, date, gender, idNumber, phone, email, guestType, address));
            System.out.println("Thêm thành công khách hàng.");
        }else {
            System.out.println("Đã có mã khách hàng này.");
        }

    }

    private static String inputGuestCus() {
        String guestType = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập loại khách: ");
            guestType = in.nextLine();
            if (guestType.equalsIgnoreCase("đồng") || guestType.equalsIgnoreCase("bạc") || guestType.equalsIgnoreCase("vàng") || guestType.equalsIgnoreCase("kim cương")){
                valid = true;
            }else {
                System.out.println("Loại khách gồm: Đồng, Bạc, Vàng, Kim Cương");
            }
        }
        return guestType;
    }

    private static String inputEmailCus() {
        String emailCus = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Nhập email: ");
                emailCus = in.nextLine();
                if (Regex.checkRegexStr(PATH_EMAIL, emailCus)){
                    valid = true;
                }else {
                    System.out.println("Theo định dạng tenmail@gmail.com");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return emailCus;
    }

    private static String inputPhoneCus() {
        String phoneCus = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập số điện thoại: ");
                phoneCus = in.nextLine();
                if (Regex.checkRegexStr(PATH_PHONE, phoneCus)){
                    valid = true;
                }else {
                    System.out.println("Số điện thoại phải bắt đầu từ 0 và đủ 10 số.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return phoneCus;
    }

    private static String inputIdNumberCus() {
        String idNumberCus = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập số CMND (từ 9-12 số): ");
                idNumberCus = in.nextLine();
                if (Regex.checkRegexStr(PATH_IDNUMBER, idNumberCus)){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng theo định dạng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return idNumberCus;
    }

    private static String inputGenderCus() {
        String genderCus = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập giới tính (Nam, Nữ, LGBT): ");
                genderCus = in.nextLine();
                if (genderCus.equalsIgnoreCase("nam") || genderCus.equalsIgnoreCase("nữ") || genderCus.equalsIgnoreCase("lgbt")){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return genderCus;
    }

    private static boolean isValid(DateTimeFormatter dateTimeFormatter, boolean valid, String data){
        try {
            LocalDate localDate = LocalDate.parse(data, dateTimeFormatter);
            LocalDate today = LocalDate.now();
            Period age = Period.between(localDate, today);
            if (age.getYears() >= 18 && age.getYears() < 100){
                valid = true;
                System.out.println("Bạn đã đủ 18 tuổi.");
            }else {
                System.out.println("Bạn chưa đủ 18 tuổi. Nhập lại.");
            }
        }catch (Exception e){
            System.out.println("Ngày sinh không hợp lệ. Nhập lại");
        }
        return valid;
    }

    private static String inputDateCus() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = null;
        boolean valid = false;
        while (!valid){
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            date = in.nextLine();
            valid = isValid(formatter, valid, date);
        }
        return date;
    }

    private static String inputNameCus() {
        String name = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập tên khách hàng: ");
                name = in.nextLine();
                if (Regex.checkRegexStr(PATH_NAME, name)){
                    valid = true;
                }else {
                    System.out.println("Vui lòng viết hoa các ký tự đầu mỗi từ và không quá 50 kí tự.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return name;
    }

    private static String inputCodeCus() {
        String code = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập mã khách hàng (KH-YYYY, Y là số 0-9): ");
                code = in.nextLine();
                if (Regex.checkRegexStr(PATH_CODE, code)){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng theo định dạng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return code;
    }

    public static void displayCustomer() {
        List<Customer> customers = customerController.getAll();
        System.out.println("-------------------------------");
        System.out.println("Danh sách khách hàng.");
        for (Customer customer: customers){
            System.out.println(customer);
        }
    }
}
