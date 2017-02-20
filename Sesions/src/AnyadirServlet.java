

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/anyadir")
public class AnyadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AnyadirServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Establecemos el tipo MIME de la respuesta.
		response.setContentType("text/html");
		
		// Creamos un objeto de tipo PrintWriter para escribir el HTML que se
		// devolverá al usuario.
		PrintWriter out = response.getWriter();
		
		// Leemos los campos del formulario.
		String atributo = request.getParameter("atributo");
		String valor = request.getParameter("valor");
		
		// Añadimos el par atributo/valor a la sesión del usuario.
		HttpSession sesion = request.getSession();
		sesion.setAttribute(atributo, valor);
		
		// Creamos una enumeración para guardar todas las claves de la sesión.
		Enumeration<String> nombresDeAtributos = sesion.getAttributeNames();
		
		// Vamos enviando el HTML que se mostrará en el navegador como
		// respuesta.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Sesiones</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Sesión de usuario</h1>");
		out.println("El contenido de la sesión de usuario es:<br><br>");
		
		// Recorremos la enumeración y vamos mostrando en pantalla los pares
		// atributo/valor.
		
		while (nombresDeAtributos.hasMoreElements()) {
			
			atributo = nombresDeAtributos.nextElement();
			
			out.println("Atributo: " + atributo + "<br>");
			out.println("Valor: " + sesion.getAttribute(atributo) + "<br>");
			out.println("<hr>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
