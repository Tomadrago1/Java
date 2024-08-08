package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Usuario;
import logic.Login;

/**
 * Servlet implementation class signin
 */
@WebServlet({ "/signin", "/Signin", "/SignIn", "/signIn", "/SIGNIN" })
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
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
		Usuario usu = new Usuario();
		Login ctrl = new Login();
		
		String user= request.getParameter("usuario");
		String password= request.getParameter("password");
		usu.setNombreUsuario(user);
		usu.setPassword(password);
		usu=ctrl.validate(usu);
	    if (usu == null || usu.getEstado()==false) {
	        // Caso donde la validación devuelve null
	        request.setAttribute("errorMessage", "El usuario no existe o las credenciales son incorrectas.");
	        request.getRequestDispatcher("WEB-INF/errorLogin.jsp").forward(request, response);
	    } else {
	        // Validación exitosa
	        LinkedList<Usuario> usuarios = ctrl.getAll();
	        request.getSession().setAttribute("usuario", usu);
	        request.setAttribute("listaUsuarios", usuarios);
	        request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
	    }
		}
	}
