package service;

import dao.VehicleDAO;
import entity.Vehicle;

import java.util.List;
import java.util.Optional;
import dao.VehicleDAO;

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

  public Lis<Vehicle> getAllRentedVehicles() {
    return vehicleDao.findAll(vehicle -> !vehicle.isAvailable());
  }

  public String calculatePriceInDays(int id, int days) {
    Optional<Vehicle> vehicleOptional = vehicleDao.findById(id);
    if (vehicleOptional.isPresent()) {
      Vehicle vehicle = vehicleOptional.get();
      double vehiclePrice = vehicle.getRentalPricePerDay();
      String price = "Price for " + days + " days is: " + vehiclePrice * days + " $";
      return price;
    } else {
      return "Vehicle with ID " + id + " not found.";
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
