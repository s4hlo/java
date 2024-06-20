package dao;

import entity.Entity;
import entity.Customer;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Predicate;
import java.util.Comparator;
import database.Database;
import database.DatabaseTable;
import dao.DAO;
import java.util.stream.Collectors;

public class CustomerDAO implements DAO<Customer> {
  private Database database;

  public CustomerDAO() {
    database = Database.getInstance();
  }

  @Override
  public void save(Customer entity) {
    database.save(Customer.class, entity);
  }

  @Override
  public Optional<Customer> findById(int id) {
    return database.findById(Customer.class, id);
  }

  @Override
  public List<Customer> findAll() {
    return database.findAll(Customer.class);
  }

  @Override
  public void update(int id, Customer entity) {
    database.update(Customer.class, id, entity);
  }

  @Override
  public void delete(int id) {
    database.delete(Customer.class, id);
  }

  @Override
  public List<Customer> findAll(Predicate<Customer> filter) {
    List<Customer> allCustomers = database.findAll(Customer.class);

    return allCustomers.stream()
        .filter(filter)
        .collect(Collectors.toList());
  }

  @Override
  public List<Customer> findAll(Comparator<Customer> comparator) {
    List<Customer> allCustomers = database.findAll(Customer.class);

    allCustomers.sort(comparator);

    return allCustomers;
  }

}
