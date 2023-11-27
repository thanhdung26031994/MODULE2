package case_study_furama_resort.views;

import case_study_furama_resort.controllers.EmployeeController;
import case_study_furama_resort.models.person.Employee;
import case_study_furama_resort.utils.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {

    private static Scanner in = new Scanner(System.in);
    private static EmployeeController employeeController = new EmployeeController();
    private static int choice;
    private static final String PATH_CODE = "^NV-[0-9]{4}$";
    private static final String PATH_NAME = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}(?<=^.{1,50}$)$";
    private static final String PATH_IDNUMBER = "^[0-9]{9,12}$";
    private static final String PATH_PHONE = "^0[0-9]{9}$";
    private static final String PATH_EMAIL = "^[A-Za-z0-9\\._]{6,32}@([A-Za-z0-9]{2,12}\\.){1,2}[A-Za-z0-9]{2,12}$";
    public static void employeeMenu() {
        do {
            try {
                System.out.println("-----------------------------------");
                System.out.println("1. Hiển thị danh sách nhân viên\n" +
                        "2. Thêm nhân viên mới\n" +
                        "3. Chỉnh sửa nhân viên\n" +
                        "4. Xóa nhân viên\n" +
                        "5. Tìm kiếm theo tên nhân viên\n" +
                        "6. Trở về menu chính");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        displayEmployee();
                        break;
                    case 2:
                        addEmployee();
                        break;
                    case 3:editEmployee();
                        break;
                    case 4:
                        deleteEmployee();
                        break;
                    case 5:
                        searchByName();
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

    private static void searchByName() {
        String name = inputNameEmp();
        if (employeeController.checkName(name)){
            List<Employee> employees = employeeController.findByName(name);
            System.out.println("-----------------------------------");
            System.out.println("Thông tin nhân viên muốn tìm theo tên: ");
            System.out.println(employees);
        }else {
            System.out.println("Không có thông tin cần tìm.");
        }
    }

    private static void editEmployee() {
        String code = inputCodeEmp();
        if (employeeController.checkCode(code)){
            editInform(code);
        }else {
            System.out.println("Không có mã nhân viên này.");
        }
    }

    private static void editInform(String code) {
        List<Employee> employees;
        do {
            try {
                employees = employeeController.findByCode(code);
                System.out.println("-----------------------------------");
                System.out.println("Thông tin nhân viên muốn sửa: ");
                System.out.println(employees);
                System.out.println("Chọn danh mục muốn sửa: \n" +
                        "1. Tên nhân viên.\n" +
                        "2. Ngày sinh. \n" +
                        "3. Giới tính.\n" +
                        "4. Số CMND. \n" +
                        "5. Số điên thoại.\n" +
                        "6. Email.\n" +
                        "7. Trình độ.\n" +
                        "8. Vị trí.\n" +
                        "9. Mức lương.\n" +
                        "0. Quay lại.");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        String nameUp = inputNameEmp();
                        employeeController.editEmployee(code, nameUp, "name");
                        System.out.println("Sửa tên thành công.");
                        break;
                    case 2:
                        String dateUp = inputDateEmp();
                        employeeController.editEmployee(code, dateUp, "date");
                        System.out.println("Sửa ngày sinh thành công.");
                        break;
                    case 3:
                        String genderUp = inputGenderEmp();
                        employeeController.editGender(code, genderUp);
                        System.out.println("Sửa giới tính thành công.");
                        break;
                    case 4:
                        String idNumber = inputIdNumberEmp();
                        employeeController.editIdNumber(code, idNumber);
                        System.out.println("Sửa số CMND thành công.");
                        break;
                    case 5:
                        String phoneUp = inputPhoneEmp();
                        employeeController.editPhone(code, phoneUp);
                        System.out.println("Sửa số điện thoại thành công.");
                    case 6:
                        String emailUp = inputEmailEmp();
                        employeeController.editEmail(code, emailUp);
                        System.out.println("Sửa email thành công.");
                        break;
                    case 7:
                        String levelUp = inputLevelEmp();
                        employeeController.editLevel(code, levelUp);
                        System.out.println("Sửa trình độ thành công.");
                        break;
                    case 8:
                        String locationUp = intputLocation();
                        employeeController.editLocation(code, locationUp);
                        System.out.println("Sửa vị trí thành công.");
                        break;
                    case 9:
                        Long wageUp = inputWageEmp();
                        employeeController.editWage(code,wageUp);
                        System.out.println("Sửa mức lương thành công.");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }while (true);
    }


    private static void deleteEmployee() {
        String code = inputCodeEmp();
        if (employeeController.checkCode(code)){
            List<Employee> employees = employeeController.findByCode(code);
            System.out.println("-----------------------------------");
            System.out.println("Thông tin nhân viên muốn xoá: ");
            System.out.println(employees);
            System.out.print("Bạn có muốn xoá nhân viên này chọn Đúng(y) hoặc Không(n): ");
            String yesNo = in.nextLine();
            if (yesNo.equalsIgnoreCase("y")){
                employeeController.removeEmployee(code);
            }else if (yesNo.equalsIgnoreCase("n")){
                return;
            }
        }else {
            System.out.println("Không có mã nhân viên này.");
        }
    }

    private static void addEmployee() {
        do {
            String code = inputCodeEmp();
            if (employeeController.checkCode(code)){
                System.out.println("Đã có mã nhân viên này.");
            }else {
                String name = inputNameEmp();
                String date = inputDateEmp();
                String gender = inputGenderEmp();
                String idNumber = inputIdNumberEmp();
                String phone = inputPhoneEmp();
                String email = inputEmailEmp();
                String level = inputLevelEmp();
                String location = intputLocation();
                Long wage = inputWageEmp();
                employeeController.addEmployee(new Employee(code, name, date, gender, idNumber, phone, email, level, location, wage));
                System.out.println("Thêm nhân viên thành công.");
            }
        }while (true);

    }

    private static Long inputWageEmp() {
        Long wage = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập mức lương (VND): ");
                wage = Long.parseLong(in.nextLine());
                if (wage > 0 || wage < 100000000){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return wage;
    }

    private static String intputLocation() {
        String location = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Chọn chức vụ: \n" +
                        "1. Lễ tân\n" +
                        "2. Phục vụ\n" +
                        "3. Chuyên viên\n" +
                        "4. Giám sát \n" +
                        "5. Quản lý \n" +
                        "6. Giám đốc.");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        location = "Lễ tân";
                        valid = true;
                        break;
                    case 2:
                        location = "Phục vụ";
                        valid = true;
                        break;
                    case 3:
                        location = "Chuyên viên";
                        valid = true;
                        break;
                    case 4:
                        location = "Giám sát";
                        valid = true;
                        break;
                    case 5:
                        location = "Quản lý";
                        valid = true;
                        break;
                    case 6:
                        location = "Giám đốc";
                        valid = true;
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return location;
    }

    private static String inputLevelEmp() {
        String level = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Chọn trình độ phù hợp: \n" +
                        "1. Trung cấp.\n" +
                        "2. Cao đẳng. \n" +
                        "3. Đại học \n" +
                        "4. Sau đại học.\n");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        level = "Trung cấp";
                        valid = true;
                        break;
                    case 2:
                        level = "Cao đẳng";
                        valid = true;
                        break;
                    case 3:
                        level = "Đại học";
                        valid = true;
                        break;
                    case 4:
                        level = "Sau đại học";
                        valid = true;
                        break;
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return level;
    }

    private static String inputEmailEmp() {
        String email = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.println("Nhập email: ");
                email = in.nextLine();
                if (Regex.checkRegexStr(PATH_EMAIL, email)){
                    valid = true;
                }else {
                    System.out.println("Theo định dạng tenmail@gmail.com");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return email;
    }

    private static String inputPhoneEmp() {
        String phone = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập số điện thoại: ");
                phone = in.nextLine();
                if (Regex.checkRegexStr(PATH_PHONE, phone)){
                    valid = true;
                }else {
                    System.out.println("Số điện thoại phải bắt đầu từ 0 và đủ 10 số.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return phone;
    }

    private static String inputIdNumberEmp() {
        String idNumber = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập số CMND (từ 9-12 số): ");
                idNumber = in.nextLine();
                if (Regex.checkRegexStr(PATH_IDNUMBER, idNumber)){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng theo định dạng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        return idNumber;
    }

    private static String inputGenderEmp() {
        String gender = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập giới tính (Nam, Nữ, LGBT): ");
                gender = in.nextLine();
                if (gender.equalsIgnoreCase("nam") || gender.equalsIgnoreCase("nữ") || gender.equalsIgnoreCase("lgbt")){
                    valid = true;
                }else {
                    System.out.println("Vui lòng nhập đúng.");
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return gender;
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

    private static String inputDateEmp() {
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
    private static String inputNameEmp() {
        String name = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập tên nhân viên: ");
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

    private static String inputCodeEmp() {
        String code = null;
        boolean valid = false;
        while (!valid){
            try {
                System.out.print("Nhập mã nhân viên (NV-YYYY, Y là số 0-9): ");
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

    private static void displayEmployee() {
        List<Employee> employees = employeeController.getAll();
        System.out.println("-------------------------------");
        System.out.println("Danh sách nhân viên khách sạn.");
        for (Employee employee: employees){
            System.out.println(employee);
        }
    }
}
