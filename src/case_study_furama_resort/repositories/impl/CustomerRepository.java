package case_study_furama_resort.repositories.impl;

import case_study_furama_resort.models.person.Customer;
import case_study_furama_resort.models.person.Employee;
import case_study_furama_resort.repositories.ICustomerRepository;
import case_study_furama_resort.utils.csv_file.CsvCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> getAll() {
        return CsvCustomer.readToFile();
    }

    @Override
    public boolean checkCodeCus(String code) {
        List<Customer> customers = getAll();
        for (Customer customer: customers){
            if (customer.getCode().equalsIgnoreCase(code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<Customer> customers = getAll();
        customers.add(customer);
        CsvCustomer.writeToFile(customers);
    }

    @Override
    public List<Customer> findByCode(String code) {
        List<Customer> customers = getAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers){
            if (customer.getCode().equalsIgnoreCase(code)){
                customerList.add(customer);
            }
        }
        return customerList;
    }

    @Override
    public void editCustomer(String code, Object object, String key) {
        List<Customer> customers = getAll();
        switch (key){
            case "name":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setName((String) object);
                    }
                }
                break;
            case "date":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setData((String) object);
                    }
                }
                break;
            case "gender":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setGender((String) object);
                    }
                }
                break;
            case "idNumber":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setIdNumber((String) object);
                    }
                }
                break;
            case "phone":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setPhone((String) object);
                    }
                }
                break;
            case "email":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setEmail((String) object);
                    }
                }
                break;
            case "guest":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setTypeGuest((String) object);
                    }
                }
                break;
            case "address":
                for (Customer customer: customers){
                    if (customer.getCode().equalsIgnoreCase(code)){
                        customer.setAddress((String) object);
                    }
                }
                break;
        }
        CsvCustomer.writeToFile(customers);
    }

    @Override
    public void removeCustomer(String code) {
        List<Customer> customers = getAll();
        for (Customer customer: customers){
            if (customer.getCode().equalsIgnoreCase(code)){
                customers.remove(customer);
                CsvCustomer.writeToFile(customers);
            }
        }
    }

    @Override
    public boolean checkName(String name) {
        List<Customer> customers = getAll();
        for (Customer customer: customers){
            if (customer.getName().toLowerCase().contains(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customers = getAll();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers){
            if (customer.getName().toLowerCase().contains(name.toLowerCase())){
                customerList.add(customer);
            }
        }
        return customerList;
    }

}
