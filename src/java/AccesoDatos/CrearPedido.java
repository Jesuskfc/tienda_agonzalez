/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class CrearPedido extends Conexion{
    
     public CrearPedido(){
      ConectarMDB();
    }

    public void AgregarCesta(int idCesta) throws Exception{

        try{
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("INSERT INTO cesta VALUES ('"+idCesta +"')");
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
        }
       
    }
    
    
    
    
    
}
