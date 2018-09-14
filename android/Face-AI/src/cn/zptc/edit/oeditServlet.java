package cn.zptc.edit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class oeditServlet
 */
@WebServlet("/oeditServlet")
public class oeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name"),
			   id=request.getParameter("id"),
			   tell=request.getParameter("tell"),
			   address=request.getParameter("address");
		try {
			System.out.println("3");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			Statement st = con.createStatement();
			String sql="update owner set owner_name='"+name+"', owner_tell='"+tell+"', owner_address='"+address+"' where owner_id='"+id+"'";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"用户修改成功！");
		}catch (Exception e) {
			// TODO: handle exception
		}
//		response.sendRedirect("face/table-list-img");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
