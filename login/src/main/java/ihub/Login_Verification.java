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

public class Login_Verification extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		
		Connection con = null;
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		PreparedStatement ps = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
			String sid = req.getParameter("id");
			int id = Integer.parseInt(sid);
			String pass = req.getParameter("pass");
			String qry = "select * from login where id=? and pass=?";
			ps = con.prepareStatement(qry);
			
			ps.setInt(1,id);
			ps.setString(2, pass);
			
			result = ps.executeUpdate();
			
			if(result==1) {
				RequestDispatcher rd = req.getRequestDispatcher("userpage.html");
				rd.forward(req, res);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("relogin.html");
				rd.include(req, res);
			}
			
		}catch(Exception e) {
			pw.println(e);
		}

	}

}






















