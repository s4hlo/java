package view;

import entity.Customer;
import service.CustomerService;

import java.util.Optional;
import java.util.Scanner;

public class CustomerView implements View {
  private CustomerService customerService = new CustomerService();
  private Scanner scanner = new Scanner(System.in);

  public void startView() {
    while (true) {
      System.out.println("=== Customer Menu ===");
      System.out.println("1. Add Customer");
      System.out.println("2. View Customer");
      System.out.println("3. View All Customers");
      System.out.println("4. Update Customer");
      System.out.println("5. Delete Customer");
      System.out.println("6. Back to Main Menu");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          addCustomer();
          break;
        case 2:
          viewCustomer();
          break;
        case 3:
          viewAllCustomers();
          break;
        case 4:
          updateCustomer();
          break;
        case 5:
          deleteCustomer();
          break;
        case 6:
          return; // Return to main menu
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
  }

  private void addCustomer() {
    System.out.print("Enter Customer Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Customer Email: ");
    String email = scanner.nextLine();
    System.out.print("Enter Customer Age: ");
    int age = scanner.nextInt();

    Customer customer = new Customer(name, email, age);
    customerService.add(customer);
    System.out.println("Customer added successfully.");
  }

  private void viewCustomer() {
    System.out.print("Enter Customer ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Customer> customer = customerService.getById(id);
    customer.ifPresentOrElse(
        System.out::println,
        () -> System.out.println("Customer not found."));
  }

  private void viewAllCustomers() {
    customerService.getAll().forEach(System.out::println);
  }

  private void updateCustomer() {
    System.out.print("Enter Customer ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Optional<Customer> optionalCustomer = customerService.getById(id);
    if (optionalCustomer.isPresent()) {
      Customer customer = optionalCustomer.get();
      System.out.print("Enter new name (current: " + customer.getName() + "): ");
      String name = scanner.nextLine();
      System.out.print("Enter new email (current: " + customer.getEmail() + "): ");
      String email = scanner.nextLine();
      System.out.print("Enter new age (current: " + customer.getAge() + "): ");
      int age = scanner.nextInt();

      customer.setName(name);
      customer.setEmail(email);
      customer.setAge(age);
      customerService.update(id, customer);
      System.out.println("Customer updated successfully.");
    } else {
      System.out.println("Customer not found.");
    }
  }

  private void deleteCustomer() {
    System.out.print("Enter Customer ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    customerService.delete(id);
    System.out.println("Customer deleted successfully.");
  }

}
