<%@page import="entities.Usuario"%>
<%@page import="data.DaoUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Usuario</title>
</head>
<body>
<%
    DaoUsuario dao = new DaoUsuario();
    Usuario usuario = dao.getUserById(idUsuario);
%>
    <h1>Editar Usuario</h1>
    <form action="actualizarUsuario" method="post">
        <input type="hidden" name="id" value="<%=usuario.getIdUsuario()%>">
        Nombre: <input type="text" name="nombre" value="<%=usuario.getNombre()%>"><br>
        Apellido: <input type="text" name="apellido" value="<%=usuario.getApellido()%>"><br>
        Email: <input type="text" name="email" value="<%=usuario.getEmail()%>"><br>
        Nombre de Usuario: <input type="text" name="nombreUsuario" value="<%=usuario.getNombreUsuario()%>"><br>
        <input type="submit" value="Actualizar">
    </form>
</body>
</html>