<%-- 
    Document   : index
    Created on : 15-abr-2014, 11:41:26
    Author     : jesuskfc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Productos.CantidadProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="fondo.css" rel="stylesheet" type="text/css">
        <title>Home</title>
    </head>
    <body>
        
        <form method="post" action="SrvAdmin">
        <table>
            <tr>
                <td>User</td>
                <td>Password</td>
            </tr>
            <tr>
               
                <td><input type="text" name="USUARIO"></td>
                <td><input type="password" name="PASSWORD"></td>
                <td><input type="submit" value="Acceder"></td>
                
            </tr>
        </table>
        </form>
        
        
        
        <br>
        <br>
        <form method="post" action="SrvComprar">
        <table>
            <tr>
                <td><input type="submit" value="Comprar"></td>
            </tr>
        </table>
        </form>    

    </body>
</html>
