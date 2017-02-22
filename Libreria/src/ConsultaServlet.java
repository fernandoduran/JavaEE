

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/consulta")
public class ConsultaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ConsultaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("autor");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost/TiendaLibros";
		String usuario = "root";
		String password = "";
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Catálogo por autor</title>");
		out.println("<meta charset='utf-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Catálogo por autor</h1>");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, usuario, password);
			stmt = conn.createStatement();
			
			String sql = "select * from libros where autor = '"+nombre+"'";
			
			ResultSet resultados = stmt.executeQuery(sql);
			
			while(resultados.next()){
				
				out.println("<hr>");
				out.println("Titulo: " + resultados.getString("titulo") + "<br>");
				out.println("Autor: " + resultados.getString("autor") + "<br>");
				out.println("Precio: " + resultados.getFloat("precio") + "<br>");
				out.println("Cantidad: " + resultados.getInt("cantidad") + "<br>");
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			System.out.println("Error al conectar con la BD: ");
			e.printStackTrace();
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
