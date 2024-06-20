import view.CustomerView;
import view.VehicleView;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("=== Main Menu ===");
      System.out.println("1. Customer View");
      System.out.println("2. Vehicle View");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1:
          CustomerView customerView = new CustomerView();
          customerView.startView();
          break;
        case 2:
          VehicleView vehicleView = new VehicleView();
          vehicleView.startView();
          break;
        case 3:
          System.out.println("Exiting program...");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please enter a valid option.");
      }
    }
  }
}
