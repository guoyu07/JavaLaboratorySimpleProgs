package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.Szymon.Bartnik.helpers.DerbyUtils;
import static pl.polsl.Szymon.Bartnik.helpers.DerbyUtils.tableAlreadyExists;
import pl.polsl.Szymon.Bartnik.models.User;

/**
 * Login servlet responsible for logging in and handling the session mechanism.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/LoginServlet")
public final class LoginServlet extends HttpServlet {
    
    private Connection connection;
    
    @Override
    public void init(){
        
        connection = DerbyUtils.connectToDatabase(getServletContext());
        DerbyUtils.createTablesIfNecessary(connection);
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
        String submitType = req.getParameter("bsubmit");
        
        // If user name was not specified, send error response.
        if(userName == null || userName.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify userName parameter!");
            return;
        }
        
        // If password was not specified, send error response.
        if(password == null || password.isEmpty()){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify password parameter!");
            return;
        }
        
        switch(submitType){
            case "login":
                CheckIfCanLogIn(req, resp, userName, password);
                break;
            case "register":
                CheckIfCanRegister(req, resp, userName, password);
                break;
            default:
                // If action parameter was not recognized.
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action!");
        }
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

    private void Login(HttpServletRequest req, HttpServletResponse resp, User loggedUser) 
            throws IOException {
        // If authentication was correct, begin establish the session.
        HttpSession session = req.getSession();
        session.setAttribute("userid", loggedUser.getId());
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

    private void CheckIfCanLogIn(HttpServletRequest req, HttpServletResponse resp, String userName, String password) 
            throws IOException {
        
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
            resp.sendRedirect("index.jsp?error=2");
            return;
        }
        
        Login(req, resp, loggedUser);
    }

    private void CheckIfCanRegister(HttpServletRequest req, HttpServletResponse resp, String userName, String password) 
            throws IOException {
        
        LinkedList<User> users = getUsers();
        
        if(users == null){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "DB unavailable!");
            return;
        }
        
        // Checks if the credentials are correct for any user in the authorized users list.
        User loggedUser = users.stream()
                .filter(x -> x.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
        
        if(loggedUser != null){
            resp.sendRedirect("index.jsp?error=1");
            return;
        }
        
        Register(req, resp, userName, password);
    }

    private void Register(HttpServletRequest req, HttpServletResponse resp, String userName, String password) 
            throws IOException {
        
        try {
            // Tworzymy obiekt wyrażenia
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Users(username, password) VALUES ('" + userName + "', '" + password + "')");
        } catch (SQLException sqle) {
            System.err.println("SQL exception: " + sqle.getMessage());
        } catch (Exception e) {
            System.err.println("Another exception: " + e.getMessage());
        }
        
        CheckIfCanLogIn(req, resp, userName, password);
    }
}
