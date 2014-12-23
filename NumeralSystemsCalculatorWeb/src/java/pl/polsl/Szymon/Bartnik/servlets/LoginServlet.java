package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.Szymon.Bartnik.models.User;

/**
 *
 * @author Szymon
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private LinkedList<User> users = new LinkedList<>();
    
    public LoginServlet(){
        
        users.add(new User("Szymon", "pass1"));
        users.add(new User("Łukasz", "pass2"));
    }
    
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
        
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        
        if(userName == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify userName parameter!");
            return;
        }
        
        if(password == null){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "You should specify password parameter!");
            return;
        }
        
        boolean isLogged = users.stream()
                .filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password))
                .findFirst()
                .isPresent();
        
        if(!isLogged){
            resp.sendRedirect("index.jsp?error=1");
            return;
        }
        
        HttpSession session = req.getSession();
        session.setAttribute("user", userName);
        session.setMaxInactiveInterval(30*60);
        
        Cookie cookie = new Cookie("user", userName);
        cookie.setMaxAge(30*60);
        resp.addCookie(cookie);
        
        resp.sendRedirect("restricted.jsp");
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
