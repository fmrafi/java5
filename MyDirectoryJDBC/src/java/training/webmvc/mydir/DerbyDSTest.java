/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.webmvc.mydir;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Tanvir
 */
@WebServlet(name = "DerbyDSTest", urlPatterns = {"/DerbyDSTest"})
public class DerbyDSTest extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DerbyDSTest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DerbyDSTest at " + request.getContextPath() + "</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>USERID</th><th>NAME</th><th>PASSWORD</th></tr>");
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                DataSource ds = (DataSource) envCtx.lookup("jdbc/mydirectoryDB");
                Connection conn = ds.getConnection();
                Statement s = conn.createStatement();
                s.execute("SELECT * FROM USERS");
                ResultSet rs = s.getResultSet();
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("USERID") + "</td>");
                    out.println("<td>" + rs.getString("NAME") + "</td>");
                    out.println("<td>" + rs.getString("PASSWORD") + "</td>");
                    out.println("</tr>");
                }
                conn.close();
            } catch (Exception ex) {
                out.println("<pre>");
                ex.printStackTrace(out);
                out.println("</pre>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
