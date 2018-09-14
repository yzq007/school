package cn.zptc.register;

import java.io.File;
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

import org.apache.tomcat.util.digester.RuleSet;

import com.sun.crypto.provider.RSACipher;

import cn.zptc.entity.Imagecopy;

/**
 * Servlet implementation class ownerServlet
 */
@WebServlet("/ownerServlet")
public class ownerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name"),
			   gender=request.getParameter("gender"),
			   id=request.getParameter("id"),
			   tell=request.getParameter("tell"),
			   address=request.getParameter("address"),
			   picture="http://localhost:8080/Face-AI/ownerimage/"+id+".png",
			   remark=request.getParameter("remark");
		if (gender.equals("a")) {
			gender="男";
		}else {
			gender="女";
		}
		System.out.println(name+","+gender+","+id+","+tell+","+address+","+picture+","+remark);
		if(name.equals("")||id.equals("")||address.equals("")||tell.equals("")) {
			JOptionPane.showMessageDialog(null, "业主名字，业主身份证号，业主联系方式，业主地址均不可为空！");
		}else{
			try {
				System.out.println("1");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("2");
				Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
				System.out.println("3");
				Statement st = con.createStatement();
				String sql="select * from owner where owner_id='"+id+"'";
				ResultSet rs=st.executeQuery(sql);
				boolean bol=true;
				while (rs.next()) {
					bol=false;
					JOptionPane.showMessageDialog(null,"该用户已存在！");
					break;
					
				}
				System.out.println(bol);
				if (bol) {
					 String str1 = "D:\\download\\"+id+".png";
					 String str2=request.getSession().getServletContext().getRealPath("/")+"ownerimage/"+id+".png";
					System.out.println(str2);
					Imagecopy imagecopy =new Imagecopy();
					imagecopy.copyFile3(str1, str2);	
					System.out.println(str2);	
					sql="insert into Owner(owner_name,owner_gender,owner_id,owner_tell,owner_address,owner_picture,owner_remark) values('"+name+"','"+gender+"','"+id+"','"+tell+"','"+address+"','"+picture+"','"+remark+"')";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"用户注册成功！");
				}
				
				System.out.println(sql);
				if (st!=null) {
					st.close();
					st=null;
				}
				if(con!=null) {
					con.close();
					con=null;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		response.sendRedirect("face/calendar.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
