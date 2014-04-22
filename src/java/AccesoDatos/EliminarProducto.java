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

public class EliminarProducto extends Conexion{
    /*public EliminarProducto() {
        
    }*/
    public EliminarProducto(){
      ConectarMDB();
    }
    public void EliminarMDB(int idProducto) throws Exception{
        try{
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("DELETE FROM productos WHERE idProducto='"+idProducto+"'");
            System.out.println("Este es el resultado: " +idProducto);   
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
           // return null;
        }   
    }
    
    
    
}
