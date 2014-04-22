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

public class RegistrarProducto extends Conexion{

    public RegistrarProducto(){
      ConectarMDB();
    }

    public void AgregarMDB(int idProducto, int idFamilia, String nombre, String descripcion, float precio, int stock, String fecha_alta, String imagen ) throws Exception{

        try{
            getStmt();//estado de la comunicacion
            stmt.executeUpdate("INSERT INTO productos VALUES ('"+idProducto +"','"+idFamilia+"','"+nombre+"','"+descripcion+"','"+precio+"','"+stock+"','"+fecha_alta+"','"+imagen+"')" );//consulta a la bd
        }catch (SQLException ex){
            System.err.println("Excepcion SQL: " +ex.getMessage());
        }
       
    }
}
