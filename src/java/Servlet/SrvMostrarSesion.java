/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Productos.CantidadProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "SrvMostrarSesion", urlPatterns = {"/SrvMostrarSesion"})
public class SrvMostrarSesion extends HttpServlet {

    public String cadena;

    public String getCadena() {
        return cadena;
    }

    
    
    
    
    
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
 
            HttpSession sesion = request.getSession();
            
            
            ArrayList<CantidadProducto> cesta = (ArrayList<CantidadProducto>) sesion.getAttribute("cesta");
            
            response.setContentType("text/html");
            
            cadena = "";
            
            for(CantidadProducto p: cesta){
                
                cadena = cadena + "El producto es :  ";
                cadena = cadena +p.getIdProducto();
                cadena = cadena + " y esta es la cantidad :  ";
                cadena = cadena +p.getCantidad();
                cadena = cadena + " . ";
                
            }
             
            
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SrvMostrarSesion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1> " + cadena + " </h1>");
//            out.println("<form method=\"post\" action=\"SrvComprar\">");
//            out.println("<td><input type=\"submit\" value=\"Atrás\"></td>");
//            out.println("</form>");
//            out.println("</body>");
//            out.println("</html>");
        } finally {            
            out.close();
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
