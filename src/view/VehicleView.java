package view;

import entity.Vehicle;
import service.VehicleService;

import java.util.Optional;
import java.util.Scanner;
import view.View;

public class VehicleView implements View {
  private VehicleService vehicleService = new VehicleService();
  private Scanner scanner = new Scanner(System.in);

  public void startView() {
    while (true) {
      System.out.println("=== Vehicle Menu ===");
      System.out.println("1. Add Vehicle");
      System.out.println("2. View Vehicle");
      System.out.println("3. View All Vehicles");
      System.out.println("4. View all Available Vehicles");
      System.out.println("5. Update Vehicle");
      System.out.println("6. Delete Vehicle");
      System.out.println("7. Back to Main Menu");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addVehicle();
          break;
        case 2:
          viewVehicle();
          break;
        case 3:
          viewAllVehicles();
          break;
        case 4:
          viewAllAvailableVehicles();
          break;
        case 5:
          updateVehicle();
          break;
        case 6:
          deleteVehicle();
          break;
        case 7:
          return;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void viewAllAvailableVehicles() {
    vehicleService.getAllAvailableVehicles().forEach(System.out::println);
  }

  private void addVehicle() {
    System.out.print("Model: ");
    String model = scanner.nextLine();
    System.out.print("Year:");
    int year = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Color:");
    String color = scanner.nextLine();
    System.out.print("FuelType:");
    String fuelType = scanner.nextLine();
    System.out.print("Rental Price Per Day:");
    double rentalPricePerDay = scanner.nextDouble();

    Vehicle vehicle = new Vehicle(model, year, color, rentalPricePerDay, fuelType);
    vehicleService.add(vehicle);
    System.out.println("Vehicle added successfully.");
  }

  private void viewVehicle() {
    System.out.print("Enter Vehicle ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Vehicle> vehicle = vehicleService.getById(id);
    vehicle.ifPresentOrElse(
        System.out::println,
        () -> System.out.println("Vehicle not found."));
  }

  private void viewAllVehicles() {
    vehicleService.getAll().forEach(System.out::println);
  }

  private void updateVehicle() {
    System.out.print("Enter Vehicle ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Vehicle> optionalVehicle = vehicleService.getById(id);
    if (optionalVehicle.isPresent()) {
      Vehicle vehicle = optionalVehicle.get();
      System.out.print("Enter new Model (current: " + vehicle.getModel() + "): ");
      String model = scanner.nextLine();
      System.out.print("Enter new year (current: " + vehicle.getYear() + "): ");
      int year = scanner.nextInt();
      System.out.print("Enter new color (current: " + vehicle.getColor() + "): ");
      String color = scanner.nextLine();
      System.out.print("Enter new rental price per day (current: " + vehicle.getRentalPricePerDay() + "): ");
      double rentalPricePerDay = scanner.nextDouble();
      System.out.print("Enter new fuel type (current: " + vehicle.getFuelType() + "): ");
      String fuelType = scanner.nextLine();

      vehicle.setModel(model);
      vehicle.setYear(year);
      vehicle.setColor(color);
      vehicle.setRentalPricePerDay(rentalPricePerDay);
      vehicle.setFuelType(fuelType);
      vehicleService.update(id, vehicle);
      System.out.println("Vehicle updated successfully.");
    } else {
      System.out.println("Vehicle not found.");
    }
  }

  private void deleteVehicle() {
    System.out.print("Enter Vehicle ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    vehicleService.delete(id);
    System.out.println("Vehicle deleted successfully.");
  }

}
