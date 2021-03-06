/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import AccesoDatos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
 * @author USUARIO
 */
@WebServlet(name = "SrvActualizarProducto", urlPatterns = {"/SrvActualizarProducto"})
public class SrvActualizarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
                       
            ResultSet res;                                  
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int idFamilia= Integer.parseInt(request.getParameter("idFamilia"));
            String nombre= request.getParameter("nombre");
            String descripcion= request.getParameter("descripcion");
            //float precio=(float)Integer.parseInt(request.getParameter("precio"));
            float precio= Float.parseFloat(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            String fecha_alta = request.getParameter("fecha_alta");
            String imagen = request.getParameter("imagen");
            
            
            
            ActualizarProducto productos = new ActualizarProducto();

            productos.ActualizarMDB(idProducto,idFamilia,  nombre,  descripcion,  precio,  stock,  fecha_alta, imagen);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"fondo.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<title>Servlet SrvActualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<p>"+idProducto+ idFamilia+ nombre+ "</p>");
            out.println("<h1>PRODUCTO ACTUALIZADO</h1>");
            out.println("<form method=\"post\" action=\"SrvAdmin\">");
            out.println("<td><input type=\"submit\" value=\"Atrás\"></td>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
           // Logger.getLogger(SrvEmpleados.class.getName()).log(Level.SEVERE, null, e);
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
