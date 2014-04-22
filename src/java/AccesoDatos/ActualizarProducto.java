/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import java.sql.*;
import AccesoDatos.*;
import java.util.logging.*;//para trabajar con la bd
import javax.annotation.PostConstruct;


/**
 *
 * @author USUARIO
 */
public class ActualizarProducto extends Conexion {

    private ResultSet result;//devuelve un grupo de datos

   /* public ActualizarProducto() {
       
    }*/
    
    public ActualizarProducto(){
      ConectarMDB();
    }
        
    

    public void ActualizarMDB(int idProducto, int idFamilia, String nombre, String descripcion, float precio, int stock, String fecha_alta, String imagen) throws Exception{
        try{
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("UPDATE productos SET idFamilia= '" + idFamilia + "',nombre= '" + nombre + "', descripcion='" + descripcion + "', precio='" + precio + "' ,stock ='" + stock + "', fecha_alta ='" + fecha_alta + "', imagen ='" + imagen + "' WHERE idProducto='"+idProducto+"'" );//consulta a la bd
            System.out.println("Este es el resultado: " + result);  
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
           // return null;
        }   
    }
    
}

