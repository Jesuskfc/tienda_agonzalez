/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.*;
import AccesoDatos.*;
import java.util.Calendar;
import java.util.logging.*;//para trabajar con la bd
import javax.annotation.PostConstruct;


/**
 *
 * @author jesuskfc
 */
public class ActualizarPedido extends Conexion {

    private ResultSet result;//devuelve un grupo de datos

   /* public ActualizarProducto() {
       
    }*/
    
    public ActualizarPedido(){
      ConectarMDB();
    }
        
    

    public void ActualizarMDB(int idPedido,String nombre, String fecha_pedido, String descripcion) throws Exception{
        try{
            
            Calendar c = Calendar.getInstance();
            
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH));
            String annio = Integer.toString(c.get(Calendar.YEAR));
            
            
            String fecha_entrega = annio+"-"+mes+"-"+dia;
            
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("UPDATE pedidos SET nombre= '" + nombre + "', entregado='1', fecha_pedido='" + fecha_pedido + "' ,fecha_entrega ='" + fecha_entrega + "', descripcion ='" + descripcion + "' WHERE idPedido='"+idPedido+"'" );//consulta a la bd
            System.out.println("Este es el resultado: " + result);  
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
           // return null;
        }   
    }
    
}
