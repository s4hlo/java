package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entity.Entity;
import exception.EntityNotFoundException;

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
    T entity = entities.get(id);
    if (entity == null) {
      throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    }
    return Optional.of(entity);
  }

  @Override
  public List<T> findAll() {
    return new ArrayList<>(entities.values());
  }

  @Override
  public void update(int id, T entity) {
    if (!entities.containsKey(id)) {
      throw new EntityNotFoundException("Entity with ID " + id + " not found, cannot update.");
    }
    entity.setId(id);
    entities.put(id, entity);
  }

  @Override
  public void delete(int id) {
    if (!entities.containsKey(id)) {
      throw new EntityNotFoundException("Entity with ID " + id + " not found, cannot delete.");
    }
    entities.remove(id);
  }
}
