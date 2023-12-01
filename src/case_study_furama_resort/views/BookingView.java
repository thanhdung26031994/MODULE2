package case_study_furama_resort.views;

import case_study_furama_resort.controllers.CustomerController;
import case_study_furama_resort.controllers.EmployeeController;
import case_study_furama_resort.controllers.FacilityController;
import case_study_furama_resort.models.facility.Facility;
import case_study_furama_resort.models.person.Customer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookingView {
    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static final CustomerController customerController = new CustomerController();
    private static final EmployeeController employeeController = new EmployeeController();
    private static final FacilityController facilityController = new FacilityController();

    public static void bookingMenu() {
        do {
            System.out.println("1. Thêm đặt chỗ mới\n" +
                    "2. Hiển thị danh sách đặt phòng\n" +
                    "3. Tạo hợp đồng mới\n" +
                    "4. Hiển thị danh sách hợp đồng\n" +
                    "5. Chỉnh sửa hợp đồng\n" +
                    "6. Quay lại menu chính");
            System.out.print("Vui lòng chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addBooking();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Vui lòng nhập đúng.");
            }
        }while (true);
    }

    private static void addBooking() {
        System.out.println("Danh sách khách hàng: ");
        CustomerView.displayCustomer();
        System.out.println("--------------------------");
        System.out.println("Danh sách dịch vụ: ");
        FacilityView.displayFacility();
    }


}
