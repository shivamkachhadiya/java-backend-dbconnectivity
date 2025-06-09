package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //init class for connectivity
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/college";
            String username = "root";
            String password = "root123";
            Connection con = DriverManager.getConnection(url, username, password);

            con.setAutoCommit(true);
            System.out.println("connected");

            //set a query for insert data

            String query = "INSERT INTO student VALUES (?, ?)";
            PreparedStatement stm = con.prepareStatement(query);

            for (int i=0;i<4;i++) {

                System.out.println("enter id");
                int id = sc.nextInt();
                sc.nextLine(); // consume leftover newline

                System.out.println("enter name");
                String name = sc.nextLine(); // allows full name with spaces


                //ask data from the user

                stm.setInt(1, id);
                stm.setString(2, name);

                //execute data

                stm.executeUpdate();
            }
            System.out.println("record inserted successfully");

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // show error message if any
        }
    }
}