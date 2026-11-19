import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Menu {

    public static void mainMenu(BufferedReader in, PrintWriter out) throws IOException {
        boolean menuRunning = true;
        while (menuRunning) {
            out.println("----Warehouse Management System---");
            out.println("1. Robot Management");
            out.println("2. Customer Management");
            out.println("3. Rental Management");
            out.println("4. Reports");
            out.println("0. Exit");
            try {
                out.print("\nEnter: ");
                out.flush();
                int userInput = Integer.parseInt(in.readLine());

                switch (userInput) {
                    case 1: {
                        RobotMenu.robotMenu(in, out);
                        break;
                    }
                    case 2: {
                        CustomerMenu.customerMenu(in, out);
                        break;
                    }
                    case 3: {
                        RentalMenu.rentalMenu(in, out);
                        break;
                    }
                    case 4: {
                        ReportsMenu.reportsMenu(in, out);
                        break;
                    }
                    case 0: {
                        menuRunning = false;
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
