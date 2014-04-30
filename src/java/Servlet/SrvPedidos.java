/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import AccesoDatos.AccesoPedido;
import AccesoDatos.AccesoProductos;
import AccesoDatos.ActualizarPedido;
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
 * @author jesuskfc
 */
@WebServlet(name = "SrvPedidos", urlPatterns = {"/SrvPedidos"})
public class SrvPedidos extends HttpServlet {

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
        
        AccesoPedido pedido = new AccesoPedido();
        
        
        int idPedido, entregado;
        String nombre, descripcion;
        String fecha_pedido, fecha_entrega;
        
        
        
        idPedido=0;
        entregado=0;
        nombre="";
        descripcion="";
        fecha_pedido="";
        fecha_entrega="";
        
        
      
        
        try {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"fondo.css\" rel=\"stylesheet\" type=\"text/css\">");
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
            
            out.println("<form method=\"post\" action=\"SrvPedidos\">");
            out.println("<td><input type=\"submit\" value=\"Pedidos\"></td>");
            out.println("</form>");
            
            out.println("</tr>");
            out.println("</table>");
            
            out.println("<table>");
            
            out.println("<tr>");
            out.println("<td>idPedido</td>");
            out.println("<td>nombre</td>");
            out.println("<td>descripcion</td>");
            out.println("<td>Fecha Pedido</td>");
            out.println("<td>Fecha Entrega</td>");
            out.println("<td>entregado</td>");
            out.println("</tr>");
            
            
            ResultSet res = pedido.ListarMDB();
            
            
            while (res.next()){
                idPedido = res.getInt("idPedido");
                nombre = res.getString("nombre");
                descripcion = res.getString("descripcion");
                fecha_entrega = res.getString("fecha_entrega");
                fecha_pedido = res.getString("fecha_pedido");
                entregado = res.getInt("entregado");
                
                
                out.println("<form method=\"post\" action=\"SrvActualizarPedido\">");
                out.println("<tr>");
                out.println("<form method=\"post\" action=\"SrvRecogerDatos\">");
                out.println("<td>"+ idPedido +"</td>");
                out.println("<td><input type=\"hidden\" name=\"idPedido\""+ " value=" + idPedido +"></td>");
                out.println("<td>"+ nombre +"</td>");
                out.println("<td><input type=\"hidden\" name=\"nombre\""+ " value=" + nombre +"></td>");
                out.println("<td>"+ descripcion +"</td>");
                out.println("<td><input type=\"hidden\" name=\"descripcion\""+ " value='Pedido realizado'></td>");
                out.println("<td>"+ fecha_pedido+"</td>");
                out.println("<td><input type=\"hidden\" name=\"fecha_pedido\""+ " value=" + fecha_pedido+"></td>");
                
                
                if(fecha_entrega.equals("2000-12-12")){
                    out.println("<td> Sin determinar </td>");
                }else{
                    out.println("<td>"+ fecha_entrega+"</td>");
                }
                
                
                if(entregado== 0){
                    out.println("<td> No </td>");
                }else{
                    out.println("<td> Sí </td>");
                }

                out.println("<td><input type=\"submit\" value=\"Hacer Pedido\"></td>");
                out.println("</form>");
                out.println("</tr>");
                
                
                

            }
            
            
            
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
