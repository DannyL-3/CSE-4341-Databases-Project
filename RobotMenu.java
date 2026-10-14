import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.io.IOException;

public class RobotMenu {
    public static void addRobot(BufferedReader in, PrintWriter out, ArrayList<Robot> robots) throws IOException {
        out.print("Enter the serial number: ");
        out.flush();
        String serialNumber = in.readLine();
        out.print("Enter the name: ");
        out.flush();
        String name = in.readLine();
        out.print("Enter the model: ");
        out.flush();
        String model = in.readLine();
        out.print("Enter the status: ");
        out.flush();
        String status = in.readLine();
        out.print("Enter the warehouse location: ");
        out.flush();
        String warehouseLocation = in.readLine();
        out.print("Enter the manufacturer: ");
        out.flush();
        String manufacturer = in.readLine();
        out.print("Enter the year: ");
        out.flush();
        int year = Integer.parseInt(in.readLine());
        out.print("Enter the battery autonomy: ");
        out.flush();
        double batteryAutonomy = Double.parseDouble(in.readLine());
        out.print("Enter the sensor suite: ");
        out.flush();
        String sensorSuite = in.readLine();
        out.print("Enter the primary function: ");
        out.flush();
        String primaryFunction = in.readLine();
        out.print("Enter the warranty expiration (YYYY-MM-DD): ");
        out.flush();
        LocalDate warrantyExpiration = LocalDate.parse(in.readLine());
        out.print("Enter the update status: ");
        out.flush();
        String updateStatus = in.readLine();
        Robot robot = new Robot(serialNumber, name, model, status,warehouseLocation, manufacturer, year, batteryAutonomy,sensorSuite, primaryFunction, warrantyExpiration, updateStatus);
        robots.add(robot);
        out.println("Robot added successfully!");
    }

    public static void editRobot(BufferedReader in, PrintWriter out, ArrayList<Robot> robots) throws IOException {
        out.print("Enter the serial number of the robot you wish to edit: ");
        out.flush();
        String serialNumber = in.readLine();
        Robot currRobot = null;
        for (Robot robot : robots) {
            if (robot.getSerialNumber().equals(serialNumber)) {
                currRobot = robot;
                break;
            }
        }
        if (currRobot != null) {
            out.println("What do you want to edit?");
            out.println("1. Name");
            out.println("2. Model");
            out.println("3. Status");
            out.println("4. Warehouse Location");
            out.println("5. Manufacturer");
            out.println("6. Year");
            out.println("7. Battery Autonomy");
            out.println("8. Sensor Suite");
            out.println("9. Primary Function");
            out.println("10. Warranty Expiration");
            out.println("11. Update Status");
            out.println("0. Cancel");
            out.print("\nEnter: ");
            out.flush();
            int userInput = Integer.parseInt(in.readLine());
            switch (userInput) {
                case 1: {
                    out.print("Enter the new name: ");
                    out.flush();
                    String name = in.readLine();
                    currRobot.setName(name);
                    break;
                }
                case 2: {
                    out.print("Enter the new model: ");
                    out.flush();
                    String model = in.readLine();
                    currRobot.setModel(model);
                    break;
                }
                case 3: {
                    out.print("Enter the new status: ");
                    out.flush();
                    String status = in.readLine();
                    currRobot.setStatus(status);
                    break;
                }
                case 4: {
                    out.print("Enter the new warehouse location: ");
                    out.flush();
                    String warehouseLocation = in.readLine();
                    currRobot.setWarehouseLocation(warehouseLocation);
                    break;
                }
                case 5: {
                    out.print("Enter the new manufacturer: ");
                    out.flush();
                    String manufacturer = in.readLine();
                    currRobot.setManufacturer(manufacturer);
                    break;
                }
                case 6: {
                    out.print("Enter the new year: ");
                    out.flush();
                    int year = Integer.parseInt(in.readLine());
                    currRobot.setYear(year);
                    break;
                }
                case 7: {
                    out.print("Enter the new battery autonomy: ");
                    out.flush();
                    double batteryAutonomy = Double.parseDouble(in.readLine());
                    currRobot.setBatteryAutonomy(batteryAutonomy);
                    break;
                }
                case 8: {
                    out.print("Enter the new sensor suite: ");
                    out.flush();
                    String sensorSuite = in.readLine();
                    currRobot.setSensorSuite(sensorSuite);
                    break;
                }
                case 9: {
                    out.print("Enter the new primary function: ");
                    out.flush();
                    String primaryFunction = in.readLine();
                    currRobot.setPrimaryFunction(primaryFunction);
                    break;
                }
                case 10: {
                    out.print("Enter the new warranty expiration (YYYY-MM-DD): ");
                    out.flush();
                    LocalDate warrantyExpiration = LocalDate.parse(in.readLine());
                    currRobot.setWarrantyExpiration(warrantyExpiration);
                    break;
                }
                case 11: {
                    out.print("Enter the new update status: ");
                    out.flush();
                    String updateStatus = in.readLine();
                    currRobot.setUpdateStatus(updateStatus);
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
            out.println("The serial number you entered does not match any robot");
        }
    }

    public static void deleteRobot(BufferedReader in, PrintWriter out, ArrayList<Robot> robots) throws IOException {
        out.print("Enter the serial number of the robot you wish to delete");
        out.flush();
        String serialNumber = in.readLine();
        Robot currRobot = null;
        for (Robot robot : robots) {
            if (robot.getSerialNumber().equals(serialNumber)) {
                currRobot = robot;
                break;
            }
        }
        if (currRobot != null) {
            robots.remove(currRobot);
            out.println("Robot deleted Successfully!");
        }
        else {
            out.println("The serial number you entered does not match any robot.");
        }
    }

    public static void searchRobot(BufferedReader in, PrintWriter out, ArrayList<Robot> robots) throws IOException {
        out.print("Enter the serial number of the robot you wish to find");
        out.flush();
        String serialNumber = in.readLine();
        Robot currRobot = null;
        for (Robot robot : robots) {
            if (robot.getSerialNumber().equals(serialNumber)) {
                currRobot = robot;
                break;
            }
        }
        if (currRobot != null) {
            out.println(currRobot);
        }
        else {
            out.println("The serial number you entered does not match any robot.");
        }


    }

    public static void robotMenu(BufferedReader in, PrintWriter out, ArrayList<Robot> robots) throws IOException {
        boolean robotMenuRunning = true;

        while (robotMenuRunning) {
            out.println("----Robot Management System---");
            out.println("1. Add Robot");
            out.println("2. Edit Robot");
            out.println("3. Delete Robot");
            out.println("4. Search Robot");
            out.println("0. Back to Main Menu");
            try {
                out.print("\nEnter: ");
                out.flush();
                int userInput = Integer.parseInt(in.readLine());
                switch (userInput) {
                  case 1: {
                     addRobot(in, out, robots);
                     break;
                  }
                  case 2: {
                    editRobot(in, out, robots);
                    break;
                  }
                  case 3: {
                    deleteRobot(in, out, robots);
                    break;
                  }
                  case 4: {
                    searchRobot(in, out, robots);
                    break;
                  }
                  case 0: {
                    robotMenuRunning = false;
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