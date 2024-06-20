package view;

import entity.Rental;
import service.RentalService;

import java.sql.Date;
import java.util.Optional;
import java.util.Scanner;

public class RentalView implements View {
  private RentalService rentalService = new RentalService();
  private Scanner scanner = new Scanner(System.in);

  public void startView() {
    while (true) {
      System.out.println("=== Rental Menu ===");
      System.out.println("1. Add Rental");
      System.out.println("2. View Rental");
      System.out.println("3. View All Rentals");
      System.out.println("4. List all pending rentals");
      System.out.println("5. Return Vehicle in Rental");
      System.out.println("6. Update Rental");
      System.out.println("7. Delete Rental");
      System.out.println("8. Back to Main Menu");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addRental();
          break;
        case 2:
          viewRental();
          break;
        case 3:
          viewAllRentals();
          break;
        case 4:
          viewAllPendingRentals();
          break;
        case 5:
          returnVehicleInRental();
          break;
        case 6:
          updateRental();
          break;
        case 7:
          deleteRental();
        case 8:
          return; // Return to main menu
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void viewAllPendingRentals() {
    rentalService.getAllPendingRentals().forEach(System.out::println);
  }

  private void returnVehicleInRental() {
    System.out.print("Enter Rental ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Return Date or press enter to use current date: ");
    String input = scanner.nextLine();
    Date returnDate = input.isEmpty() ? new Date(System.currentTimeMillis()) : Date.valueOf(input);
    rentalService.returnVehicle(id, returnDate);
    System.out.println("Vehicle returned successfully.");
  }

  private void addRental() {
    System.out.print("Enter Rental StarDate: ");
    // the format should be yyyy-mm-dd
    Date startDate = Date.valueOf(scanner.nextLine());
    System.out.print("Enter Rental EndDate: ");
    // the format should be yyyy-mm-dd
    Date endDate = Date.valueOf(scanner.nextLine());
    System.out.print("Enter Rental Customer ID: ");
    int customerId = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Rental Vehicle ID: ");
    int vehicleId = scanner.nextInt();
    scanner.nextLine();

    Rental rental = new Rental(startDate, endDate, customerId, vehicleId);
    rentalService.add(rental);
    System.out.println("Rental added successfully.");
  }

  private void viewRental() {
    System.out.print("Enter Rental ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Rental> rental = rentalService.getById(id);
    rental.ifPresentOrElse(
        System.out::println,
        () -> System.out.println("Rental not found."));
  }

  private void viewAllRentals() {
    rentalService.getAll().forEach(System.out::println);
  }

  private void updateRental() {
    System.out.print("Enter Rental ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Rental> optionalRental = rentalService.getById(id);
    if (optionalRental.isPresent()) {
      Rental rental = optionalRental.get();

      System.out.print("Enter new start date (current: " + rental.getStartDate() + "): ");
      Date startDate = Date.valueOf(scanner.nextLine());
      // if (!startDate.isEmpty()) {
      //   rental.setStartDate(Date.valueOf(startDate));
      // }
      System.out.print("Enter new end date (current: " + rental.getEndDate() + "): ");
      Date endDate = Date.valueOf(scanner.nextLine());
      System.out.print("Enter new amount paid (current: " + rental.getAmountPaid() + "): ");
      double amountPaid = scanner.nextDouble();
      scanner.nextLine();

      rental.setStartDate(startDate);
      rental.setEndDate(endDate);
      rental.setAmountPaid(amountPaid);
      rentalService.update(id, rental);
      System.out.println("Rental updated successfully.");
    } else {
      System.out.println("Rental not found.");
    }
  }

  private void deleteRental() {
    System.out.print("Enter Rental ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    rentalService.delete(id);
    System.out.println("Rental deleted successfully.");
  }

}
