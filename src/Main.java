import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Main {

 // The Java application uses prepared statements to 
 // prevent SQL inject when interacting with the SQLite database. Instead of directly concatenating user input 
 // into SQL statements. For example, the prepared statement takes in 1=1 as parameter values rather than interpreting it 
 // as part of the SQL statement.  
    public static void main(String[] args) throws IOException {

        SQLManager.initializeDB();

        if (SQLManager.conn != null) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(System.out, true);

            Menu.mainMenu(input, output);

            input.close();
            output.flush();
            SQLManager.closeDB();
        }
    }
}