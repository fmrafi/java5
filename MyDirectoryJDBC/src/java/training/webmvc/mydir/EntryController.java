/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training.webmvc.mydir;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tanvir
 */
@WebServlet(name = "EntryController", urlPatterns = {"/entry"})
public class EntryController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            out.println("<title>Servlet EntryController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EntryController at " + request.getContextPath() + "</h1>");
            out.println("<h2>Request Method: " + request.getMethod() + "</h2>");
            out.println("</body>");
            out.println("</html>");
             
        } finally {            
            out.close();
        }
    }// </editor-fold>

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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        session.removeAttribute("entry");
        DirectoryEntry entry = null;
        // lookup the entry by id
        Directory directory = (Directory) session.getAttribute("directory");
        String id = request.getParameter("id");
        for (DirectoryEntry d : directory.getEntries()) {
            if (d.getID().equals(id)) {
                entry = new DirectoryEntry();
                entry.setID(id);
                entry.setFirstName(d.getFirstName());
                entry.setLastName(d.getLastName());
                entry.setDateOfBirth((Date)d.getDateOfBirth().clone());
                entry.setPhoneNumber(d.getPhoneNumber());
                
                session.setAttribute("entry", entry);
                //response.sendError(404, "Entry found, ID: " + id);
                response.sendRedirect("edit.jsp");
                return;
            }
        }
        if (entry == null) {
            //response.sendError(404, "Entry not found, ID: " + id);
            session.setAttribute("message", "Entry not found, ID: " + id);
            response.sendRedirect("list.jsp");
        }
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        DirectoryEntry entry = (DirectoryEntry) session.getAttribute("entry");
        if (entry == null) {
            //response.sendError(404, "Entry not found, ID: " + id);
            session.setAttribute("message", "Entry not found");
            response.sendRedirect("list.jsp");
            return;
        }
        
        // lookup the entry by id
        Directory directory = (Directory) session.getAttribute("directory");
        String id = entry.getID();
        for (DirectoryEntry d : directory.getEntries()) {
            if (d.getID().equals(id)) {
                d.setFirstName(request.getParameter("entry.firstName"));
                d.setLastName(request.getParameter("entry.lastName"));
                try {
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    d.setDateOfBirth(formatter.parse(request.getParameter("entry.dateOfBirth")));
                } catch (ParseException ex) {
                    Logger.getLogger(EntryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                d.setPhoneNumber(request.getParameter("entry.phoneNumber"));
                session.setAttribute("message", "Entry updated, ID: " + id);
                response.sendRedirect("list.jsp");
                return;
            }
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
