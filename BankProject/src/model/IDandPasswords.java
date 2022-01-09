package model;

import controller.DBConnection;
import model.Account;
import model.Account_Checking;
import model.Account_Savings;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IDandPasswords {

    private HashMap<String, Account> accounts = new HashMap<String, Account>();

    public IDandPasswords() throws FileNotFoundException {
        accounts = createHashMap();
        writeInFile(accounts);
        writeInConsole(accounts);
    }

    public HashMap<String, Account> getLoginInfo() {
        return accounts;
    }

    public HashMap<String, Account> createHashMap() {
        HashMap<String, Account> accounts = new HashMap<String, Account>();
        DBConnection dbConnect = new DBConnection();

        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        con = DBConnection.connectDB();

        try {
            String sql = "select * from clients";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                String name = rs.getString("client_name");
                String CNP = rs.getString("cnp");
                String accountType = rs.getString("account_type");
                double initDeposit = rs.getDouble("initial_deposit");
                // System.out.println(name + "\t\t" + cnp
                //        + "\t\t" + account_type + "\t\t" + initialDeposit);

                if(accountType.equals("Savings")) {
                    accounts.put(CNP, new Account_Savings(name, CNP, initDeposit));
                }
                else if (accountType.equals("Checking")) {
                    accounts.put(CNP, new Account_Checking(name, CNP, initDeposit));
                }
                else {
                    System.out.println("Error reading account type");
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return accounts;
    }

    public void writeInConsole(HashMap<String, Account> accounts) {
        for (Map.Entry<String, Account> set : accounts.entrySet()) {
            String s = set.getValue().printInfo();
            System.out.println(s);
            System.out.println();
        }
    }

    public void writeInFile(HashMap<String, Account> accounts) throws FileNotFoundException {
        File file = new File("C:\\Users\\Daniel G\\Desktop\\output.txt");

        PrintStream oldStream = System.out;

        // Instantiating the Print Stream Class
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        for (Map.Entry<String, Account> set : accounts.entrySet()) {
            String s = null;
            s = set.getValue().showInfo();
            System.out.println(s);
            System.out.println();
        }

        System.setOut(oldStream);
    }
}
