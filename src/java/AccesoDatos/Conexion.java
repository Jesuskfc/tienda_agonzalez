/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

/**
 *
 * @author jesuskfc
 */

import java.sql.*;
import javax.ejb.Stateless;

/**
 *
 * @author USUARIO
 */

public class Conexion {
        
    //Conexion con MYSQL
    protected Connection con;
    protected Statement stmt;
    private String portNumberMDB="3306";
    private String databaseNameMDB="tienda_agonzalez";
    private String urlMDB="jdbc:mysql://localhost:3306/" + databaseNameMDB;//ojete
    
    private String userName="root";
    private String password="admin";
    
    //EL PUERTO DE MARIADB ES 3307
    
    
    private String errString;
    
    
    public Conexion(){
    
    }
    
    private String getConnectionUrlMDB(){
        return urlMDB;
    }
    
    
    public Connection ConectarMDB(){
        con=null;
        System.out.println("ConectaMDB");
        try{
            Class.forName("org.gjt.mm.mysql.Driver");//utiliza el driver de mysql para conectar con la bbdd
            con= DriverManager.getConnection(getConnectionUrlMDB(),userName,password);//establece la conexion
            stmt= con.createStatement();//
            System.out.println(errString);
        }catch(Exception e){
            errString= "Error de conexion";
            System.out.println(errString);
            return null;
        }
        
        return con;
    }
    
    public void Desconectar(){
        try{
            stmt.close();
            con.close();
        }catch (SQLException e){
            errString="Error de Desconexion";
        }
        
    }
    
    public Statement  getStmt(){
        return this.stmt;
    }

}

