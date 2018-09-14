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

import cn.zptc.entity.Imagecopy;

/**
 * Servlet implementation class visitorServlet
 */
@WebServlet("/visitorServlet")
public class visitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name"),
			   ownerid=request.getParameter("ownerid"),
			   relation=request.getParameter("relation"),
			   tell=request.getParameter("tell"),
			   start=request.getParameter("start"),
			   stop=request.getParameter("stop"),
					   picture="http://localhost:8080/Face-AI/ownerimage/"+ownerid+name+".png",
			   remark=request.getParameter("remark");
		if(name.equals("")||ownerid.equals("")||start.equals("")||tell.equals("")||relation.equals("")||stop.equals("")) {
			JOptionPane.showMessageDialog(null, "游客名字，访问业主身份证号，与业主关系，游客联系方式，游客访问开始和结束时间均不可为空！");
		}else {
			try {
	
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
				
				Statement st = con.createStatement();
				String sql="select * from owner where owner_id='"+ownerid+"'";
				ResultSet rs=st.executeQuery(sql);
				boolean bol=true;
				String str1 = "D:\\download\\"+ownerid+name+".png";
				while (rs.next()) {
					bol=false;
					
					String str2=request.getSession().getServletContext().getRealPath("/")+"visitorimage/"+ownerid+name+".png";
					System.out.println(str2);
					Imagecopy imagecopy =new Imagecopy();
					imagecopy.copyFile3(str1, str2);	
					System.out.println(str2);	
					sql="insert into visitor(visitor_name,owner_id,visitor_relation,visitor_tell,visitor_start,visitor_stop,visitor_picture,visitor_remark) values('"+name+"','"+ownerid+"','"+relation+"','"+tell+"','"+start+"','"+stop+"','"+picture+"','"+remark+"')";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "游客注册成功！");
					System.out.println(sql);
					break;
				}
				if(bol) {
					File file = new File(str1);
					if (file.exists()) {
					    file.delete();
					}
					JOptionPane.showMessageDialog(null,"该游客访问的用户不存在！");
				}
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
		
		response.sendRedirect("face/calendar-visitor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
