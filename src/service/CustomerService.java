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

  public List<Customer> getFilteredCustomers() {
    return customerDao.findAll(customer -> customer.getAge() > 30);
  }

  public List<Customer> getSortedCustomers() {
    return customerDao.findAll((c1, c2) -> c1.getName().compareTo(c2.getName()));
  }

  public List<Customer> getSortedCustomersByAge() {
    return customerDao.findAll((c1, c2) -> c1.getAge() - c2.getAge());
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
