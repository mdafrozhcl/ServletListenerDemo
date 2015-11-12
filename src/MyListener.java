import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.*;

public class MyListener implements ServletContextListener {

	public MyListener() {
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent event) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("mycon", con);
		} catch (Exception e) {
		}
	}

}
