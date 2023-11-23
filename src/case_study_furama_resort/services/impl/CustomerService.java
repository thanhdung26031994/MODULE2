package case_study_furama_resort.services.impl;

import case_study_furama_resort.models.person.Customer;
import case_study_furama_resort.repositories.ICustomerRepository;
import case_study_furama_resort.repositories.impl.CustomerRepository;
import case_study_furama_resort.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private static ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.getAll();
    }

    @Override
    public boolean checkCodeCus(String code) {
        return iCustomerRepository.checkCodeCus(code);
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> findByCode(String code) {
        return iCustomerRepository.findByCode(code);
    }

    @Override
    public void editCustomer(String code, Object object, String key) {
        iCustomerRepository.editCustomer(code, object, key);
    }

    @Override
    public void removeCustomer(String code) {
        iCustomerRepository.removeCustomer(code);
    }

    @Override
    public boolean checkName(String name) {
        return iCustomerRepository.checkName(name);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findByName(name);
    }

}
