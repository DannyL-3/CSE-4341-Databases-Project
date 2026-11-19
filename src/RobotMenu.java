import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class RobotMenu {
    public static void addRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the robot ID: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());
        out.print("Enter the serial number: ");
        out.flush();
        String serialNumber = in.readLine();
        out.print("Enter the name: ");
        out.flush();
        String name = in.readLine();
        out.print("Enter the status: ");
        out.flush();
        String status = in.readLine();
        out.print("Enter the battery autonomy: ");
        out.flush();
        double batteryAutonomy = Double.parseDouble(in.readLine());
        out.print("Enter the sensor suite: ");
        out.flush();
        String sensorSuite = in.readLine();
        out.print("Enter the primary function: ");
        out.flush();
        String primaryFunction = in.readLine();
        out.print("Enter the update status: ");
        out.flush();
        String updateStatus = in.readLine();

        String sql = "INSERT INTO Robot "
                + "(RobotID, SerialNumber, Name, Status, BatteryAutononomy, "
                + "SensorSuite, PrimaryFunction, UpdateStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        SQLManager.ps_Update(sql, robotID, serialNumber, name, status,
                batteryAutonomy, sensorSuite, primaryFunction, updateStatus);
    }

    public static void editRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the robot ID of the robot you wish to edit: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());

        out.println("What do you want to edit?");
        out.println("1. Name");
        out.println("2. Serial Number");
        out.println("3. Status");
        out.println("4. Battery Autonomy");
        out.println("5. Sensor Suite");
        out.println("6. Primary Function");
        out.println("7. Update Status");
        out.println("0. Cancel");
        out.print("\nEnter: ");
        out.flush();
        int userInput = Integer.parseInt(in.readLine());

        switch (userInput) {
            case 1: {
                out.print("Enter the new name: ");
                out.flush();
                String name = in.readLine();

                String sql = "UPDATE Robot SET Name = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, name, robotID);
                break;
            }
            case 2: {
                out.print("Enter the new serial number: ");
                out.flush();
                String serialNumber = in.readLine();

                String sql = "UPDATE Robot SET SerialNumber = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, serialNumber, robotID);
                break;
            }
            case 3: {
                out.print("Enter the new status: ");
                out.flush();
                String status = in.readLine();

                String sql = "UPDATE Robot SET Status = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, status, robotID);
                break;
            }
            case 4: {
                out.print("Enter the new battery autonomy: ");
                out.flush();
                double batteryAutonomy = Double.parseDouble(in.readLine());

                String sql = "UPDATE Robot SET BatteryAutononomy = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, batteryAutonomy, robotID);
                break;
            }
            case 5: {
                out.print("Enter the new sensor suite: ");
                out.flush();
                String sensorSuite = in.readLine();

                String sql = "UPDATE Robot SET SensorSuite = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, sensorSuite, robotID);
                break;
            }
            case 6: {
                out.print("Enter the new primary function: ");
                out.flush();
                String primaryFunction = in.readLine();

                String sql = "UPDATE Robot SET PrimaryFunction = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, primaryFunction, robotID);
                break;
            }
            case 7: {
                out.print("Enter the new update status: ");
                out.flush();
                String updateStatus = in.readLine();

                String sql = "UPDATE Robot SET UpdateStatus = ? WHERE RobotID = ?";
                SQLManager.ps_Update(sql, updateStatus, robotID);
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

    public static void deleteRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the robot ID of the robot you wish to delete: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());

        String sql = "DELETE FROM Robot WHERE RobotID = ?";
        SQLManager.ps_Update(sql, robotID);
    }

    public static void searchRobot(BufferedReader in, PrintWriter out) throws IOException {
        out.print("Enter the robot ID of the robot you wish to find: ");
        out.flush();
        int robotID = Integer.parseInt(in.readLine());

        String sql = "SELECT * FROM Robot WHERE RobotID = ?";
        SQLManager.ps_Search(sql, robotID);
    }

    public static void robotMenu(BufferedReader in, PrintWriter out) throws IOException {
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
                        addRobot(in, out);
                        break;
                    }
                    case 2: {
                        editRobot(in, out);
                        break;
                    }
                    case 3: {
                        deleteRobot(in, out);
                        break;
                    }
                    case 4: {
                        searchRobot(in, out);
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
            }
        }
    }

}