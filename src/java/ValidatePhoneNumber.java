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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mankank
 */
@WebServlet(urlPatterns = {"/ValidateMobile"})
public class ValidatePhoneNumber extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        /**/
        long mobile = Long.parseLong(request.getParameter("mobile"));
        PrintWriter writer = response.getWriter();
        try {
            boolean result = jdbc.validateMobileNumber(mobile);
            writer.print(result);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ValidatePhoneNumber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
