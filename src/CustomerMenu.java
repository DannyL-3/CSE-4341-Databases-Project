import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.io.IOException;

public class CustomerMenu {
    public static void addCustomer(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the user ID: ");
        out.flush();
        String userID = in.readLine();

        out.print("Enter the first name: ");
        out.flush();
        String fName = in.readLine();

        out.print("Enter the last name: ");
        out.flush();
        String lName = in.readLine();

        out.print("Enter the address: ");
        out.flush();
        String Address = in.readLine();

        out.print("Enter the phone number: ");
        out.flush();
        String phoneNumber = in.readLine();

        out.print("Enter the email: ");
        out.flush();
        String email = in.readLine();

        out.print("Enter the start date (YYYY-MM-DD): ");
        out.flush();
        LocalDate startDate = LocalDate.parse(in.readLine());

        out.print("Enter the facility distance: ");
        out.flush();
        double facilityDistance = Double.parseDouble(in.readLine());

        out.print("Enter the status: ");
        out.flush();
        String status = in.readLine();

        out.print("Enter the facility address: ");
        out.flush();
        String facilityAddress = in.readLine();

        out.print("Enter the readiness ID: ");
        out.flush();
        int readinessID = Integer.parseInt(in.readLine());

        String sql = "INSERT INTO Customer "
                + "(UserID, FirstName, LastName, Address, Phone, "
                + "Email, StartDate, FacilityDistance, Status, "
                + "FacilityAddress, ReadinessID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLManager.ps_Update(sql, userID, fName, lName,
                Address, phoneNumber, email, startDate.toString(),
                facilityDistance, status, facilityAddress, readinessID);
    }

    public static void editCustomer(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the user ID of the customer you wish to edit: ");
        out.flush();
        String userID = in.readLine();

        out.println("What do you want to edit?");
        out.println("1. First Name");
        out.println("2. Last Name");
        out.println("3. Address");
        out.println("4. Phone Number");
        out.println("5. Email");
        out.println("6. Start Date");
        out.println("7. Facility Distance");
        out.println("8. Status");
        out.println("9. Facility Address");
        out.println("10. Readiness ID");
        out.println("0. Cancel");

        out.print("\nEnter: ");
        out.flush();
        int userInput = Integer.parseInt(in.readLine());

        switch (userInput) {
            case 1: {
                out.print("Enter the new first name: ");
                out.flush();
                String fName = in.readLine();

                String sql = "UPDATE Customer SET FirstName = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, fName, userID);
                break;
            }
            case 2: {
                out.print("Enter the new last name: ");
                out.flush();
                String lName = in.readLine();

                String sql = "UPDATE Customer SET LastName = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, lName, userID);
                break;
            }
            case 3: {
                out.print("Enter the new address: ");
                out.flush();
                String Address = in.readLine();

                String sql = "UPDATE Customer SET Address = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, Address, userID);
                break;
            }
            case 4: {
                out.print("Enter the new phone number: ");
                out.flush();
                String phoneNumber = in.readLine();

                String sql = "UPDATE Customer SET Phone = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, phoneNumber, userID);
                break;
            }
            case 5: {
                out.print("Enter the new email: ");
                out.flush();
                String email = in.readLine();

                String sql = "UPDATE Customer SET Email = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, email, userID);
                break;
            }
            case 6: {
                out.print("Enter the new start date (YYYY-MM-DD): ");
                out.flush();
                LocalDate startDate = LocalDate.parse(in.readLine());

                String sql = "UPDATE Customer SET StartDate = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, startDate.toString(), userID);
                break;
            }
            case 7: {
                out.print("Enter the new facility distance: ");
                out.flush();
                double facilityDistance = Double.parseDouble(in.readLine());

                String sql = "UPDATE Customer SET FacilityDistance = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, facilityDistance, userID);
                break;
            }
            case 8: {
                out.print("Enter the new status: ");
                out.flush();
                String status = in.readLine();

                String sql = "UPDATE Customer SET Status = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, status, userID);
                break;
            }
            case 9: {
                out.print("Enter the new facility address: ");
                out.flush();
                String facilityAddress = in.readLine();

                String sql = "UPDATE Customer SET FacilityAddress = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, facilityAddress, userID);
                break;
            }
            case 10: {
                out.print("Enter the new readiness ID: ");
                out.flush();
                int readinessID = Integer.parseInt(in.readLine());

                String sql = "UPDATE Customer SET ReadinessID = ? WHERE UserID = ?";
                SQLManager.ps_Update(sql, readinessID, userID);
                break;
            }
            case 0: {
                break;
            }
            default: {
                out.println("Invalid Input");
            }
        }
    }

    public static void deleteCustomer(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the user ID of the customer you wish to delete: ");
        out.flush();
        String userID = in.readLine();

        String sql = "DELETE FROM Customer WHERE UserID = ?";
        SQLManager.ps_Update(sql, userID);
    }

    public static void searchCustomer(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the user ID of the customer you wish to find: ");
        out.flush();
        String userID = in.readLine();

        String sql = "SELECT * FROM Customer WHERE UserID = ?";
        SQLManager.ps_Search(sql, userID);
    }

    public static void customerMenu(BufferedReader in, PrintWriter out) throws IOException {
        boolean customerMenuRunning = true;

        while (customerMenuRunning) {
            out.println("\n--- Customer Management ---");
            out.println("1. Add Customer");
            out.println("2. Edit Customer");
            out.println("3. Delete Customer");
            out.println("4. Search Customer");
            out.println("0. Back to Main Menu");

            try {
                out.print("\nEnter: ");
                out.flush();
                int userInput = Integer.parseInt(in.readLine());

                switch (userInput) {
                    case 1: {
                        addCustomer(in, out);
                        break;
                    }
                    case 2: {
                        editCustomer(in, out);
                        break;
                    }
                    case 3: {
                        deleteCustomer(in, out);
                        break;
                    }
                    case 4: {
                        searchCustomer(in, out);
                        break;
                    }
                    case 0: {
                        customerMenuRunning = false;
                        break;
                    }
                    default: {
                        out.println("Invalid Input");
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