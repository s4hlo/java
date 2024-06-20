package database;

import java.util.HashMap;
import java.util.Map;
import entity.Entity;
import java.util.Optional;
import java.util.List;

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
    return instance;
  }

  public <T extends Entity> void save(Class<T> clazz, T entity) {
    if (!tables.containsKey(clazz)) {
      tables.put(clazz, new DatabaseTable<T>());
    }
    DatabaseTable<T> table = (DatabaseTable<T>) tables.get(clazz);
    table.save(entity);
  }

  public <T extends Entity> Optional<T> findById(Class<T> clazz, int id) {
    if (!tables.containsKey(clazz)) {
      tables.put(clazz, new DatabaseTable<T>());
    }
    return ((DatabaseTable<T>) tables.get(clazz)).findById(id);
  }

  public <T extends Entity> List<T> findAll(Class<T> clazz) {
    if (!tables.containsKey(clazz)) {
      tables.put(clazz, new DatabaseTable<T>());
    }
    return (List<T>) tables.get(clazz).findAll();
  }

  public <T extends Entity> void update(Class<T> clazz, int id, T entity) {
    if (!tables.containsKey(clazz)) {
      tables.put(clazz, new DatabaseTable<T>());
    }
    DatabaseTable<T> table = (DatabaseTable<T>) tables.get(clazz);
    table.update(id, entity);
  }

  public <T extends Entity> void delete(Class<T> clazz, int id) {
    if (!tables.containsKey(clazz)) {
      tables.put(clazz, new DatabaseTable<T>());
    }
    tables.get(clazz).delete(id);
  }
}
