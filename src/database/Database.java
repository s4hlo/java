package database;

import java.util.HashMap;
import java.util.Map;
import entity.Customer;
import entity.Entity;

public class Database {
  private static Database instance;
  private Map<Class<? extends Entity>, DatabaseTable<? extends Entity>> tables;

  private Database() {
    tables = new HashMap<>();
  }

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
    }
    DatabaseTable<Customer> customerTable = new DatabaseTable<>();
    instance.addTable(Customer.class, customerTable);
    return instance;
  }

  public <T extends Entity> void addTable(Class<T> entityClass, DatabaseTable<T> table) {
    tables.put(entityClass, table);
  }

  public <T extends Entity> DatabaseTable<T> getTable(Class<T> entityClass) {
    DatabaseTable<T> table = (DatabaseTable<T>) tables.get(entityClass);
    return table;
  }
}
