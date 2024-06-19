package dao;

import entity.Entity;
import entity.Customer;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import database.Database;
import database.DatabaseTable;
import dao.DAO;

public class CustomerDAO implements DAO<Customer> {
  private DatabaseTable<Customer> table;

  private Database database = Database.getInstance();

  public CustomerDAO() {
    Database database = Database.getInstance();
    table = database.getTable(Customer.class);
    if (table == null) {
      table = new DatabaseTable<>();
      database.addTable(Customer.class, table);
    }
  }

  @Override
  public void save(Customer entity) {
    table.save(entity);
  }

  @Override
  public Optional<Customer> findById(int id) {
    return table.findById(id);
  }

  @Override
  public List<Customer> findAll() {
    return table.findAll();
  }

  // @Override
  // public List<Customer> findAll(Predicate<Customer> filter) {
  // }
  //
  // @Override
  // public List<Customer> findAll(Comparator<Customer> comparator) {
  // }

  @Override
  public void update(int id, Customer entity) {
    table.update(id, entity);
  }

  @Override
  public void delete(int id) {
    table.delete(id);
  }
}
