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

public class AccesoPedido extends Conexion{
    private ResultSet result;//devuelve un grupo de datos
    

    public AccesoPedido(){
      ConectarMDB();     
    }
    
  
    public ResultSet ListarMDB() throws Exception{
            //ConectarMDB();
            try{
                getStmt();//estado de la comunicacion
                result= stmt.executeQuery("SELECT * FROM pedidos");//consulta a la bd
                return result;//devuelve los resultados
            }catch (SQLException ex){
                System.err.println("Excepcion SQL: " +ex.getMessage());
                //Desconectar();
                return null;
            }
              
    }
    
    
}