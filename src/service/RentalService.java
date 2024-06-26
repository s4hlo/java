package service;

import dao.RentalDAO;
import entity.Customer;
import entity.Rental;
import entity.Vehicle;
import exception.InvalidRentalEndDateException;
import exception.InvalidRentalReturnDateException;

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

    if (vehicle.isPresent()) {
      vehicle.get().setAvailable(false);
      vehicleService.update(vehicle.get().getId(), vehicle.get());

      if (rental.getEndDate().getTime() < rental.getStartDate().getTime()) {
        throw new InvalidRentalEndDateException("Invalid rental end date.");
      }

      int days = (int) ((rental.getEndDate().getTime() - rental.getStartDate().getTime()) / (1000 * 60 * 60 * 24));
      double amountToPay = vehicleService.calculatePriceInDays(vehicle.get().getId(), days);
      rental.setAmountPaid(amountToPay);
    }

    if (customer.isPresent() && vehicle.isPresent()) {
      rental.setCustomer(customer.get());
      rental.setVehicle(vehicle.get());
    }

    rentalDao.save(rental);
  }

  public void returnVehicle(int id, Date returnDate) {
    Optional<Rental> rental = rentalDao.findById(id);

    if (rental.isPresent()) {
      if (returnDate.getTime() < rental.get().getStartDate().getTime()) {
        throw new InvalidRentalReturnDateException("Invalid rental return date.");
      }

      // Update the vehicle to be available only if vehicle is present
      if (rental.get().getVehicle().isPresent()) {
        Vehicle vehicle = rental.get().getVehicle().get();
        vehicle.setAvailable(true);
      }

      rental.get().setReturnDate(returnDate);
      rentalDao.update(id, rental.get());
    }
  }

  public Optional<Rental> getById(int id) {

    Optional<Rental> rental = rentalDao.findById(id);

    return rental;
  }

  public List<Rental> getAllPendingRentals() {
    return rentalDao.findAll(rental -> !rental.getReturnDate().isPresent());
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
