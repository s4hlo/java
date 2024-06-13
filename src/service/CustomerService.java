package service;

import dao.CustomerDAO;
import entity.Customer;

import java.util.List;
import java.util.Optional;
import dao.CustomerDAO;

public class CustomerService {
    private CustomerDAO customerDao = new CustomerDAO();

    public void add(Customer customer) {
        customerDao.save(customer);
    }

    public Optional<Customer> getById(int id) {
        return customerDao.findById(id);
    }

    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    public void update(int id, Customer customer) {
        customerDao.update(id, customer);
    }

    public void delete(int id) {
        customerDao.delete(id);
    }
}
