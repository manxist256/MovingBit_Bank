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
import javax.servlet.http.HttpSession;

/**
 *
 * @author mankank
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
        String password = request.getParameter("pwd_lg");
        long mobile = Long.parseLong(request.getParameter("ph_num_lg"));
        boolean result = false;
        try {
            result = jdbc.validateLogin(mobile, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("mobile", mobile);
            session.setAttribute("pwd", password);
            RequestDispatcher dispatcher = request.getRequestDispatcher("transaction_page.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("incorrectlogin.html");
            dispatcher.forward(request, response);
        }
    }
}
