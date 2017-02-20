

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/invalidar")
public class InvalidarSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidarSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		 HttpSession sesion= request.getSession();
		 sesion.invalidate();
		 response.setContentType("text/html");
		 PrintWriter out= response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Sesiones</title>");
		 out.println("<meta charset='utf-8'>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1>Sesiones</h1>");
		 out.println("<p>Se ha cerrado la sesion del usuario.</p>");

		 out.println("</body>");
		 out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
