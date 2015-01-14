package pl.polsl.Szymon.Bartnik.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pl.polsl.Szymon.Bartnik.helpers.DerbyUtils;
import pl.polsl.Szymon.Bartnik.models.Result;
import pl.polsl.Szymon.Bartnik.models.User;

/**
 * Login servlet responsible for showing tables in DB
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/DbEntriesServlet")
public class DbEntriesServlet extends HttpServlet {
    
    private Connection connection;
    
    @Override
    public void init(){
        
        connection = DerbyUtils.connectToDatabase(getServletContext());
        DerbyUtils.createTablesIfNecessary(connection);
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("application/json");
        
        // Get action parameter identifying which action we are about to handle.
        String action = req.getParameter("action");
        
        // If action parameter was not specified, inform about the problem.
        if(action == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify an action context!");
            return;
        }
        
        LinkedList<Result> resultResults = new LinkedList<>();
        LinkedList<User> userResults = new LinkedList<>();
        
        try {
            Statement statement = connection.createStatement();
            // Create and send a response.
            PrintWriter out = resp.getWriter();
            
            switch(action){
                case "resultsTable":
                    ResultSet rsResults = statement.executeQuery("SELECT * FROM Results");
            
                    while(rsResults.next()){
                        resultResults.add(new Result(rsResults));
                    }
                    out.write(new Gson().toJson(resultResults));
                    break;
                case "usersTable":
                    ResultSet rsUsers = statement.executeQuery("SELECT * FROM Users");
            
                    while(rsUsers.next()){
                        userResults.add(new User(rsUsers));
                    }
                    out.write(new Gson().toJson(userResults));
                    break;
                default:
                    // If action parameter was not recognized.
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action!");
                    return;
            }
        } catch (SQLException ex) {
            // Inform about caller about error if any occured
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
