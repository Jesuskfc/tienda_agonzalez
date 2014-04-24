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

public class AccesoProductos extends Conexion{
    private ResultSet result;//devuelve un grupo de datos
    

    public AccesoProductos(){
      ConectarMDB();     
    }
    
  
    public ResultSet ListarMDB(int familia) throws Exception{
            //ConectarMDB();
            try{
                getStmt();//estado de la comunicacion
                result= stmt.executeQuery("SELECT * FROM productos WHERE idFamilia='"+familia+"'");//consulta a la bd
                return result;//devuelve los resultados
            }catch (SQLException ex){
                System.err.println("Excepcion SQL: " +ex.getMessage());
                //Desconectar();
                return null;
            }
              
    }
    
    public ResultSet ListarPorPrecio(float preciomin, float preciomax){

     try{
            getStmt();//estado de la comunicacion
            result= stmt.executeQuery("SELECT * FROM productos WHERE precio BETWEEN "+preciomin+" AND "+preciomax);//consulta a la bd
            return result;//devuelve los resultados
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
            return null;
        }   
    }
    
     public ResultSet ListarPorPrecio(float preciomin, float preciomax,int familia){

     try{
            getStmt();//estado de la comunicacion
            result= stmt.executeQuery("SELECT * FROM productos WHERE (precio BETWEEN "+preciomin+" AND "+preciomax+") AND (idFamilia='"+familia+"')");//consulta a la bd
           // WHERE (USUARIO LIKE'" + user+"') AND (PASSWORD LIKE'"+pw+"')
            
            return result;//devuelve los resultados
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
            return null;
        }   
    }
}
