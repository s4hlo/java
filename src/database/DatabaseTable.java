package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entity.Entity;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
  private Map<Integer, T> entities = new HashMap<>();
  private int nextId = 1;

  @Override
  public void save(T entity) {
    int id = nextId++;
    entity.setId(id);
    entities.put(id, entity);
  }

  @Override
  public Optional<T> findById(int id) {
    if (!entities.containsKey(id)) {
      System.out.println("Entity with ID " + id + " not found.");
      return Optional.empty();
    }
    return Optional.of(entities.get(id));
  }

  @Override
  public List<T> findAll() {
    return new ArrayList<>(entities.values());
  }

  @Override
  public void update(int id, T entity) {
    if (!entities.containsKey(id)) {
      System.out.println("Entity with ID " + id + " not found, cannot update.");
      return;
    }
    entity.setId(id);
    entities.put(id, entity);
  }

  @Override
  public void delete(int id) {
    if (!entities.containsKey(id)) {
      System.out.println("Entity with ID " + id + " not found, cannot delete.");
      return;
    }
    entities.remove(id);
  }
}
