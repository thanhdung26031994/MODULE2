package case_study_furama_resort.repositories.impl;

import case_study_furama_resort.models.person.Employee;
import case_study_furama_resort.repositories.IEmployeeRepository;
import case_study_furama_resort.utils.csv_file.CsvEmployee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public List<Employee> getAll() {
        return CsvEmployee.readToFile();
    }

    @Override
    public void addEmployee(Employee employee) {
        List<Employee> employees = CsvEmployee.readToFile();
        employees.add(employee);
        CsvEmployee.writeToFile(employees);
    }

    @Override
    public boolean checkCode(String code) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Employee> findByCode(String code) {
        List<Employee> employees = CsvEmployee.readToFile();
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee: employees){
            if (employee.getCode().contains(code)){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public void removeEmployee(String code) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().contains(code)){
                employees.remove(employee);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editName(String code, String nameUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setName(nameUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editData(String code, String dataUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setData(dataUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editGender(String code, String genderUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setGender(genderUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editIdNumber(String code, String idNumber) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setIdNumber(idNumber);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editEmail(String code, String emailUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setEmail(emailUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editLevel(String code, String levelUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setLevel(levelUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editPhone(String code, String phoneUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setPhone(phoneUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editLocation(String code, String locationUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setLocation(locationUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editWage(String code, Long wageUp) {
        List<Employee> employees = CsvEmployee.readToFile();
        for (Employee employee: employees){
            if (employee.getCode().equalsIgnoreCase(code)){
                employee.setWage(wageUp);
                CsvEmployee.writeToFile(employees);
            }
        }
    }

    @Override
    public void editEmployee(String code, Object nameUp, String key) {
        List<Employee> employees = CsvEmployee.readToFile();

        switch (key) {
            case "name":
                for (Employee employee: employees){
                    if (employee.getCode().equalsIgnoreCase(code)){
                        employee.setName((String) nameUp);
                    }
                }
                break;
            case "date":
                for (Employee employee: employees){
                    if (employee.getCode().equalsIgnoreCase(code)){
                        employee.setData((String) nameUp);
                    }
                }
                break;

        }
        CsvEmployee.writeToFile(employees);
    }
}
