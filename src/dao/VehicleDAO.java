package dao;

import entity.Vehicle;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import database.Database;
import java.util.stream.Collectors;

public class VehicleDAO implements DAO<Vehicle> {
  private Database database;

  public VehicleDAO() {
    database = Database.getInstance();
  }

  @Override
  public void save(Vehicle entity) {
    database.save(Vehicle.class, entity);
  }

  @Override
  public Optional<Vehicle> findById(int id) {
    return database.findById(Vehicle.class, id);
  }

  @Override
  public List<Vehicle> findAll() {
    return database.findAll(Vehicle.class);
  }

  @Override
  public void update(int id, Vehicle entity) {
    database.update(Vehicle.class, id, entity);
  }

  @Override
  public void delete(int id) {
    database.delete(Vehicle.class, id);
  }

  @Override
  public List<Vehicle> findAll(Predicate<Vehicle> filter) {
    List<Vehicle> allVehicles = database.findAll(Vehicle.class);

    return allVehicles.stream()
        .filter(filter)
        .collect(Collectors.toList());
  }

  @Override
  public List<Vehicle> findAll(Comparator<Vehicle> comparator) {
    List<Vehicle> allVehicles = database.findAll(Vehicle.class);

    allVehicles.sort(comparator);

    return allVehicles;
  }

}
