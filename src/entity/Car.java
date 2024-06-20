package entity;

public class Car extends Vehicle {
  private int numDoors;
  private int numSeats;
  private String transmissionType;

  public Car(String model, int year, String color, double rentalPricePerDay, String fuelType, int numDoors,
      int numSeats, String transmissionType) {
    super(model, year, color, rentalPricePerDay, fuelType);
    this.numDoors = numDoors;
    this.numSeats = numSeats;
  }

  public int getNumDoors() {
    return numDoors;
  }

  public void setNumDoors(int numDoors) {
    this.numDoors = numDoors;
  }

  public int getNumSeats() {
    return numSeats;
  }

  public void setNumSeats(int numSeats) {
    this.numSeats = numSeats;
  }

  public String getTransmissionType() {
    return transmissionType;
  }

  public void setTransmissionType(String transmissionType) {
    this.transmissionType = transmissionType;
  }

  @Override
  public String toString() {
    return "Car{" +
        "numDoors=" + numDoors +
        ", numSeats=" + numSeats +
        ", transmissionType='" + transmissionType + '\'' +
        "} " + super.toString() + "\n------- \n";
  }

}
