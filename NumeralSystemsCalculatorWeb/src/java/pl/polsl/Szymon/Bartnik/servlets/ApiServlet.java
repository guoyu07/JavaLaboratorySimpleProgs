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
 *
 * @author Szymon
 */
@WebServlet("/api")
public class ApiServlet extends HttpServlet {    
    
    /**
     * Handling reports with GET method
     * 
     * @param req Request
     * @param resp Respond to a question
     * @exception ServletException
     * @exception IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("application/json");
        String action = req.getParameter("action");
        
        if(!checkCredentials(req, resp)){
            resp.sendRedirect("index.html");
            return;
        }

        if(action == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify an action context!");
            return;
        }
        
        switch(action){
            case "computeNumber":
                {
                    try {
                        computeNumber(req, resp);
                    } catch (NumberFormatException | NullPointerException | NegativeNumberException ex) {
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                    }
                }
                break;
                
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action!");
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

    private boolean checkCredentials(HttpServletRequest req, HttpServletResponse resp) {
        
        return req.getSession().getAttribute("user") != null;
    }
}
