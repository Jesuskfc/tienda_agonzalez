/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jesuskfc
 */
@WebServlet(name = "SrvAdmin", urlPatterns = {"/SrvAdmin"})
public class SrvAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SrvAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Estas en la sección de administrador</p>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<form method=\"post\" action=\"SrvAlimentacion\">");
            out.println("<td><input type=\"submit\" value=\"Alimentación\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvDrogueria\">");
            out.println("<td><input type=\"submit\" value=\"Droguería\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvPrensa\">");
            out.println("<td><input type=\"submit\" value=\"Prensa\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvFerreteria\">");
            out.println("<td><input type=\"submit\" value=\"Ferretería\"></td>");
            out.println("</form>");
            
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            out.println("<form method=\"post\" action=\"index.jsp\">");
            out.println("<td><input type=\"submit\" value=\"Home\"></td>");
            out.println("</form>");
            
            
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
//            Logger.getLogger(SrvEmpleados.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
