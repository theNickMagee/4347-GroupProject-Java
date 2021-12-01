import java.sql.*;
import java.util.Scanner;

// 4347 Group Project Phase 4
// Nick Magee, 
public class Project4347Phase4 {
    static final String DB_URL = "jdbc:mysql://project-4347-db.cblupithxisz.us-east-2.rds.amazonaws.com/league_management?characterEncoding=latin1&useConfigs=maxPerformance";
    static final String USER = "admin";
    static final String PASS = "4347Password!";
    static final String QUERY = "SELECT id, first, last, age FROM Employees";

    public static void main(String[] args) throws ClassNotFoundException {

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
            Class.forName("com.mysql.jdbc.Driver");
            Scanner reader = new Scanner(System.in); // Reading from System.in
            // OPTIONS
            System.out.println("Select from options below: ");
            System.out.println("1. Insert Player on Team.");
            System.out.println("2. Insert Staff Member on Team.");
            System.out.println("3. Insert Game Event.");
            System.out.println("4. Edit Player Status.");
            // INSERT MORE OPTIONS HERE
            System.out.println("6. Exit.");
            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.

            // GO TO SQL FUNTION HERE
            if (n == 1) {

            }

            if (n == 3) {
                // Open a connection

                try (
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {
                    // Execute a query
                    System.out.print("Please enter the date of the Event as YYYY-MM-DD: ");
                    String sql = "INSERT INTO GAME_EVENT VALUES (";
                    sql += reader.nextLine() + ", ";
                    System.out.print("Please enter the winning teams name: ");
                    String WinTeam = reader.nextLine() + ", ";
                    System.out.print("Please enter the losing teams name: ");
                    String LossTeam = reader.nextLine() + ")";
                    stmt.executeUpdate(sql + WinTeam + LossTeam);

                    stmt.executeUpdate("UPDATE TEAM SET Wins  = Wins  + 1 WHERE Name  = " + WinTeam);
                    stmt.executeUpdate("UPDATE TEAM SET Losses   = Losses   + 1 WHERE Name  = " + LossTeam);
                    System.out.println("New game event was added to the database.");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (n == 4) {
                // Set Status of player
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {

                    // Execute a query
                    System.out.print("Please enter the name of the team the player is on: ");
                    String sql = "UPDATE PERSON SET Status =";
                    System.out.print("Please enter the name of the player: ");
                    String name = reader.nextLine();
                    System.out.print("Please enter the status of the player: ");
                    String statusString = reader.nextLine();
                    sql += statusString + "WHERE Name = " + name;
                    stmt.executeUpdate(sql);

                    System.out.println("New status was updated.");

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (n == 6) {
                // once finished
                reader.close();
                exitVal = 1;
            }
        }

    }
}

// import java.sql.*;
// import java.util.Scanner;

// // 4347 Group Project Phase 4
// // Nick Magee,
// public class Project4347Phase4 {
// static final String DB_URL =
// "jdbc:mysql://project-4347-db.cblupithxisz.us-east-2.rds.amazonaws.com/league_management?characterEncoding=latin1&useConfigs=maxPerformance";
// static final String USER = "admin";
// static final String PASS = "4347Password!";
// static final String QUERY = "SELECT id, first, last, age FROM Employees";

// //
// public static void main(String[] args) throws ClassNotFoundException {

// // REFERENCE FOR CONNECTED TO SQL SERVER FOUND AT:
// // https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
// // CONNECTION INFO ABOVE

// // // Open a connection

// // try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
// // Statement stmt = conn.createStatement();
// // ResultSet rs = stmt.executeQuery(QUERY);) {
// // // Extract data from result set
// // while (rs.next()) {
// // // Retrieve by column name
// // System.out.print("ID: " + rs.getInt("id"));
// // System.out.print(", Age: " + rs.getInt("age"));
// // System.out.print(", First: " + rs.getString("first"));
// // System.out.println(", Last: " + rs.getString("last"));
// // }
// // } catch (SQLException e) {
// // e.printStackTrace();
// // }

// int exitVal = 0;

// while (exitVal != 1) {
// Class.forName("com.mysql.jdbc.Driver");
// Scanner reader = new Scanner(System.in); // Reading from System.in
// // OPTIONS
// System.out.println("Select from options below: ");
// System.out.println("1. Insert Player on Team.");
// System.out.println("2. Insert Staff Member on Team.");
// // INSERT MORE OPTIONS HERE
// System.out.println("6. Exit.");
// System.out.println("Enter a number: ");
// int n = reader.nextInt(); // Scans the next token of the input as an int.

// // GO TO SQL FUNTION HERE
// if (n == 1) {

// }
// if (n == 2) {
// try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
// Statement stmt = conn.createStatement();) {
// @SuppressWarnings("resource")
// Scanner input = new Scanner(System.in);
// // Execute a query
// System.out.print("Please enter the date of the Event as YYYY-MM-DD: ");
// String sql = "SELECT * FROM game;";

// } catch (SQLException e) {
// e.printStackTrace();
// }
// }

// if (n == 3) {
// // Open a connection
// try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
// Statement stmt = conn.createStatement();) {
// @SuppressWarnings("resource")
// Scanner input = new Scanner(System.in);
// // Execute a query
// System.out.print("Please enter the date of the Event as YYYY-MM-DD: ");
// String sql = "INSERT INTO GAME_EVENT VALUES (";
// sql += input.nextLine() + ", ";
// System.out.print("Please enter the winning teams name: ");
// sql += input.nextLine() + ", ";
// System.out.print("Please enter the losing teams name: ");
// sql += input.nextLine() + ")";
// stmt.executeUpdate(sql);
// System.out.println("New game event was added to the database.");

// } catch (SQLException e) {
// e.printStackTrace();
// }
// }
// if (n == 6) {
// // once finished
// reader.close();
// exitVal = 1;
// }
// }

// }
// }