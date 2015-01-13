package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.Szymon.Bartnik.helpers.DerbyUtils;
import pl.polsl.Szymon.Bartnik.models.User;

/**
 * Login servlet responsible for logging in and handling the session mechanism.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/LoginServlet")
public final class LoginServlet extends HttpServlet {
    
    private final Connection connection;
    
    public LoginServlet(){
        
        connection = DerbyUtils.connectToDatabase();
        createTablesIfNecessary();
    }
    
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
        
        req.setCharacterEncoding("UTF-8");
        
        // Gets parameters neccessary for purposes of logging in.
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        
        // If user name was not specified, send error response.
        if(userName == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify userName parameter!");
            return;
        }
        
        // If password was not specified, send error response.
        if(password == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify password parameter!");
            return;
        }
        
        LinkedList<User> users = getUsers();
        
        if(users == null){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "DB unavailable!");
            return;
        }
        
        // Checks if the credentials are correct for any user in the authorized users list.
        User loggedUser = users.stream()
                .filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password))
                .findFirst()
                .orElse(null);
        
        // If authentication data is not correct, refresh the page and show error message.
        if(loggedUser == null){
            resp.sendRedirect("index.jsp?error=1");
            return;
        }
        
        LogInSuccessfull(req, resp, loggedUser);
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
    
    public void createTablesIfNecessary() {

        if(connection == null){
            return;
        }
            
        try {
            // Tworzymy obiekt wyrażenia
            Statement statement = connection.createStatement();
            // Tworzymy pola tabeli
            statement.executeUpdate("CREATE TABLE Users "
                    + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT USERS_PK PRIMARY KEY, "
                    + "username VARCHAR(50) NOT NULL, "
                    + "password VARCHAR(50) NOT NULL)");
            statement.executeUpdate("CREATE TABLE Results"
                    + "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT RESULTS_PK PRIMARY KEY, "
                    + "userid INTEGER NOT NULL CONSTRAINT USERS_FK "
                    + "REFERENCES Users ON DELETE CASCADE ON UPDATE RESTRICT, "
                    + "fromnumeralsystem VARCHAR(50) NOT NULL, "
                    + "tonumeralsystem VARCHAR(50) NOT NULL, "
                    + "numbertoconvert VARCHAR(50) NOT NULL, "
                    + "convertednumber VARCHAR(50) NOT NULL)");
            statement.executeUpdate("INSERT INTO Users(username, password) VALUES ('kneefer', 'kupa')");
            System.out.println("Tables created");
        } catch (SQLException sqle) {
            if(DerbyUtils.tableAlreadyExists(sqle)) {
                return; 
            }
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
    }
    
    @Override
    public void destroy(){
        
        if(connection == null){
            return;
        } 
        
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("SQL exception: " + ex.getMessage());
        }
        super.destroy();
    }

    private LinkedList<User> getUsers() {
        
        if(connection == null){
            return null;
        }
        
        LinkedList<User> users = new LinkedList<>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Users");
            
            while (rs.next()) {
                users.add(new User(rs));
            }
            
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQL exception: " + ex.getMessage());
        }
        return users;
    }

    private void LogInSuccessfull(HttpServletRequest req, HttpServletResponse resp, User loggedUser) 
            throws IOException {
        // If authentication was correct, begin establish the session.
        HttpSession session = req.getSession();
        session.setAttribute("userid", loggedUser.getUserId());
        session.setAttribute("user", loggedUser.getUserName());
        
        // Set logging out after 30 minutes being inactive
        session.setMaxInactiveInterval(30*60);
        
        // Set cookie used for storing user name and showing it on the page.
        Cookie cookie = new Cookie("user", loggedUser.getUserName());
        
        // Set max age of cookie - 30 minutes.
        cookie.setMaxAge(30*60);
        resp.addCookie(cookie);
        
        // After establishing session and setting cookie, redirect to the restricted area
        resp.sendRedirect("restricted.jsp");
    }
}
