import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ReportsMenu {

    public static void totalEquipmentRented(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the customer ID: ");
        out.flush();
        String customerID = in.readLine();

        String sql = "SELECT COUNT(FacilityAsset.SerialNumber) AS TotalEquipment "
                + "FROM Rentals JOIN FacilityAsset "
                + "ON Rentals.RentalID = FacilityAsset.RentalID "
                + "WHERE Rentals.CustomerID = ?";

        SQLManager.ps_Search(sql, customerID);
    }

    public static void popularRobots() {
        String sql = "SELECT Robot.Name, "
                + "SUM(Rentals.Checkouts) AS TotalCheckouts "
                + "FROM Robot "
                + "JOIN FacilityAsset "
                + "ON Robot.SerialNumber = FacilityAsset.SerialNumber "
                + "JOIN Rentals "
                + "ON FacilityAsset.RentalID = Rentals.RentalID "
                + "GROUP BY Robot.Name "
                + "ORDER BY TotalCheckouts DESC LIMIT 1";

        SQLManager.sqlQuery(sql);
    }

    public static void popularManufacturers() {
        String sql = "SELECT FacilityAsset.Manufacturer, "
                + "COUNT(*) AS TotalUnitsRented "
                + "FROM FacilityAsset "
                + "JOIN Rentals "
                + "ON FacilityAsset.RentalID = Rentals.RentalID "
                + "GROUP BY FacilityAsset.Manufacturer "
                + "ORDER BY TotalUnitsRented DESC LIMIT 1";

        SQLManager.sqlQuery(sql);
    }

    public static void popularDriverlessCars() {
        String sql = "SELECT DriverlessCars.CarID, "
                + "DriverlessCars.LicensePlate, "
                + "COUNT(*) AS TotalDeliveries, "
                + "SUM(Customer.FacilityDistance) AS TotalDistance "
                + "FROM DriverlessCars "
                + "JOIN DeliverRetrieve "
                + "ON DriverlessCars.CarID = DeliverRetrieve.CarID "
                + "JOIN Robot "
                + "ON DeliverRetrieve.RobotID = Robot.RobotID "
                + "JOIN FacilityAsset "
                + "ON Robot.SerialNumber = FacilityAsset.SerialNumber "
                + "JOIN Rentals "
                + "ON FacilityAsset.RentalID = Rentals.RentalID "
                + "JOIN Customer "
                + "ON Rentals.CustomerID = Customer.UserID "
                + "GROUP BY DriverlessCars.CarID, DriverlessCars.LicensePlate "
                + "ORDER BY TotalDistance DESC, TotalDeliveries DESC LIMIT 1";

        SQLManager.sqlQuery(sql);
    }

    public static void topCustomer() {
        String sql = "SELECT Customer.UserID, Customer.FirstName, "
                + "Customer.LastName, COUNT(Robot.RobotID) AS TotalRobots "
                + "FROM Customer "
                + "JOIN Rentals ON Customer.UserID = Rentals.CustomerID "
                + "JOIN FacilityAsset "
                + "ON Rentals.RentalID = FacilityAsset.RentalID "
                + "JOIN Robot "
                + "ON FacilityAsset.SerialNumber = Robot.SerialNumber "
                + "GROUP BY Customer.UserID, Customer.FirstName, Customer.LastName "
                + "ORDER BY TotalRobots DESC LIMIT 1";

        SQLManager.sqlQuery(sql);
    }

    public static void robotsByManufacturer(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the manufacturer: ");
        out.flush();
        String manufacturer = in.readLine();

        out.print("Enter the year: ");
        out.flush();
        int year = Integer.parseInt(in.readLine());

        String sql = "SELECT Robot.Name, FacilityAsset.Model, "
                + "FacilityAsset.Manufacturer, FacilityAsset.year "
                + "FROM Robot JOIN FacilityAsset "
                + "ON Robot.SerialNumber = FacilityAsset.SerialNumber "
                + "WHERE FacilityAsset.Manufacturer = ? "
                + "AND FacilityAsset.year < ?";

        SQLManager.ps_Search(sql, manufacturer, year);
    }

    public static void reportsMenu(BufferedReader in, PrintWriter out) throws IOException {
        boolean reportsMenuRunning = true;

        while (reportsMenuRunning) {
            out.println("\n--- Reports ---");
            out.println("1. Total Equipment Rented by Customer");
            out.println("2. Most Popular Robots");
            out.println("3. Most Popular Manufacturers");
            out.println("4. Most Popular Driverless Cars");
            out.println("5. Customer with Most Robots Rented");
            out.println("6. Robots by Manufacturer and Year");
            out.println("0. Back to Main Menu");

            try {
                out.print("\nEnter: ");
                out.flush();
                int userInput = Integer.parseInt(in.readLine());

                switch (userInput) {
                    case 1: {
                        totalEquipmentRented(in, out);
                        break;
                    }
                    case 2: {
                        popularRobots();
                        break;
                    }
                    case 3: {
                        popularManufacturers();
                        break;
                    }
                    case 4: {
                        popularDriverlessCars();
                        break;
                    }
                    case 5: {
                        topCustomer();
                        break;
                    }
                    case 6: {
                        robotsByManufacturer(in, out);
                        break;
                    }
                    case 0: {
                        reportsMenuRunning = false;
                        break;
                    }
                    default: {
                        out.println("Invalid input.");
                    }
                }
            } catch (NumberFormatException e) {
                out.println("Invalid input.");
            }
        }
    }
}