/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import AccesoDatos.RegistrarProducto;
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
 * @author USUARIO
 */
@WebServlet(name = "SrvRegistrarProducto", urlPatterns = {"/SrvRegistrarProducto"})
public class SrvRegistrarProducto extends HttpServlet {

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

        RegistrarProducto producto = new RegistrarProducto();
        
        try {
            
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            int idFamilia= Integer.parseInt(request.getParameter("idFamilia"));
            String nombre= request.getParameter("nombre");
            String descripcion= request.getParameter("descripcion");
            //float precio=(float)Integer.parseInt(request.getParameter("precio"));
            float precio=1;
            int stock = Integer.parseInt(request.getParameter("stock"));
            String fecha_alta = request.getParameter("fecha_alta");
            String imagen = request.getParameter("imagen");
            ResultSet res;
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Acceso</title>");
            out.println("<h1>PRODUCTO AÑADIDO</h1>");
            out.println("<form method=\"post\" action=\"SrvAdmin\">");
            out.println("<td><input type=\"submit\" value=\"Atrás\"></td>");
            out.println("</form>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<form action = >");
            
                        
            out.println("<p>Usuario añadido correctamente</p>");
            
                producto.AgregarMDB(idProducto, idFamilia, nombre, descripcion, precio, stock, fecha_alta, imagen);
            
            out.println("</body>");
            out.println("</html>");
            out.close();
            
        } catch (Exception e) {
            //Logger.getLogger(SrvEmpleados.class.getName()).log(Level.SEVERE, null, e);
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
