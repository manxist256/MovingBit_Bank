
import java.sql.Connection;
import java.sql.DriverManager;
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
    public static void createAccount(String name, String password, String gender, long mobile) throws ClassNotFoundException, SQLException {
        String query = "insert into account_details values(" + "'" + name + "','" + password + "'," + mobile + ",'" + gender + "'," + 0 + ")";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3310/Bank","kbk","ytkd0CSIK656f2ZL");
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
