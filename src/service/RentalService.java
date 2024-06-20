package service;

import dao.RentalDAO;
import entity.Customer;
import entity.Rental;
import entity.Vehicle;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class RentalService {
  private RentalDAO rentalDao = new RentalDAO();
  private CustomerService customerService = new CustomerService();
  private VehicleService vehicleService = new VehicleService();

  public void add(Rental rental) {
    Optional<Customer> customer = customerService.getById(rental.getCustomerId());
    Optional<Vehicle> vehicle = vehicleService.getById(rental.getVehicleId());

    if (customer.isPresent() && vehicle.isPresent()) {
      rental.setCustomer(customer.get());
      rental.setVehicle(vehicle.get());
    }

    rentalDao.save(rental);
  }

  public void returnVehicle(int id, Date returnDate) {
    Optional<Rental> rental = rentalDao.findById(id);

    if (rental.isPresent()) {
      rental.get().setReturnDate(returnDate);
      rentalDao.update(id, rental.get());
    }
  }

  public Optional<Rental> getById(int id) {

    Optional<Rental> rental =  rentalDao.findById(id);

    return rental;
  }

  public List<Rental> getAllPendingRentals () {
    return rentalDao.findAll(rental -> rental.getReturnDate() == null);
  }

  public List<Rental> getAll() {
    return rentalDao.findAll();
  }

  public void update(int id, Rental rental) {
    rentalDao.update(id, rental);
  }

  public void delete(int id) {
    rentalDao.delete(id);
  }
}


