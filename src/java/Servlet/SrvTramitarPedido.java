/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import AccesoDatos.AddPedido;
import AccesoDatos.RegistrarProducto;
import Productos.CantidadProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jesuskfc
 */
@WebServlet(name = "SrvTramitarPedido", urlPatterns = {"/SrvTramitarPedido"})
public class SrvTramitarPedido extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SrvTramitarPedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SrvTramitarPedido at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        AddPedido pedido = new AddPedido();
        
        try {
            
            HttpSession sesion = request.getSession();
            
            
            ArrayList<CantidadProducto> cesta = (ArrayList<CantidadProducto>) sesion.getAttribute("cesta");
            
            
            
            String cest = "";
            
            for(CantidadProducto p: cesta){
                
                cest = cest + "El producto es :  ";
                cest = cest +p.getIdProducto();
                cest = cest + " y esta es la cantidad :  ";
                cest = cest +p.getCantidad();
                cest = cest + " . ";
                
            }
            
            
            
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<title>Acceso</title>");
            
            
            out.println("</head>");
            out.println("<body>");
            //out.println("<form action = >");
            out.println("<td>idPedido</td>");
            out.println("<td>Nombre</td>");
            out.println("<td>Fecha Actual</td>");
            
            
            out.println("<form method=\"post\" action=\"SrvTramitarPedido\">");
            out.println("<td><input type=\"text\" name=\"idProducto\"></td>");
            out.println("<td><input type=\"text\" name=\"nombre\"></td>");
            out.println("<td><input type=\"text\" name=\"fecha_alta\"></td>");
            out.println("<td><input type=\"submit\" value=\"Tramitar Pedido\"></td>");
            out.println("</form>");
            
            
            out.println("<form method=\"post\" action=\"SrvComprar\">");
            out.println("<td><input type=\"submit\" value=\"Atrás\"></td>");
            out.println("</form>");
                        
            int idProducto = Integer.parseInt(request.getParameter("idProducto"));
            String nombre= request.getParameter("nombre");
            String fecha_alta = request.getParameter("fecha_alta");
            
            
            
         
            
            ResultSet res;
            
            
            
            
            
            pedido.AgregarMDB(idProducto,nombre, fecha_alta,cest);
            
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
