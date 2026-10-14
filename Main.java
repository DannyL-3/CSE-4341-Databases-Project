
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out, true);
        ArrayList<Robot> robots = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();

        Menu.mainMenu(input, output, robots, customers);

        input.close();
        output.flush();
    }
}
