
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RentalMenu {

    public static void rentalMenu(BufferedReader in, PrintWriter out)
            throws IOException {
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
                        out.println("Not implemented yet.");
                        break;
                    }
                    case 2: {
                        out.println("Not implemented yet.");
                        break;

                    }
                    case 3: {
                        out.println("Not implemented yet.");
                        break;
                    }
                    case 4: {
                        out.println("Not implemented yet.");
                        break;
                    }
                    case 0: {
                        rentalMenuRunning = false;
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
