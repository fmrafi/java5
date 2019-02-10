/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tanvir
 */
public class HelloServlet extends HttpServlet {

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
        session.setAttribute("message", "'" + request.getParameter("message") 
                + "' on " + new Date());
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath () + "</h1>");
            
            out.println("<h2>Request headers</h2");
            out.println("<ul>");
            Enumeration<String> he = request.getHeaderNames();
            while (he.hasMoreElements()) {
                String h = he.nextElement();
                out.println("<li>" + h + ": " + request.getHeader(h));
            }
            out.println("</ul>");
            
            out.println("<h2>ServletConfig Init Parameters</h2");
            out.println("<ul>");
            Enumeration<String> e1 = getServletConfig().getInitParameterNames();
            while (e1.hasMoreElements()) {
                String i = e1.nextElement();
                out.println("<li>" + i + ": " + getServletConfig().getInitParameter(i));
            }
            out.println("</ul>");
            
            out.println("<h2>ServletContext Init Parameters</h2");
            out.println("<ul>");
            Enumeration<String> e2 = getServletContext().getInitParameterNames();
            while (e2.hasMoreElements()) {
                String i = e2.nextElement();
                out.println("<li>" + i + ": " + getServletContext().getInitParameter(i));
            }
            out.println("</ul>");
            
            out.println("<h2>Input data</h2>");
            out.println("<ul>");
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String p = paramNames.nextElement();
                out.println("<li>" + p + ": " + request.getParameter(p));
            }
            out.println("</ul>");
            
            out.println("<a href=\"" + request.getContextPath () + "\">Home</a>");
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
