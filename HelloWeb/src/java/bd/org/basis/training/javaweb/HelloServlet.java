/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.org.basis.training.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello Servlet!</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hi There!</h1>");
            out.println("<h2>Servlet HelloServlet at " + request.getContextPath () + "</h2>");

            out.println("<h3>Init parameters</h3>");
            out.println("<ul>");
            Enumeration<String> eip = getServletConfig().getInitParameterNames();
            while (eip.hasMoreElements()) {
                String s = eip.nextElement();
                out.println("<li>" + s + ": " + getServletConfig().getInitParameter(s));
            }
            out.println("</ul>");
            
            out.println("<h3>Parameters</h3>");
            out.println("<ul>");
            Map<String, String[]> parameters = request.getParameterMap();
            for (Map.Entry<String, String[]> e: parameters.entrySet()) {
                out.println("<li>" + e.getKey() + ": ");
                out.println("<ul>");
                for (String s: e.getValue()) {
                    out.println("<li>" + s);
                }
                out.println("</ul>");
            }
            out.println("</ul>");
            
            out.println("<h3>Headers</h3>");
            out.println("<ul>");
            Enumeration<String> eh = request.getHeaderNames();
            while (eh.hasMoreElements()) {
                String s = eh.nextElement();
                out.println("<li>" + s + ": " + request.getHeader(s));
            }
            out.println("</ul>");
            
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
