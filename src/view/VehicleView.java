package view;

import entity.Car;
import entity.Motorcycle;
import entity.Vehicle;
import exception.EntityNotFoundException;
import service.VehicleService;

import java.util.Optional;
import java.util.Scanner;

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
      System.out.println("5. View all Vehicles by Price (sorted)");
      System.out.println("6. Update Vehicle");
      System.out.println("7. Delete Vehicle");
      System.out.println("8. Back to Main Menu");
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
          viewAllVehiclesByPrice();
          break;
        case 6:
          updateVehicle();
          break;
        case 7:
          deleteVehicle();
          break;
        case 8:
          return;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void viewAllVehiclesByPrice() {
    vehicleService.getSortedVehicles().forEach(System.out::println);
  }

  private void viewAllAvailableVehicles() {
    vehicleService.getAllAvailableVehicles().forEach(System.out::println);
  }

  private void addVehicle() {
    // ask the user if they want to add a car or a motorcycle
    System.out.println("What type of vehicle do you want to add?");
    System.out.println("1. Car");
    System.out.println("2. Motorcycle");
    System.out.print("Enter your choice: ");
    while (true) {
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1:
          addCar();
          return;
        case 2:
          addMotorcycle();
          return;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void addMotorcycle() {
    System.out.print("Model: ");
    String model = scanner.nextLine();
    System.out.print("Year:");
    int year = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Color:");
    String color = scanner.nextLine();
    System.out.print("FuelType:");
    String fuelType = scanner.nextLine();
    scanner.nextLine();
    System.out.print("Rental Price Per Day:");
    double rentalPricePerDay = scanner.nextDouble();
    System.out.print("Type:");
    String type = scanner.nextLine();
    System.out.print("Engine Size:");
    int engineSize = scanner.nextInt();
    scanner.nextLine();

    Vehicle vehicle = new Motorcycle(model, year, color, rentalPricePerDay, fuelType, type, engineSize);
    vehicleService.add(vehicle);
    System.out.println("Motorcycle added successfully.");
  }

  private void addCar() {
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
    System.out.print("Number of Doors:");
    int numberOfDoors = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Number of seats:");
    int numberOfSeats = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Transmission Type:");
    String transmissionType = scanner.nextLine();

    Vehicle vehicle = new Car(model, year, color, rentalPricePerDay, fuelType, numberOfDoors, numberOfSeats,
        transmissionType);
    vehicleService.add(vehicle);
    System.out.println("Car added successfully.");
  }

  private void viewVehicle() {
    try {
      System.out.print("Enter Vehicle ID: ");
      int id = scanner.nextInt();
      scanner.nextLine();

      Optional<Vehicle> vehicle = vehicleService.getById(id);
      vehicle.ifPresentOrElse(
          System.out::println,
          () -> System.out.println("Vehicle not found."));
    } catch (EntityNotFoundException exception) {
      System.out.println(exception.getMessage());
    } catch (RuntimeException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private void viewAllVehicles() {
    vehicleService.getAll().forEach(System.out::println);
  }

  private void updateVehicle() {
    try {
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
        scanner.nextLine();
        System.out.print("Enter new color (current: " + vehicle.getColor() + "): ");
        String color = scanner.nextLine();
        System.out.print("Enter new rental price per day (current: " + vehicle.getRentalPricePerDay() + "): ");
        double rentalPricePerDay = scanner.nextDouble();
        scanner.nextLine();
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
    } catch (EntityNotFoundException exception) {
      System.out.println(exception.getMessage());
    } catch (RuntimeException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private void deleteVehicle() {
    try {
      System.out.print("Enter Vehicle ID: ");
      int id = scanner.nextInt();
      scanner.nextLine();

      vehicleService.delete(id);
      System.out.println("Vehicle deleted successfully.");
    } catch (EntityNotFoundException exception) {
      System.out.println(exception.getMessage());
    } catch (RuntimeException exception) {
      System.out.println(exception.getMessage());
    }
  }

}
