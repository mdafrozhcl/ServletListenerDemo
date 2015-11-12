import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchData extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			ServletContext context=getServletContext();
			Connection con = (Connection)context.getAttribute("mycon");
			PreparedStatement stmt= con.prepareStatement("Select * from books");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				out.print("Bno: "+rs.getInt(1)+" Book Name: "+rs.getString(2)+" Book Price:"+rs.getDouble(3)+"<br>");
			}
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
