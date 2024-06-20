package entity;

public class Motorcycle extends Vehicle {
  private String type;
  private int engineSize;

  public Motorcycle(String model, int year, String color, double rentalPricePerDay, String fuelType, String type,
      int engineSize) {
    super(model, year, color, rentalPricePerDay, fuelType);
    this.type = type;
    this.engineSize = engineSize;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(int engineSize) {
    this.engineSize = engineSize;
  }

  @Override
  public String toString() {
    return "Motorcycle{" +
        "type='" + type + '\'' +
        ", engineSize=" + engineSize +
        "} " + super.toString();
  }

}
