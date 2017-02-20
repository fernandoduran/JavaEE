

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * La siguiente linea permite al usuario ver la salida que genera esta clase desde el navegador. 
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HolaMundoServlet() {
        super();
       
    }

	/**
	 * Se ejecuta cuando recibe la petición GET
	 * 
	 * response es un objeto para manejar el contenido que se envía
	 * 
	 * PrintWriter ejecutará en el navegador su contenido como una web
	 * 
	 * El objeto out tiene el método println 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola Mundo Servlet</title>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola Mundo Servlet</h1>");
		out.println("<p>Hola Mundo Servlet</p>");
		out.println("</body>");
		out.println("</html>");
	}

	//Se ejecuta cuando recibe la petición POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
