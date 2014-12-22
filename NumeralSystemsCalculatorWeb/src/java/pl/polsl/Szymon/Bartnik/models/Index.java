/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.Szymon.Bartnik.models;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.Szymon.Bartnik.controller.CalculatorController;
import pl.polsl.Szymon.Bartnik.models.exceptions.NegativeNumberException;

/**
 *
 * @author Szymon
 */
public class Index extends HttpServlet {
    /**
     * Handling reports with GET method
     * 
     * @param req Request
     * @param resp Respond to a question
     * @exception ServletException
     * @exception IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("text/html; charset=ISO-8859-2");
            PrintWriter out = resp.getWriter();
            
            CalculatorController controller = new CalculatorController(new String[] { "bin", "dec" });
            String result = controller.convertNumber("101010101").getOutputNumber();
            
            out.println("<html><body><p>" + result + "</p></body></html>");
        } catch (NumberFormatException | NullPointerException | NegativeNumberException ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Handling reports with POST method
     * 
     * @param req Request
     * @param resp Respond to a question
     * @exception ServletException
     * @exception IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
