package ss13_search.view;

import ss13_search.controller.JobController;
import ss13_search.model.Job;
import ss13_search.utils.RegexJob;

import java.util.List;
import java.util.Scanner;

public class JobMenu {
    private static final Scanner IN = new Scanner(System.in);
    private static final JobController jobController = new JobController();
    private static Job job;
    private static final String REGEX_CODE = "^CV-[0-9]{3}$";
    private static final String REGEX_DATA = "^(0?[1-9]|1[012])[- /.](0?[1-9]|[12][0-9]|3[01])[- /.](19|20)?[0-9]{2}$";


    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("-------Chức năng-------\n" +
                    "1. Hiển thị danh sách. \n" +
                    "2. Thêm công việc.\n" +
                    "3. Xoá công việc.\n" +
                    "4. Sửa công việc.\n" +
                    "5. Tìm kiếm theo mã chỉ tiêu.\n" +
                    "6. Tìm kiếm gần đúng theo tên chỉ tiêu.\n" +
                    "7. Sắp xếp theo tên tăng dần. \n" +
                    "8. Sắp xếp theo số tiền giảm dần, nếu số tiền chi giống nhau thì sắp xếp theo tên tăng dần.\n" +
                    "0. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = Integer.parseInt(IN.nextLine());
            switch (choice) {
                case 1:
                    displayJob();
                    break;
                case 2:
                    addJob();
                    break;
                case 3:
                    deleteJob();
                    break;
                case 4:
                    editJob();
                    break;
                case 5:
                    searchCode();
                    break;
                case 6:
                    searchNameJob();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn đúng.");
            }
        } while (true);

    }

    private static void searchNameJob() {
        System.out.print("Nhập tên tìm kiếm: ");
        String name = IN.nextLine();
        if (jobController.findByName(name) == null){
            System.out.println("Không có tên công việc cần tìm.");
        }else {
            System.out.println(jobController.findByName(name));
        }
    }


    private static void searchCode() {
        System.out.print("Nhập mã muốn tìm:");
        String code = IN.nextLine();
        if (jobController.checkCode(code)) {
            job = jobController.findByCode(code);
            System.out.println(job);
        } else {
            System.out.println("Không có mã muốn tìm.");
        }
    }

    private static void editJob() {
        System.out.print("Nhập mã muốn sửa:");
        String code = IN.nextLine();
        if (jobController.checkCode(code)) {
            job = inputInform();
            jobController.editJob(code, job);
            System.out.println("Sửa thành công.");
        } else {
            System.out.println("Không mã muốn sửa.");
        }
    }

    private static void deleteJob() {
        System.out.println("Nhập mã muốn xoá: ");
        String code = IN.nextLine();
        if (jobController.checkCode(code)) {
            jobController.removeJob(code);
            System.out.println("Xoá thành công.");
        } else {
            System.out.println("Không có mã này.");
        }
    }

    private static void addJob() {
        String code = inputCode();
        job = inputInform();
        job.setCode(code);
        jobController.addJob(job);
        System.out.println("Thêm sản phẩm thành công.");
    }

    private static Job inputInform() {
        String name = inputName();
        String data = inputData();
        Long money = inputMoney();
        String describe = inputDescribe();
        return new Job(name, data, money, describe);
    }

    private static String inputDescribe() {
        String describe = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Nhập mô tả: ");
            describe = IN.nextLine();
            if (!describe.isEmpty()) {
                valid = true;
            } else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return describe;
    }

    private static Long inputMoney() {
        Long money = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Nhập số tiền chi: ");
            money = Long.parseLong(IN.nextLine());
            if (money > 0) {
                valid = true;
            } else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return money;
    }

    private static String inputData() {
        String data = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Nhập ngày chi tiêu (mm/dd/YYYY): ");
            data = IN.nextLine();
            if (RegexJob.regexCheckStr(REGEX_DATA, data)) {
                valid = true;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng.");
            }
        }
        return data;
    }

    private static String inputName() {
        String name = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Nhập tên chi tiêu: ");
            name = IN.nextLine();
            if (!name.isEmpty()) {
                valid = true;
            } else {
                System.out.println("Vui lòng nhập đúng.");
            }
        }
        return name;
    }

    private static String inputCode() {
        String code = null;
        boolean valid = false;
        while (!valid) {
            System.out.println("Nhập mã (CV-xxx): ");
            code = IN.nextLine();
            if (jobController.checkCode(code)) {
                System.out.println("Mã này đã tồn tại.");
                continue;
            }
            valid = true;
        }
        return code;
    }

    private static void displayJob() {
        List<Job> jobList = jobController.getAll();
        if (jobList.isEmpty()) {
            System.out.println("Không có công việc nào hết.");
        } else {
            System.out.println("-------------------");
            System.out.println("Danh sách công việc");
            for (Job job : jobList) {
                System.out.println(job);
            }
        }
    }
}
