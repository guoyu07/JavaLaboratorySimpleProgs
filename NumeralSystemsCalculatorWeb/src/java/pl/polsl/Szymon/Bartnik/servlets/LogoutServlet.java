package pl.polsl.Szymon.Bartnik.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout servlet responsible for logging out and ending the session mechanism.
 * 
 * @author Szymon Bartnik (grupa 2)
 * @version 1.0
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    
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
        
        resp.setContentType("text/html");

        //Invalidate the session if exists
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        
        Cookie loginCookie = null;
        
        // Find the cookie storing logged in user's username
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")){
                    loginCookie = cookie;
                    break;
                }
            }
        }
        
        // If found looked for cookie, destroy it by setting its lifetime to 0.
        // The browser will delete it immediately.
        if(loginCookie != null){
            loginCookie.setMaxAge(0);
            resp.addCookie(loginCookie);
        }
        
        // Redirect to the logging in page after logging out.
        resp.sendRedirect("index.jsp");
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
