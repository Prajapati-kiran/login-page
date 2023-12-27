package ihub;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet  {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		Connection con = null;
		PrintWriter pw = res.getWriter();
		PreparedStatement ps = null;
		int result;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			String name = req.getParameter("name");
			String sage = req.getParameter("age");
			int age = Integer.parseInt(sage);
			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			String pass = req.getParameter("pass");
			
			String qry = "insert into login values (?,?,?,?)";
			
			ps = con.prepareStatement(qry);
			
			ps.setString(1,name);
			ps.setInt(2,age);
			ps.setInt(3,id);
			ps.setString(4,pass);
			
			ps.executeUpdate();
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, res);
			
		}catch(Exception e) {
			pw.println(e);
			
		}
	}
}













