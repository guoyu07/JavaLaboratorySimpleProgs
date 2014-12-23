package pl.polsl.Szymon.Bartnik.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
    
    LinkedList<Object[]> results = new LinkedList<>();
    
    
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
        
        String loggedUser = checkCredentialsAndGetNickName(req, resp);
        if(loggedUser == null){
            resp.sendRedirect("index.html");
            return;
        }

        if(action == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify an action context!");
            return;
        }
        
        switch(action){
            case "getResults":
                getResults(resp);
                break;
            
            case "computeNumber":
                {
                    try {
                        computeNumber(req, resp, loggedUser);
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

    private void getResults(HttpServletResponse resp) 
            throws IOException {
        
        String jsonResults = new Gson().toJson(results);
        
        PrintWriter out = resp.getWriter();
        out.write(jsonResults);
    }

    private void computeNumber(HttpServletRequest req, HttpServletResponse resp, String loggedUser)
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
        
        results.add(result.convertToWebRow(loggedUser));
        
        String jsonResult = new Gson().toJson(result.convertToTableRow());
        
        PrintWriter out = resp.getWriter();
        out.write(jsonResult);
    }

    private String checkCredentialsAndGetNickName(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
