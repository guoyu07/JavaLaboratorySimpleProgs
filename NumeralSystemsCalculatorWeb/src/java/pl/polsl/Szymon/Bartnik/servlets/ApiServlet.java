package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.Szymon.Bartnik.controller.CalculatorController;
import pl.polsl.Szymon.Bartnik.models.ConversionResult;
import pl.polsl.Szymon.Bartnik.models.exceptions.NegativeNumberException;

/**
 * Api servlet which is accessible from /api link and correct request
 * to this endpoint returns computed number. 
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/api")
public class ApiServlet extends HttpServlet {    
    
    /**
     * Handling reports with GET method
     * 
     * @param req Request
     * @param resp Respond to a question
     * @exception ServletException if any servlet exception occured
     * @exception IOException if any IOException occured
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("application/json");
        
        // Get action parameter identifying which action we are about to handle.
        String action = req.getParameter("action");
        
        // If user invoking request is not logged, redirect to the logging in page.
        if(!checkCredentials(req, resp)){
            resp.sendRedirect("index.html");
            return;
        }

        // If action parameter was not specified, inform about the problem.
        if(action == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify an action context!");
            return;
        }
        
        // Recognises which action we are about to perform and do it
        recognizeAndPerformAction(req, resp, action);
    }
    
    /**
     * Handling reports with POST method
     * 
     * @param req Request
     * @param resp Respond to a question
     * @exception ServletException if any servlet exception occured
     * @exception IOException if any IOException occured
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Computes the number in other numeral system and sends JSON result.
     * 
     * @param req Request
     * @param resp Respond to a question
     * @throws IOException if any IOException occured
     * @throws NumberFormatException if in any step of conversion occured an error connected
     * with wrong format of converted number.
     * @throws NullPointerException if passed null argument
     * @throws NegativeNumberException if passed negative number
     */
    private void computeNumber(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, NumberFormatException, NullPointerException, NegativeNumberException {
        
        String fromNumeralSystem = req.getParameter("from");
        String toNumeralSystem   = req.getParameter("to");
        String numberToConvert   = req.getParameter("number");
        
        if(fromNumeralSystem == null ||
           toNumeralSystem == null ||
           numberToConvert == null){
            
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Not all parameters specified!");
            return;
        }
        
        String[] invokeParamters = new String[] { fromNumeralSystem, toNumeralSystem };
        
        CalculatorController controller = new CalculatorController(invokeParamters);
        ConversionResult result = controller.convertNumber(numberToConvert);

        PrintWriter out = resp.getWriter();
        out.write(result.getOutputNumber());
    }

    /**
     * Checks if user performing the action on the servlet is authorized.
     * 
     * @param req Request
     * @param resp Respond to a question
     * @return if credentials was fulfilled
     */
    private boolean checkCredentials(HttpServletRequest req, HttpServletResponse resp) {
        
        return req.getSession().getAttribute("user") != null;
    }

    /**
     * Recognizes action to perform in this API servlet and performs the action.
     * 
     * @param req Request
     * @param resp Respond to a question
     * @param action Action to recognize and perform
     * @throws IOException if any IOException occured
     */
    private void recognizeAndPerformAction(HttpServletRequest req, HttpServletResponse resp, String action) 
            throws IOException {
        
        switch(action){
            // If we were about to invoke 'computeNumber' action
            case "computeNumber":
                {
                    try {
                        // Try to compute number
                        computeNumber(req, resp);
                    } catch (NumberFormatException | NullPointerException | NegativeNumberException ex) {
                        // Inform about caller about error if any occured
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                    }
                }
                break;
                
            default:
                // If action parameter was not recognized.
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action!");
        }
    }
}
