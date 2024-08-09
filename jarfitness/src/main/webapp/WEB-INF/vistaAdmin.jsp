<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/vistaAdminStyles.css">
    <title>Vista Administrador</title>
</head>
<body>
    <div class="admin-container">
        <h1>Panel de Administración</h1>
        <form action="verUsuarios" method="post">
            <input type="submit" class="admin-btn" value="Ver Usuarios">
        </form>
        <form action="verProfesionales" method="post">
            <input type="submit" class="admin-btn" value="Ver Profesionales">
        </form>
        <form action="verRecetas" method="post">
            <input type="submit" class="admin-btn" value="Ver Recetas">
        </form>
        <form action="verRutinas" method="post">
            <input type="submit" class="admin-btn" value="Ver Rutinas">
        </form>
    </div>
</body>
</html>
