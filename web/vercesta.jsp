<%-- 
    Document   : vercesta
    Created on : 22-abr-2014, 15:53:21
    Author     : jesuskfc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Servlet.SrvMostrarSesion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>ASDGIJ</h1>
            

        <% SrvMostrarSesion cesta = new SrvMostrarSesion();
        
            String cadena = cesta.getCadena();
        %>
        
        <%=cadena%>

    </body>
</html>
