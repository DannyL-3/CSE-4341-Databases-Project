
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.io.IOException;

public class CustomerMenu {
    public static void addCustomer(BufferedReader in, PrintWriter out, ArrayList<Customer> customers) throws IOException {
        out.print("Enter the user ID: ");
        out.flush();
        String userID = in.readLine();
        out.print("Enter the name: ");
        out.flush();
        String name = in.readLine();
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
        Customer customer = new Customer(userID, name, fName, lName, Address, phoneNumber, email, startDate, facilityDistance, status);
        customers.add(customer);
        out.println("Customer added successfully!");
    }

    public static void editCustomer(BufferedReader in, PrintWriter out, ArrayList<Customer> customers) throws IOException {
        out.print("Enter the user ID of the customer you wish to edit: ");
        out.flush();
        String userID = in.readLine();
        Customer currCustomer = null;
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                currCustomer = customer;
                break;
            }
        }
        if (currCustomer != null) {
            out.println("What do you want to edit?");
            out.println("1. Name");
            out.println("2. First Name");
            out.println("3. Last Name");
            out.println("4. Address");
            out.println("5. Phone Number");
            out.println("6. Email");
            out.println("7. Start Date");
            out.println("8. Facility Distance");
            out.println("9. Status");
            out.println("0. Cancel");
            out.print("\nEnter: ");
            out.flush();
            int userInput = Integer.parseInt(in.readLine());
            switch (userInput) {
                case 1: {
                    out.print("Enter the new name: ");
                    out.flush();
                    String name = in.readLine();
                    currCustomer.setName(name);
                    break;
                }
                case 2: {
                    out.print("Enter the new first name: ");
                    out.flush();
                    String fName = in.readLine();
                    currCustomer.setFName(fName);
                    break;
                }
                case 3: {
                    out.print("Enter the new last name: ");
                    out.flush();
                    String lName = in.readLine();
                    currCustomer.setLName(lName);
                    break;
                }
                case 4: {
                    out.print("Enter the new address: ");
                    out.flush();
                    String Address = in.readLine();
                    currCustomer.setAddress(Address);
                    break;
                }
                case 5: {
                    out.print("Enter the new phone number: ");
                    out.flush();
                    String phoneNumber = in.readLine();
                    currCustomer.setPhoneNumber(phoneNumber);
                    break;
                }
                case 6: {
                    out.print("Enter the new email: ");
                    out.flush();
                    String email = in.readLine();
                    currCustomer.setEmail(email);
                    break;
                }
                case 7: {
                    out.print("Enter the new start date (YYYY-MM-DD): ");
                    out.flush();
                    LocalDate startDate = LocalDate.parse(in.readLine());
                    currCustomer.setStartDate(startDate);
                    break;
                }
                case 8: {
                    out.print("Enter the new facility distance: ");
                    out.flush();
                    double facilityDistance = Double.parseDouble(in.readLine());
                    currCustomer.setFacilityDistance(facilityDistance);
                    break;
                }
                case 9: {
                    out.print("Enter the new status: ");
                    out.flush();
                    String status = in.readLine();
                    currCustomer.setStatus(status);
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
        else {
            out.println("The user ID you entered does not match any customer.");
        }
    }

    public static void deleteCustomer(BufferedReader in, PrintWriter out, ArrayList<Customer> customers) throws IOException {
        out.print("Enter the user ID of the customer you wish to delete: ");
        out.flush();
        String userID = in.readLine();
        Customer currCustomer = null;
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                currCustomer = customer;
                break;
            }
        }
        if (currCustomer != null) {
            customers.remove(currCustomer);
            out.println("Customer deleted successfully!");
        }
        else {
            out.println("The user ID you entered does not match any customer.");
        }
    }

    public static void searchCustomer(BufferedReader in, PrintWriter out, ArrayList<Customer> customers) throws IOException {
        out.print("Enter the user ID of the customer you wish to find: ");
        out.flush();
        String userID = in.readLine();
        Customer currCustomer = null;
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                currCustomer = customer;
                break;
            }
        }
        if (currCustomer != null) {
            out.println(currCustomer);
        }
        else {
            out.println("The user ID you entered does not match any customer.");
        }
    }

    public static void customerMenu(BufferedReader in, PrintWriter out, ArrayList<Customer> customers) throws IOException {
        boolean customerMenuRunning = true;

        while (customerMenuRunning) {
            out.println("----Customer Management System---");
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
                     addCustomer(in, out, customers);
                     break;
                  }
                  case 2: {
                    editCustomer(in, out, customers);
                    break;
                  }
                  case 3: {
                    deleteCustomer(in, out, customers);
                    break;
                  }
                  case 4: {
                    searchCustomer(in, out, customers);
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
