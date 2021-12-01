import java.sql.*;
import java.util.Scanner;

// 4347 Group Project Phase 4
// Nick Magee, David Nguyen, Michael Stinnett, Ryan Waller, Richard Gatchalian
public class Project4347Phase4 {
    static final String DB_URL = "jdbc:mysql://project-4347-db.cblupithxisz.us-east-2.rds.amazonaws.com/league_management?characterEncoding=latin1&useConfigs=maxPerformance";
    static final String USER = "admin";
    static final String PASS = "4347Password!";

    public static void main(String[] args) throws ClassNotFoundException {

        // REFERENCE FOR CONNECTED TO SQL SERVER FOUND AT:
        // https://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
        // CONNECTION INFO ABOVE

        int exitVal = 0;

        while (exitVal != 1) {
            Class.forName("com.mysql.jdbc.Driver");
            Scanner reader = new Scanner(System.in); // Reading from System.in
            // OPTIONS
            System.out.println("Select from options below: ");
            System.out.println("1. Insert Player or Staff Member on team.");
            System.out.println("2. Display people in a team.");
            System.out.println("3. Add a game event.");

            System.out.println("5. Display Team with most Tournament Wins.");

            // INSERT MORE OPTIONS HERE
            System.out.println("6. Exit.");
            System.out.println("Enter a number: ");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            reader.nextLine();
            // GO TO SQL FUNTION HERE
            if (n == 1) {
                try (
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {

                    boolean player = false;
                    String queryPerson = "INSERT INTO PERSON(Name, Status, Join_date) VALUES (";
                    String queryPlayer = "INSERT INTO PLAYER(Wins, Losses, Years_played, Name) VALUES (";
                    String queryStaff = "INSERT INTO STAFF_MEMBER(Type, Name) VALUES (";
                    String queryEmploys = "INSERT INTO EMPLOYS(Team_name, Person_name) VALUES (";

                    // CHOOSE A GAME
                    ResultSet rs = stmt.executeQuery("SELECT * FROM GAME");

                    System.out.println("------------ ");
                    System.out.println("Games: ");
                    while (rs.next()) {
                        System.out.println(rs.getString("Name"));
                    }
                    System.out.println("------------ ");
                    System.out.println("Choose a game: ");
                    String gameName = "'" + reader.nextLine() + "'";

                    // CHOOSE A LEAGUE
                    rs = stmt.executeQuery("SELECT * FROM LEAGUE WHERE Game = " + gameName);
                    System.out.println("------------ ");
                    System.out.println("LEAGUES: ");
                    while (rs.next()) {
                        System.out.println(rs.getString("Name"));
                    }
                    System.out.println("------------ ");
                    System.out.println("Choose a league: ");
                    String leagueName = "'" + reader.nextLine() + "'";

                    // CHOOSE A TEAM
                    rs = stmt.executeQuery("SELECT * FROM TEAM WHERE League = " + leagueName);
                    System.out.println("------------ ");
                    System.out.println("TEAMS: ");
                    while (rs.next()) {
                        System.out.println(rs.getString("Name"));
                    }
                    System.out.println("------------ ");
                    System.out.println("Choose a team: ");
                    String teamName = "'" + reader.nextLine() + "'";

                    // PERSON DETAILS
                    System.out.print("Type a name: ");
                    String plainName = reader.nextLine();
                    String name = "'" + plainName + "',";

                    System.out.print("Type a status: ");
                    String status = "'" + reader.nextLine() + "',";

                    System.out.print("Type Join Date: ");
                    String joinDate = "'" + reader.nextLine() + "')";

                    // PLAYER OR STAFF MEMBER?

                    System.out.println("Would you like to insert a player or staff member? Type 'p' or 's': ");
                    String pOrS = reader.nextLine();
                    if (pOrS.equals("p")) {
                        player = true;
                    } else {
                        player = false;
                    }

                    // INSERT PERSON
                    stmt.executeUpdate(queryPerson + name + status + joinDate);

                    if (player) {
                        System.out.print("Type wins: ");
                        String wins = "'" + reader.nextLine() + "',";
                        System.out.print("Type losses: ");
                        String losses = "'" + reader.nextLine() + "',";
                        System.out.print("Type years played: ");
                        int years = reader.nextInt();
                        reader.nextLine();
                        // INSERT PLAYER
                        // System.out.println(queryPlayer + wins + losses + years + ", '" + plainName +
                        // "')");
                        stmt.executeUpdate(queryPlayer + wins + losses + years + ", '" + plainName + "')");
                    } else {
                        System.out.print("Type a type: ");
                        String type = "'" + reader.nextLine() + "',";
                        // System.out.println(queryStaff + type + "'" plainName + "')");
                        stmt.executeUpdate(queryStaff + type + "'" + plainName + "')");
                    }

                    // INSERT INTO MANY TO MANY
                    String query = queryEmploys + teamName + ", '" + plainName + "')";
                    System.out.println(query);
                    stmt.executeUpdate(query);

                    System.out.println("Success!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (n == 2) {
                try (
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {
                    // Execute a query
                    System.out.print("Please enter the name of the Team: ");
                    String teamName = "'" + reader.nextLine() + "'";

                    ResultSet rs = stmt.executeQuery("SELECT Person_name FROM EMPLOYS WHERE Team_name = " + teamName);
                    while (rs.next()) {
                        // Display values
                        System.out.println("Name: " + rs.getString("Person_name"));
                    }

                    System.out.println("New game event was added to the database.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (n == 3) {
                try (
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {
                    // Execute a query
                    System.out.print("Please enter the date of the Event as DD-MM-YYYY: ");
                    String date = "'" + reader.nextLine() + "'";
                    System.out.print("Please enter the winning teams name: ");
                    String WinTeam = "'" + reader.nextLine() + "'";
                    System.out.print("Please enter the losing teams name: ");
                    String LossTeam = "'" + reader.nextLine() + "'";
                    stmt.executeUpdate(
                            "INSERT INTO GAME_EVENT VALUES (" + date + ", " + WinTeam + "," + LossTeam + ")");
                    stmt.executeUpdate("UPDATE TEAM SET Wins  = Wins + 1 WHERE Name  = " + WinTeam);
                    stmt.executeUpdate("UPDATE TEAM SET Losses   = Losses  + 1 WHERE Name  = " + LossTeam);

                    ResultSet rs = stmt.executeQuery("SELECT Wins FROM TEAM WHERE Name = " + WinTeam);
                    rs.first();
                    System.out.println(WinTeam + " Wins: " + rs.getInt("Wins"));
                    rs = stmt.executeQuery("SELECT Losses FROM TEAM WHERE Name = " + LossTeam);
                    rs.first();
                    System.out.println(LossTeam + " Losses: " + rs.getInt("Losses"));

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
            if (n == 5) {
                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();) {
                    String sql = "Select School, Name, Game, Tournements_won From TEAM Where Tournements_won = (Select Max(Tournements_won) From TEAM);";
                    ResultSet rs = stmt.executeQuery(sql);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnsNumber = rsmd.getColumnCount();

                    // Iterate through the data in the result set and display it.
                    while (rs.next()) {
                        // Print one row
                        for (int i = 1; i <= columnsNumber; i++) {
                            System.out.print(rs.getString(i) + " "); // Print one element of a row
                        }
                        System.out.println();// Move to the next line to print the next row.
                    }

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
