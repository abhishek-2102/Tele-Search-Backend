package telesearch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teleSave")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("MySQL Driver");
			Connection con = DriverManager.getConnection("*yoursource*", "username","password" );
			String[] numberArray=request.getParameterValues("list[]");
			for(int i=0;i<numberArray.length;i++){
				Statement save=con.createStatement();
				String query="insert into tele_save values("+numberArray[i]+")";
				save.executeUpdate(query);
				save.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
