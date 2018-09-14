package cn.zptc.login;

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

import cn.zptc.entity.Login;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String name=request.getParameter("user-name"),
			   pswd=request.getParameter("user-pswd");
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "’À∫≈≤ªƒ‹Œ™ø’£°");
			response.sendRedirect("face/login.jsp");
		}
		else if (pswd.equals("")) {
			JOptionPane.showMessageDialog(null, "√‹¬Î≤ªƒ‹Œ™ø’£°");
			response.sendRedirect("face/login.jsp");
		} 
		else{
			boolean bol=false;
			System.out.println("0");
			try {	
				System.out.println("1");
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("2");
					Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
					System.out.println("3");
					Statement st = con.createStatement();
					System.out.println("4");
					String sql="select * from Manager where manager_name = '"+name+"' and manager_pswd = '"+pswd+"' ";
					System.out.println(sql);
					ResultSet rs=st.executeQuery(sql);
					while(rs.next()) {
						Login login=new Login();
						login.setName(name);
						login.setPswd(pswd);					
						String id=rs.getString("manager_id");
						String destPath = "http://localhost:8080/Face-AI/managerimage/"+id+".png";
						System.out.println(destPath);
						sql="update manager set manager_photo='"+destPath+"' where manager_id='"+id+"'";
						System.out.println(sql);
						st.executeUpdate(sql);
						login.setPhoto(destPath);					
						request.getSession().setAttribute("login", login);
						bol=true;
						break;
					}
						
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (bol) {
				response.sendRedirect("face/index.jsp");
			}
			else {
				System.out.println("10");
				JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°");
				response.sendRedirect("face/login.jsp");
			}
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
