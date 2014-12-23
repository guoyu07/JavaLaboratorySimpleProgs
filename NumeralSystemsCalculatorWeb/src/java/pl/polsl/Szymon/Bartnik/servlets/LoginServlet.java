package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.Szymon.Bartnik.models.User;

/**
 * Login servlet responsible for logging in and handling the session mechanism.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    /** Stores users authorized to log in (hardcoded set) */
    private final LinkedList<User> users;
    
    public LoginServlet(){
        
        // Initializes the authorized users set.
        users = new LinkedList<>();
        
        users.add(new User("Simon", "pass1"));
        users.add(new User("Lucas", "pass2"));
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
        
        // Checks if the credentials are correct for any user in the authorized users list.
        boolean isLogged = users.stream()
                .filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password))
                .findFirst()
                .isPresent();
        
        // If authentication data is not correct, refresh the page and show error message.
        if(!isLogged){
            resp.sendRedirect("index.jsp?error=1");
            return;
        }
        
        // If authentication was correct, begin establish the session.
        HttpSession session = req.getSession();
        session.setAttribute("user", userName);
        
        // Set logging out after 30 minutes being inactive
        session.setMaxInactiveInterval(30*60);
        
        // Set cookie used for storing user name and showing it on the page.
        Cookie cookie = new Cookie("user", userName);
        
        // Set max age of cookie - 30 minutes.
        cookie.setMaxAge(30*60);
        resp.addCookie(cookie);
        
        // After establishing session and setting cookie, redirect to the restricted area
        resp.sendRedirect("restricted.jsp");
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
}
