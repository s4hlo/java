public interface DatabaseTableI<T extends Entity>  {
  void save(T entity) throws DatabaseException;
  Optional<T> findById(long id) throws DatabaseException;
  List<T> findAll() throws DatabaseException;
  void update(int id, T entity) throws DatabaseException;
  void delete(int id) throws DatabaseException;
}
