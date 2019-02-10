/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.webmvc.mydir;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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
        String login_userID = request.getParameter("login.userID");
        String login_password = request.getParameter("login.password");
        if (login_userID != null) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource ds = (DataSource) envCtx.lookup("jdbc/mydirectoryDB");
                conn = ds.getConnection();
                ps = conn.prepareStatement("SELECT * FROM USERS WHERE USERID = ? AND PASSWORD = ?");
                ps.setString(1, login_userID);
                ps.setString(2, login_password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    // found a match
                    user.setUserId(rs.getString("USERID"));
                    user.setSalutation(rs.getString("NAME"));
                    // success, go to list
                    session.setAttribute("message", "success, go to list");
                    response.sendRedirect("list.jsp");
                    //response.sendError(404, "success, go to list");
                } else {
                    // failed, show error
                    session.setAttribute("message", "Invalid credentials, please try again");
                    response.sendRedirect("login_mvc.jsp");
                    //response.sendError(403, "failed, show error");
                }
            } catch (Exception ex) {
                response.sendError(500, ex.getMessage());
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    response.sendError(500, ex.getMessage());
                }
            }
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
