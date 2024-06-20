package entity;

public class Vehicle extends Entity {
  private String model;
  private int year;
  private String color;
  private double rentalPricePerDay;
  private boolean isAvailable;
  private String fuelType;

  public Vehicle(String model, int year, String color, double rentalPricePerDay, String fuelType) {
    super(0);
    this.model = model;
    this.year = year;
    this.color = color;
    this.rentalPricePerDay = rentalPricePerDay;
    this.isAvailable = true;
    this.fuelType = fuelType;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getRentalPricePerDay() {
    return rentalPricePerDay;
  }

  public void setRentalPricePerDay(double rentalPricePerDay) {
    this.rentalPricePerDay = rentalPricePerDay;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id=" + getId() +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", color='" + color + '\'' +
        ", rentalPricePerDay=" + rentalPricePerDay +
        ", isAvailable=" + isAvailable +
        ", fuelType='" + fuelType + '\'' +
        '}';
  }
}
