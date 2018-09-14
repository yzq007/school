package cn.zptc.query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zptc.entity.Owner;


/**
 * Servlet implementation class oqueryServlet
 */
@WebServlet("/oqueryServlet")
public class oqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category"),
			   cha=request.getParameter("cha");	
		String sql=null;
		if(category.equals("option1")) {
			if(cha.equals(""))
				sql="select * from owner";
			else
			sql="select * from owner where owner_name='"+cha+"' or owner_gender='"+cha+"' or owner_id='"+cha+"' or owner_tell='"+cha+"' or owner_address='"+cha+"' or owner_picture='"+cha+"' or owner_remark='"+cha+"'";			
		}else if(category.equals("option2")) {
			sql="select * from owner where owner_name='"+cha+"'";
		}else if(category.equals("option3")) {
			sql="select * from owner where owner_address='"+cha+"'";
		}else if(category.equals("option4")){
			sql="select * from owner where owner_tell='"+cha+"'";
		}else {
			sql="select * from owner where owner_id='"+cha+"'";
		}
		try {
			System.out.println("3");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			ArrayList namelist=new ArrayList();
			ArrayList telllist=new ArrayList();
			ArrayList addresslist=new ArrayList();
			ArrayList idlist=new ArrayList();
			int i=0;
			while(rs.next()) {
				namelist.add(rs.getString("owner_name"));
				telllist.add(rs.getString("owner_tell"));
				addresslist.add(rs.getString("owner_address"));
				idlist.add(rs.getString("owner_id"));
				i++;
			}
			rs.close();
			con.close();
			Owner[] ownerlist=new Owner[i];
			for(i=0;i<namelist.size();i++) {

				ownerlist[i]=new Owner();
				ownerlist[i].setName(namelist.get(i).toString());
				ownerlist[i].setTell(telllist.get(i).toString());
				ownerlist[i].setAddress(addresslist.get(i).toString());
				ownerlist[i].setAddress(idlist.get(i).toString());
				System.out.println(ownerlist[i].getName());
//			
			}
			request.getSession().setAttribute("owners",ownerlist);
			request.getSession().setAttribute("namelist", namelist);
			request.getSession().setAttribute("telllist", telllist);
			request.getSession().setAttribute("idlist", idlist);
			request.getSession().setAttribute("addresslist",addresslist);
			
		}catch (Exception e) {
			// TODO: handle exception
		}			
		response.sendRedirect("face/table-list-img.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
