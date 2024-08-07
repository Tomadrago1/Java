<%@page import="java.util.LinkedList"%>
<%@page import="entities.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link rel="stylesheet" href="style/UserManagementstyles.css">
	
	<%
		Usuario u = (Usuario)session.getAttribute("usuario");
		LinkedList<Usuario> lu = (LinkedList<Usuario>) request.getAttribute("listaUsuarios");
	%>
	
</head>
<body>
	<div class="container">
		<h1>Personas</h1>
		<div>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Email</th>
						<th>Nombre de Usuario</th>         
						<th>Acción</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>
				<% for (Usuario usu : lu) { %>
					<tr>
						<td><%=usu.getIdUsuario()%></td>
						<td><%=usu.getNombre()%></td>
						<td><%=usu.getApellido()%></td>
						<td><%=usu.getEmail()%></td>
						<td><%=usu.getNombreUsuario()%></td> 
						<td><a href="editarUsuario?<%=usu%>" class="action-btn edit-btn">Editar</a></td>
						<td><a href="eliminarUsuario?id=<%=usu.getIdUsuario()%>" class="action-btn delete-btn">Borrar</a></td>
					</tr>
				<% } %>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>