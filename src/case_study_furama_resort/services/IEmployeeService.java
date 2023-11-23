package case_study_furama_resort.services;

import case_study_furama_resort.models.person.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void addEmployee(Employee employee);

    boolean checkCode(String code);

    List<Employee> findByCode(String code);

    void removeEmployee(String code);

    void editName(String code, String nameUp);

    void editData(String code, String dataUp);

    void editGender(String code, String genderUp);

    List<Employee> findByName(String name);

    void editIdNumber(String code, String idNumber);

    void editEmail(String code, String emailUp);

    void editLevel(String code, String levelUp);

    void editPhone(String code, String phoneUp);

    void editLocation(String code, String locationUp);

    void editWage(String code, Long wageUp);

    boolean checkName(String name);

    void editEmployee(String code, Object nameUp, String key);
}
