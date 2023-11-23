package case_study_furama_resort.controllers;

import case_study_furama_resort.models.person.Employee;
import case_study_furama_resort.services.IEmployeeService;
import case_study_furama_resort.services.impl.EmployeeService;

import java.util.List;

public class EmployeeController {
    private static IEmployeeService employeeService = new EmployeeService();
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    public boolean checkCode(String code) {
        return employeeService.checkCode(code);
    }

    public List<Employee> findByCode(String code) {
        return employeeService.findByCode(code);
    }

    public void removeEmployee(String code) {
        employeeService.removeEmployee(code);
    }

    public void editName(String code, String nameUp) {
        employeeService.editName(code, nameUp);
    }

    public void editData(String code, String dataUp) {
        employeeService.editData(code, dataUp);
    }

    public void editGender(String code, String genderUp) {
        employeeService.editGender(code,genderUp);
    }

    public List<Employee> findByName(String name) {
        return employeeService.findByName(name);
    }

    public void editIdNumber(String code, String idNumber) {
        employeeService.editIdNumber(code, idNumber);
    }

    public void editEmail(String code, String emailUp) {
        employeeService.editEmail(code, emailUp);
    }

    public void editLevel(String code, String levelUp) {
        employeeService.editLevel(code, levelUp);
    }

    public void editPhone(String code, String phoneUp) {
        employeeService.editPhone(code, phoneUp);
    }

    public void editLocation(String code, String locationUp) {
        employeeService.editLocation(code, locationUp);
    }

    public void editWage(String code, Long wageUp) {
        employeeService.editWage(code, wageUp);
    }

    public boolean checkName(String name) {
        return employeeService.checkName(name);
    }

    public void editEmployee(String code, Object nameUp, String key) {
        employeeService.editEmployee(code, nameUp, key);
    }
}
