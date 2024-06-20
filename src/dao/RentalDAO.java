package dao;

import entity.Rental;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import database.Database;
import java.util.stream.Collectors;

public class RentalDAO implements DAO<Rental> {
  private Database database;

  public RentalDAO() {
    database = Database.getInstance();
  }

  @Override
  public void save(Rental entity) {
    database.save(Rental.class, entity);
  }

  @Override
  public Optional<Rental> findById(int id) {
    return database.findById(Rental.class, id);
  }

  @Override
  public List<Rental> findAll() {
    return database.findAll(Rental.class);
  }

  @Override
  public void update(int id, Rental entity) {
    database.update(Rental.class, id, entity);
  }

  @Override
  public void delete(int id) {
    database.delete(Rental.class, id);
  }

  @Override
  public List<Rental> findAll(Predicate<Rental> filter) {
    List<Rental> allRentals = database.findAll(Rental.class);

    return allRentals.stream()
        .filter(filter)
        .collect(Collectors.toList());
  }

  @Override
  public List<Rental> findAll(Comparator<Rental> comparator) {
    List<Rental> allRentals = database.findAll(Rental.class);

    allRentals.sort(comparator);

    return allRentals;
  }

}

