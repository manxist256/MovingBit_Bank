/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/ViewBalance"})
public class ViewBalance extends HttpServlet {
   @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
        HttpSession session = request.getSession();
        long mobile = (long)session.getAttribute("mobile");
        String pwd = (String)session.getAttribute("pwd");
        PrintWriter writer = response.getWriter();
        try {
            long name = jdbc.getBalance(mobile, pwd);
            writer.println(name);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GetName.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
