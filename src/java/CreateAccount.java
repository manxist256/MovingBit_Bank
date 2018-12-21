/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mankank
 */
@WebServlet(urlPatterns = {"/AccountCreate"})
public class CreateAccount extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
        String name = request.getParameter("fullname");
        String password = request.getParameter("pwd");
        long mobile = Long.parseLong(request.getParameter("ph_num"));
        String gender = request.getParameter("gender");
        try {
            jdbc.createAccount(name, password, gender, mobile);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("accountcreated.html");
        dispatcher.forward(request, response);
    }
}
