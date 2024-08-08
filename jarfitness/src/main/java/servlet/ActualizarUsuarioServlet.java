package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DaoUsuario;
import entities.Usuario;
import logic.Login;

@WebServlet("/actualizarUsuario")
public class ActualizarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String nombreUsuario = request.getParameter("nombreUsuario");
        int tipo_usuario = Integer.parseInt(request.getParameter("tipoUsuario"));

        DaoUsuario daoUsuario = new DaoUsuario();
        Boolean success= daoUsuario.modificarUser(id,nombre, apellido, email, nombreUsuario,tipo_usuario);

        if (success) {
        	Login ctrl = new Login();
        	LinkedList<Usuario> usuarios = ctrl.getAll();
        	/*Usuario usuario = daoUsuario.getUserById(id);
        	request.getSession().setAttribute("usuario", usuario);*/
    		request.setAttribute("listaUsuarios", usuarios);
        	request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
        } else {
            response.getWriter().append("Error al actualizar el usuario.");
        }
    }
}
