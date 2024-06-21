package service;

import dao.VehicleDAO;
import entity.Vehicle;

import java.util.List;
import java.util.Optional;

public class VehicleService {
  private VehicleDAO vehicleDao = new VehicleDAO();

  public void add(Vehicle vehicle) {
    vehicleDao.save(vehicle);
  }

  public Optional<Vehicle> getById(int id) {
    return vehicleDao.findById(id);
  }

  public List<Vehicle> getAllAvailableVehicles() {
    return vehicleDao.findAll(vehicle -> vehicle.isAvailable());
  }

  public List<Vehicle> getSortedVehicles() {
    return vehicleDao.findAll((v1, v2) -> Double.compare(v1.getRentalPricePerDay(), v2.getRentalPricePerDay()));
  }

  public double calculatePriceInDays(int id, int days) {
    Optional<Vehicle> vehicleOptional = vehicleDao.findById(id);
    if (vehicleOptional.isPresent()) {
      Vehicle vehicle = vehicleOptional.get();
      double vehiclePrice = vehicle.getRentalPricePerDay();
      System.out.println("Price for " + days + " days is: " + vehiclePrice * days + " $");
      return vehiclePrice * days ;
    } else {
      return 0;
    }
  }

  public List<Vehicle> getAll() {
    return vehicleDao.findAll();
  }

  public void update(int id, Vehicle vehicle) {
    vehicleDao.update(id, vehicle);
  }

  public void delete(int id) {
    vehicleDao.delete(id);
  }
}
