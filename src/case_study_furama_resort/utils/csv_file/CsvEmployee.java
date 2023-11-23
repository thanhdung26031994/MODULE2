package case_study_furama_resort.utils.csv_file;

import case_study_furama_resort.models.person.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvEmployee {
    private static final String PATH = "src/case_study_furama_resort/data/employee.csv";

    public static void writeToFile(List<Employee> employees){
        File file = new File(PATH);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee: employees){
                bufferedWriter.write(employee.getCode() +
                        "," + employee.getName() +
                        "," + employee.getData() +
                        "," + employee.getGender() +
                        "," + employee.getIdNumber() +
                        "," + employee.getPhone() +
                        "," + employee.getEmail() +
                        "," + employee.getLevel() +
                        "," + employee.getLocation() +
                        "," + employee.getWage());
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

    public static List<Employee> readToFile(){
        List<Employee> employees = new ArrayList<>();
        Employee employee;
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
                employee = new Employee(tempStr[0], tempStr[1], tempStr[2], tempStr[3], tempStr[4],
                        tempStr[5], tempStr[6], tempStr[7], tempStr[8], Long.parseLong(tempStr[9]));
                employees.add(employee);
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
        return employees;
    }
}
