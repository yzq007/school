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
 * Servlet implementation class aveditServlet
 */
@WebServlet("/aveditServlet")
public class aveditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println(id);
		try {
			System.out.println("3");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			Statement st = con.createStatement();
			String sql="select * from applyvisitor where applyid='"+id+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("applyvisitor_name"),
					   ownerid=rs.getString("applyowner_id"),
					   relation=rs.getString("applyvisitor_relation"),
					   tell=rs.getString("applyvisitor_tell"),
					   start=rs.getString("applyvisitor_start"),
					   stop=rs.getString("applyvisitor_stop"),
					   picture=rs.getString("applyvisitor_picture"),
					   remark=rs.getString("applyvisitor_remark");
				sql="insert into visitor(visitor_name,owner_id,visitor_relation,visitor_tell,visitor_start,visitor_stop,visitor_picture,visitor_remark) values('"+name+"','"+ownerid+"','"+relation+"','"+tell+"','"+start+"','"+stop+"','"+picture+"','"+remark+"')";
				st.executeUpdate(sql);
				sql="delete from applyvisitor where applyid='"+id+"'";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"³É¹¦£¡");
				break;
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
