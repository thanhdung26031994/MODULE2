package case_study_furama_resort.services.impl;

import case_study_furama_resort.models.person.Employee;
import case_study_furama_resort.repositories.IEmployeeRepository;
import case_study_furama_resort.repositories.impl.EmployeeRepository;
import case_study_furama_resort.services.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private static IEmployeeRepository iEmployeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> getAll() {
        return iEmployeeRepository.getAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        iEmployeeRepository.addEmployee(employee);
    }

    @Override
    public boolean checkCode(String code) {
        return iEmployeeRepository.checkCode(code);
    }

    @Override
    public List<Employee> findByCode(String code) {
        return  iEmployeeRepository.findByCode(code);
    }

    @Override
    public void removeEmployee(String code) {
        iEmployeeRepository.removeEmployee(code);
    }

    @Override
    public void editName(String code, String nameUp) {
        iEmployeeRepository.editName(code, nameUp);
    }

    @Override
    public void editData(String code, String dataUp) {
        iEmployeeRepository.editData(code,dataUp);
    }

    @Override
    public void editGender(String code, String genderUp) {
        iEmployeeRepository.editGender(code, genderUp);
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employees = iEmployeeRepository.getAll();
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee: employees){
            if (employee.getName().toLowerCase().contains(name.toLowerCase())){
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    @Override
    public void editIdNumber(String code, String idNumber) {
        iEmployeeRepository.editIdNumber(code, idNumber);
    }

    @Override
    public void editEmail(String code, String emailUp) {
        iEmployeeRepository.editEmail(code, emailUp);
    }

    @Override
    public void editLevel(String code, String levelUp) {
        iEmployeeRepository.editLevel(code, levelUp);
    }

    @Override
    public void editPhone(String code, String phoneUp) {
        iEmployeeRepository.editPhone(code, phoneUp);
    }

    @Override
    public void editLocation(String code, String locationUp) {
        iEmployeeRepository.editLocation(code,locationUp);
    }

    @Override
    public void editWage(String code, Long wageUp) {
        iEmployeeRepository.editWage(code,wageUp);
    }

    @Override
    public boolean checkName(String name) {
        List<Employee> employees = iEmployeeRepository.getAll();
        for (Employee employee: employees){
            if (employee.getName().toLowerCase().contains(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void editEmployee(String code, Object nameUp, String key) {
        iEmployeeRepository.editEmployee(code, nameUp, key);
    }
}
