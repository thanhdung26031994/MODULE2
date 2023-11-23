package case_study_furama_resort.repositories;

import case_study_furama_resort.models.person.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAll();

    boolean checkCodeCus(String code);

    void addCustomer(Customer customer);

    List<Customer> findByCode(String code);


    void editCustomer(String code, Object object, String key);

    void removeCustomer(String code);

    boolean checkName(String name);

    List<Customer> findByName(String name);
}
