package javaapplication181;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javaapplication181.User;

public class CRUD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean test = false;
        do {
            System.out.println("!!!!! Welocome to User CRUD Sevices !!!!!");
            System.out.println("-----------------------------------------");
            System.out.println("Enter the Operation you want to perform");
            System.out.println("1. Registration");
            System.out.println("2. Update");
            System.out.println("3. Display Data");
            System.out.println("4. Delete ");
            System.out.println("0. Exit ");
            System.out.println("-----------------------------------------");

            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    Create();
                    break;
                case 2:
                    Update();
                    break;
                case 3:
                    Read();
                    break;
                case 4:
                    Delete();
                    break;
                case 0:
                    test = true;
                    System.exit(operation);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (test == false);

    }

    public static void Create() {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/CRUD?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbuser, dbpass);
            String sql = "INSERT INTO user (user_id, firstname, lastname, email) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            System.out.println("Enter User ID");
            int id = sc.nextInt();
            System.out.println("Enter your FirstName");
            String firstName = sc.next();
            System.out.println("Enter your LasttName");
            String lastName = sc.next();
            System.out.println("Enter your email");
            String email = sc.next();
            statement.setString(1, String.valueOf(id));
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Read() {

        String url = "jdbc:mysql://localhost:3306/CRUD?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "root";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbuser, dbpass);
            String sql = "Select * from user";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<User> a1 = new ArrayList<User>();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                user.setLastname(rs.getString(3));
                user.setEmail(rs.getString(4));
                a1.add(user);

            }
            for (int i = 0; i < a1.size(); i++) {
                System.out.println(a1.get(i));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void Update() {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/CRUD?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "root";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbuser, dbpass);
            System.out.println("Enter user id you want to update");
            int id = sc.nextInt();
            System.out.println("Renter your firstname,lastname and email for updating the records");
            String firstName = sc.next();
            String lastName = sc.next();
            String email = sc.next();

            String sql = "UPDATE user SET firstName = ?, lastName = ?, email = ? WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, String.valueOf(id));

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Delete() {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/CRUD?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        String dbuser = "root";
        String dbpass = "root";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbuser, dbpass);
            System.out.println("Enter user id you want to delete");
            int id = sc.nextInt();

            String sql = "Delete from user WHERE user_id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
