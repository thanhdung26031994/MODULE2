package ss19_string_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    private static Scanner scanner = new Scanner(System.in);
    private static String PATH_EMAIL = "^[A-Za-z0-9\\._]{6,32}@([A-Za-z0-9]{2,12}\\.){1,2}[A-Za-z0-9]{2,12}$";
    private static String inputEmail(){
        String email = null;
        boolean valid = false;
        while (!valid){
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (regexEmail(PATH_EMAIL, email)){
                valid = true;
                System.out.println("Nhập thành công.");
            }else {
                System.out.println("Chứa các ký tự từ A đến Z, a đến z\t\t\t\n" +
                        "Các ký tự số\t\t\t\n" +
                        "Ký tự gạch dưới\t\t\t\n" +
                        "Ký tự @\t\t\t\n" +
                        "Các ký tự trước @ có 6-32 ký tự\t\t\t\n" +
                        "Chuỗi ký tự sau @ chia thành hai phần của domain mỗi phần có 2-12 ký tự\t\t\t\n");
            }
        }
        return email;
    }
    private static boolean regexEmail(String path, String email){
        Pattern pattern = Pattern.compile(path);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void main(String[] args) {
        inputEmail();
    }
}
