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

/**
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    int id = Integer.parseInt(request.getParameter("id"));
		    DaoUsuario daoUsuario = new DaoUsuario();
		    
		    boolean success = daoUsuario.eliminarUsuario(id); // Llama al método para eliminar el usuario
		    if (success) {
		    	Login ctrl = new Login();
	        	LinkedList<Usuario> usuarios = ctrl.getAll();
	        	request.setAttribute("listaUsuarios", usuarios);
	        	request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
		    } else {
		        response.getWriter().append("Error al eliminar el usuario."); // Mensaje de error
		    }
		
	}

}
