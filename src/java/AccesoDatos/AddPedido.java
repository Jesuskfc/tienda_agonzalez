/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;
import java.sql.*;
import AccesoDatos.*;
import java.time.LocalDate;
import java.util.logging.*;//para trabajar con la bd
import javax.annotation.PostConstruct;


/**
 *
 * @author USUARIO
 */

public class AddPedido extends Conexion{

    public AddPedido(){
      ConectarMDB();
    }

    public void AgregarMDB(int idProducto,String nombre, String fecha_alta, String cesta) throws Exception{

        try{
            int entregado = 1;
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("INSERT INTO pedidos VALUES ('"+idProducto +"','"+nombre+"','"+entregado+"','"+fecha_alta+"','2000-12-12','"+cesta+"')" );//consulta a la bd
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
        }
       
    }
}
