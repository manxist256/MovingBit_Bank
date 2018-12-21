
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mankank
 */
public class jdbc {
    
    public static String getName(long mobile, String pwd) throws ClassNotFoundException, SQLException {
        String query = "select * from account_details";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bank","kbk","ytkd0CSIK656f2ZL");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        while (true) {
            resultset.next();
            if (String.valueOf(mobile).equals(resultset.getString(3)) && pwd.equals(resultset.getString(2))) {
                return resultset.getString(1);
            }
            if (resultset.isLast()) {
                break;
            }
        }
        return null;
    }
    
    public static boolean validateLogin(long mobile, String pwd) throws ClassNotFoundException, SQLException {
        String query = "select * from account_details";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bank","kbk","ytkd0CSIK656f2ZL");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        while (true) {
            resultset.next();
            if (String.valueOf(mobile).equals(resultset.getString(3)) && pwd.equals(resultset.getString(2))) {
                return true;
            }
            if (resultset.isLast()) {
                break;
            }
        }
        return false;
    }
    
    public static boolean validateMobileNumber(long mobile) throws ClassNotFoundException, SQLException {
        String query = "select * from account_details";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bank","kbk","ytkd0CSIK656f2ZL");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        while (true) {
            resultset.next();
            if (String.valueOf(mobile).equals(resultset.getString(3))) {
                return true;
            }
            if (resultset.isLast()) {
                break;
            }
        }
        return false;
    }
    public static void createAccount(String name, String password, String gender, long mobile) throws ClassNotFoundException, SQLException {
        String query = "insert into account_details values(" + "'" + name + "','" + password + "'," + mobile + ",'" + gender + "'," + 0 + ")";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bank","kbk","ytkd0CSIK656f2ZL");
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
