import java.sql.*;
import java.util.Scanner;

// 4347 Group Project Phase 4
// Nick Magee, 
public class Project4347Phase4 {
    static final String DB_URL = "jdbc:mysql://project-4347-db.cblupithxisz.us-east-2.rds.amazonaws.com";
    static final String USER = "admin";
    static final String PASS = "4347Password!";
    static final String QUERY = "SELECT id, first, last, age FROM Employees";

    public static void main(String[] args) {

        // REFERENCE FOR CONNECTED TO SQL SERVER FOUND AT:
        // https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
        // CONNECTION INFO ABOVE

        // // Open a connection
        // try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        // Statement stmt = conn.createStatement();
        // ResultSet rs = stmt.executeQuery(QUERY);) {
        // // Extract data from result set
        // while (rs.next()) {
        // // Retrieve by column name
        // System.out.print("ID: " + rs.getInt("id"));
        // System.out.print(", Age: " + rs.getInt("age"));
        // System.out.print(", First: " + rs.getString("first"));
        // System.out.println(", Last: " + rs.getString("last"));
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        int exitVal = 0;

        while (exitVal != 1) {
            Scanner reader = new Scanner(System.in); // Reading from System.in
            // OPTIONS
            System.out.println("Select from options below: ");
            System.out.println("1. Insert Player on Team.");
            System.out.println("2. Insert Staff Member on Team.");
            // INSERT MORE OPTIONS HERE
            System.out.println("6. Exit.");
            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.

            // GO TO SQL FUNTION HERE
            if (n == 1) {

            }

            if (n == 6) {
                // once finished
                reader.close();
                exitVal = 1;
            }
        }

    }
}