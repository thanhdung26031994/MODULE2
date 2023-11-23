package case_study_furama_resort.utils.csv_file;

import case_study_furama_resort.models.person.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvCustomer {
    private static final String PATH = "src/case_study_furama_resort/data/customer.csv";

    public static void writeToFile(List<Customer> customers){
        File file = new File(PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer: customers){
                bufferedWriter.write(customer.getCode() +
                        "," + customer.getName() +
                        "," + customer.getData() +
                        "," + customer.getGender() +
                        "," + customer.getIdNumber() +
                        "," + customer.getPhone() +
                        "," + customer.getEmail() +
                        "," + customer.getTypeGuest() +
                        "," + customer.getAddress());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileWriter != null;
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Customer> readToFile(){
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        File file = new File(PATH);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String temp;
            String[] tempStr;
            while ((temp = bufferedReader.readLine()) != null){
                tempStr = temp.split(",");
                customer = new Customer(tempStr[0], tempStr[1], tempStr[2], tempStr[3], tempStr[4],
                        tempStr[5], tempStr[6], tempStr[7], tempStr[8]);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert fileReader != null;
                fileReader.close();
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }
}
