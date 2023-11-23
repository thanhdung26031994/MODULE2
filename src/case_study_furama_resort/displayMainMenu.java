package case_study_furama_resort;

import case_study_furama_resort.views.CustomerView;
import case_study_furama_resort.views.EmployeeView;
import case_study_furama_resort.views.FacilityView;

import java.util.Scanner;

public class displayMainMenu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            try{
                System.out.println("1. Quản lý nhân viên\n" +
                        "2. Quản lý khách hàng\n" +
                        "3. Quản lý cơ sở vật chất\n" +
                        "4. Quản lý đặt chỗ\n" +
                        "5. Quản lý khuyến mãi\n" +
                        "6. Thoát");
                System.out.print("Vui lòng chọn: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice){
                    case 1:
                        EmployeeView.employeeMenu();
                        break;
                    case 2:
                        CustomerView.customerMenu();
                        break;
                    case 3:
                        FacilityView.facilityMenu();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.exit(6);
                    default:
                        System.out.println("Vui lòng chọn đúng.");
                }
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }
        }while (true);

    }
}
