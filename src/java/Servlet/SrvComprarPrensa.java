/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import AccesoDatos.AccesoProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SrvComprarPrensa", urlPatterns = {"/SrvComprarPrensa"})
public class SrvComprarPrensa extends HttpServlet {

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
        
        AccesoProductos productos = new AccesoProductos();
        
        
        int idProducto, idFamilia, stock;
        float precio;
        String nombre, descripcion, fecha_alta, imagen;
        
        idFamilia=0;
        idProducto=0;
        stock=0;
        precio=0;
        nombre="";
        descripcion="";
        fecha_alta="";
        imagen="";
        
        
      
        
        try {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SrvAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Estas comprando</p>");
            
            out.println("<table>");
            out.println("<tr>");
            out.println("<form method=\"post\" action=\"SrvComprarAlimentacion\">");
            out.println("<td><input type=\"submit\" value=\"Alimentación\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvComprarDrogueria\">");
            out.println("<td><input type=\"submit\" value=\"Droguería\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvComprarPrensa\">");
            out.println("<td><input type=\"submit\" value=\"Prensa\"></td>");
            out.println("</form>");
            
            out.println("<form method=\"post\" action=\"SrvComprarFerreteria\">");
            out.println("<td><input type=\"submit\" value=\"Ferretería\"></td>");
            out.println("</form>");
            
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<td>idProducto</td>");
            out.println("<td>idFamilia</td>");
            out.println("<td>nombre</td>");
            out.println("<td>descripcion</td>");
            out.println("<td>precio</td>");
            out.println("<td>stock</td>");
            out.println("<td>fecha_alta</td>");
            out.println("<td>imagen</td>");
            out.println("</tr>");
            
            
            int familia = 4; //Esta familia corresponde a la alimentación.
            ResultSet res = productos.ListarMDB(familia);
            
            while (res.next()){
                idProducto = res.getInt("idProducto");
                idFamilia =  res.getInt("idFamilia");
                nombre = res.getString("nombre");
                descripcion = res.getString("descripcion");
                precio = res.getFloat("precio");
                stock = res.getInt("stock");
                fecha_alta = res.getString("fecha_alta");
                imagen = res.getString("imagen");
                
                out.println("<tr>");
                out.println("<td>"+ idProducto +"</td>");
                out.println("<td>"+ idFamilia +"</td>");
                out.println("<td>"+ nombre +"</td>");
                out.println("<td>"+ descripcion +"</td>");
                out.println("<td>"+ precio+"</td>");
                out.println("<td>"+ stock +"</td>");
                out.println("<td>"+ fecha_alta +"</td>");
                out.println("<td>"+ imagen +"</td>");
                out.println("<td><INPUT TYPE=\"NUMBER\" MIN=\"1\" MAX=\""+stock+"\" STEP=\"1\" VALUE=\"6\" SIZE=\"6\"></td>");
                out.println("</tr>");      
                

            }
            
            
            
            out.println("</table>");
            
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            
            out.println("<form method=\"post\" action=\"SrvMostrarSesion\">");
            out.println("<td><input type=\"submit\" value=\"Ver Cesta\"></td>");
            out.println("</form>");
            
            
            
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
