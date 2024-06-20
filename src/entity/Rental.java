package entity;

import java.util.Date;
import java.util.Optional;

public class Rental extends Entity {
  private Date startDate;
  private Date endDate;
  private double amountPaid;
  private Optional<Date> returnDate;
  private int customerId;
  private int vehicleId;

  // placeholder
  private Optional<Customer> customer;
  private Optional<Vehicle> vehicle;

  public Rental(Date startDate, Date endDate, double amountPaid, int customerId, int vehicleId) {
    super(0);
    this.startDate = startDate;
    this.endDate = endDate;
    this.amountPaid = amountPaid;
    this.returnDate = Optional.empty();
    this.customerId = customerId;
    this.vehicleId = vehicleId;

  }

  public Optional<Customer> getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = Optional.of(customer);
  }

  public Optional<Vehicle> getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = Optional.of(vehicle);
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public double getAmountPaid() {
    return amountPaid;
  }

  public void setAmountPaid(double amountPaid) {
    this.amountPaid = amountPaid;
  }

  public Optional<Date> getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = Optional.of(returnDate);
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomer(int customerId) {
    this.customerId = customerId;
  }

  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicle) {
    this.vehicleId = vehicle;
  }

  @Override
  public String toString() {
    return "Rental{" +
        "startDate=" + startDate +
        ", endDate=" + endDate +
        ", amountPaid=" + amountPaid +
        ", returnDate=" + returnDate +
        ", customerId=" + customerId +
        ", vehicleId=" + vehicleId +
        ", customer=" + customer +
        ", vehicle=" + vehicle +
        '}';
  }
}