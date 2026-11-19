import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class RentalMenu {

    public static void rentRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the rental ID: ");
        out.flush();
        int rentalID = Integer.parseInt(in.readLine());

        out.print("Enter the customer ID: ");
        out.flush();
        String customerID = in.readLine();

        out.print("Enter the robot ID: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());

        out.print("Enter the checkout date (YYYY-MM-DD): ");
        out.flush();
        LocalDate checkoutDate = LocalDate.parse(in.readLine());

        out.print("Enter the due date (YYYY-MM-DD): ");
        out.flush();
        LocalDate dueDate = LocalDate.parse(in.readLine());

        out.print("Enter the rental fees: ");
        out.flush();
        double rentalFees = Double.parseDouble(in.readLine());

        out.println("\nRental request received.");
        out.println("Rental ID: " + rentalID);
        out.println("Customer ID: " + customerID);
        out.println("Robot ID: " + robotID);
        out.println("Checkout Date: " + checkoutDate);
        out.println("Due Date: " + dueDate);
        out.println("Rental Fees: " + rentalFees);
    }

    public static void returnRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the rental ID: ");
        out.flush();
        int rentalID = Integer.parseInt(in.readLine());

        out.print("Enter the robot ID: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());

        out.print("Enter the return date (YYYY-MM-DD): ");
        out.flush();
        LocalDate returnDate = LocalDate.parse(in.readLine());

        out.println("\nReturn request received.");
        out.println("Rental ID: " + rentalID);
        out.println("Robot ID: " + robotID);
        out.println("Return Date: " + returnDate);
    }

    public static void scheduleDelivery(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the rental ID: ");
        out.flush();
        int rentalID = Integer.parseInt(in.readLine());

        out.print("Enter the driverless car ID: ");
        out.flush();
        int carID = Integer.parseInt(in.readLine());

        out.print("Enter the delivery date (YYYY-MM-DD): ");
        out.flush();
        LocalDate deliveryDate = LocalDate.parse(in.readLine());

        out.println("\nDelivery request received.");
        out.println("Rental ID: " + rentalID);
        out.println("Driverless Car ID: " + carID);
        out.println("Delivery Date: " + deliveryDate);
    }

    public static void schedulePickup(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the rental ID: ");
        out.flush();
        int rentalID = Integer.parseInt(in.readLine());

        out.print("Enter the driverless car ID: ");
        out.flush();
        int carID = Integer.parseInt(in.readLine());

        out.print("Enter the pickup date (YYYY-MM-DD): ");
        out.flush();
        LocalDate pickupDate = LocalDate.parse(in.readLine());

        out.println("\nPickup request received.");
        out.println("Rental ID: " + rentalID);
        out.println("Driverless Car ID: " + carID);
        out.println("Pickup Date: " + pickupDate);
    }

    public static void rentalMenu(BufferedReader in, PrintWriter out) throws IOException {
        boolean rentalMenuRunning = true;

        while (rentalMenuRunning) {
            out.println("\n--- Rental Management ---");
            out.println("1. Rent Robot");
            out.println("2. Return Robot");
            out.println("3. Schedule Delivery");
            out.println("4. Schedule Pickup");
            out.println("0. Back to Main Menu");

            try {
                out.print("\nEnter: ");
                out.flush();
                int userInput = Integer.parseInt(in.readLine());

                switch (userInput) {
                    case 1: {
                        rentRobot(in, out);
                        break;
                    }
                    case 2: {
                        returnRobot(in, out);
                        break;
                    }
                    case 3: {
                        scheduleDelivery(in, out);
                        break;
                    }
                    case 4: {
                        schedulePickup(in, out);
                        break;
                    }
                    case 0: {
                        rentalMenuRunning = false;
                        break;
                    }
                    default: {
                        out.println("Invalid input.");
                    }
                }
            } catch (NumberFormatException e) {
                out.println("Invalid input.");
            } catch (java.time.format.DateTimeParseException e) {
                out.println("Invalid date. Please use YYYY-MM-DD.");
            }
        }
    }
}