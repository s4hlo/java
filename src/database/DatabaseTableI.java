package database;

import entity.Entity;
import exception.DatabaseException;

import java.util.Optional;
import java.util.List;

public interface DatabaseTableI<T extends Entity> {
  void save(T entity) throws DatabaseException;

  Optional<T> findById(int id) throws DatabaseException;

  List<T> findAll() throws DatabaseException;

  void update(int id, T entity) throws DatabaseException;

  void delete(int id) throws DatabaseException;
}
