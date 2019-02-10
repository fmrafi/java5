/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.webmvc.mydir;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tanvir
 */
public class LoginController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = null;
        Object o = session.getAttribute("user");
        if (o != null && o instanceof User) {
            user = (User) o;
        } else {
            user = new User();
            session.setAttribute("user", user);
        }
        if (user.getUserId() != null) {
            // already logged in, go to list
            session.setAttribute("message", "already logged in, go to list");
            response.sendRedirect("list.jsp");
            //response.sendError(404, "already logged in, go to list");
            return;
        }
        // not logged in, check credentials
        ServletConfig config = getServletConfig();
        //ServletContext config = getServletContext();
        String login_userID = request.getParameter("userID");
        String login_password = request.getParameter("password");
        if (login_userID != null && login_password != null) {
            if (config.getInitParameter("userid").equals(login_userID)
                    && config.getInitParameter("password").equals(login_password)) {
                user.setUserId(login_userID);
                user.setSalutation(config.getInitParameter("salutation"));
                // success, go to list
                session.setAttribute("message", "success, go to list");
                response.sendRedirect("list.jsp");
                //response.sendError(404, "success, go to list");
                return;
            }
            // failed, show error
            session.setAttribute("message", "Invalid credentials, please try again");
            response.sendRedirect("login_mvc.jsp");
            //response.sendError(403, "failed, show error");
            return;
        }
        session.setAttribute("message", "Please log in");
        response.sendRedirect("login_mvc.jsp");
        return;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
