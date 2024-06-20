package entity;

import java.util.Date;
import java.util.Optional;

public class Rental extends Entity {
  private Date startDate;
  private Date endDate;
  private double amountPaid;
  private Optional<Date> returnDate;
  private Customer customer;
  private Vehicle vehicle;

  public Rental(int id, Date startDate, Date endDate, double amountPaid, Customer customer, Vehicle vehicle) {
    super(id);
    this.startDate = startDate;
    this.endDate = endDate;
    this.amountPaid = amountPaid;
    this.returnDate = Optional.empty();
    this.customer = customer;
    this.vehicle = vehicle;
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Override
  public String toString() {
    return "Rental{" +
        "startDate=" + startDate +
        ", endDate=" + endDate +
        ", amountPaid=" + amountPaid +
        ", returnDate=" + returnDate +
        ", customer= { " + customer +
        " }, vehicle= { " + vehicle +
        '}';
  }
}