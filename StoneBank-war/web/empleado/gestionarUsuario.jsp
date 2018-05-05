<%-- 
    Document   : gestionarUsuario
    Created on : 19-abr-2018, 13:32:18
    Author     : rafaelpernil
--%>

<%@page import="stonebank.entity.Tusuario"%>
<%@page import="stonebank.entity.Tusuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Tusuario usuario;
    int dni,telefono;
    String nombre, apellido, email, domicilio;
    
    usuario=(Tusuario) request.getAttribute("usuarioSeleccionado");
    
    if(usuario !=null){
        dni=usuario.getDniUsuario();
        nombre=usuario.getNombre();
        apellido=usuario.getApellidos();
        telefono=usuario.getTelefono();
        email=usuario.getEmail();
        domicilio=usuario.getDomicilio();
        //uno mas para contraseña preguntar como se haría a fran
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Usuario</title>
    </head>
    <body>
           <div align="center">
        <h1>Datos usuario</h1>
        <form action="${pageContext.request.contextPath}/ServletActualizarUsuarioEmpleado" method="post">
            <table>
                <tr>
                    <td>Nombre: </td>
                    <td><input type="text" name="nombre" value="<%=usuario.getNombre()%>"/></td>                    
                </tr>
                <tr>
                    <td>Apellido: </td>
                    <td><input type="text" name="apellido" value="<%=usuario.getApellidos()%>"/></td>                    
                </tr>
                <tr>
                    <td>DNI: </td>
                    <td><input type="text" name="dni" value="<%=usuario.getDniUsuario()%>" readonly="readonly"/></td>                    
                </tr>
                <tr>
                    <td>Contraseña: </td>
                    <td><input type="password" name="contrasena"  /></td>
                                        
                    <td>Nueva contraseña: </td>
                    <td><input type="password" name="nuevacontrasena" /></td>        
                </tr>
                <tr>
                    <td>Telefono: </td>
                    <td><input type="text" name="telefono" value="<%=usuario.getTelefono()%>"/></td>                    
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" value="<%=usuario.getEmail() %>"/></td>                    
                </tr>
                <tr>
                    <td>Domicilio: </td>
                    <td><input type="text" name="domicilio" value="<%= usuario.getDomicilio() %>"/></td>                    
                </tr>
            </table>
            <br>
            <input type="submit" value="Editar usuario" />
        </form>
                <form action="${pageContext.request.contextPath}/ServletEliminaUsuario" method="post">
                    <input type="hidden" name="dni" value="<%=usuario.getDniUsuario()%>"/>
                    <input type="submit" value="Eliminar usuario" />
                </form>        
                <p> Es necesario introducir la contraseña para aplicar cambios</p>
        </div>
    </body>
</html>
