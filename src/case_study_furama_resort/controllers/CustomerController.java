package case_study_furama_resort.controllers;

import case_study_furama_resort.models.person.Customer;
import case_study_furama_resort.services.ICustomerService;
import case_study_furama_resort.services.impl.CustomerService;

import java.util.List;

public class CustomerController {
    private static ICustomerService iCustomerService = new CustomerService();
    public List<Customer> getAll() {
        return iCustomerService.getAll();
    }

    public boolean checkCodeCus(String code) {
        return iCustomerService.checkCodeCus(code);
    }

    public void addCustomer(Customer customer) {
        iCustomerService.addCustomer(customer);
    }

    public List<Customer> findByCode(String code) {
        return iCustomerService.findByCode(code);
    }

    public void editCustomer(String code, Object object, String key) {
        iCustomerService.editCustomer(code, object, key);
    }

    public void removeCustomer(String code) {
        iCustomerService.removeCustomer(code);
    }

    public boolean checkName(String name) {
        return iCustomerService.checkName(name);
    }

    public List<Customer> findByName(String name) {
        return iCustomerService.findByName(name);
    }
}
