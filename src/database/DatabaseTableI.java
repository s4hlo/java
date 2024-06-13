package database;

import entity.Entity;
import java.util.Optional;
import java.util.List;

public interface DatabaseTableI<T extends Entity> {
  void save(T entity);
  Optional<T> findById(int id);
  List<T> findAll();
  void update(int id, T entity);
  void delete(int id);
}
