/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ListController", urlPatterns = {"/list"})
public class ListController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            Statement s = conn.createStatement();
            s.execute("SELECT pid, p.name pname, s.name sname, pr.name prname, pr.price"
                    + " FROM mystore.product AS p, mystore.supplier AS s, mystore.price AS pr"
                    + " WHERE p.sid = s.sid AND"
                    + " p.pgid = pr.pgid AND"
                    + " pr.name = 'pos' AND"
                    + " CURDATE() BETWEEN pr.date_from AND pr.date_to;");
            ResultSet rs = s.getResultSet();
            Order order = new Order();
            order.setOrderID(1);
            while (rs.next()) {
                OrderLine line = new OrderLine();
                line.setOrderID(order.getOrderID());
                line.setProduct(rs.getString("pname"));
                line.setSupplier(rs.getString("sname"));
                line.setPriceType(rs.getString("prname"));
                line.setQuantity(1);
                line.setPrice(rs.getBigDecimal("price"));
                order.getLines().add(line);
            }
            request.getSession().setAttribute("order", order);
        } catch (Exception ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        request.getServletContext().
                getRequestDispatcher("/list.jsp").forward(request, response);
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
