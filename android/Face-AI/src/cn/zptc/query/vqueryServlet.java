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

import cn.zptc.entity.Visitor;



/**
 * Servlet implementation class vqueryServlet
 */
@WebServlet("/vqueryServlet")
public class vqueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		String cha=request.getParameter("cha");
		String sql = null;
		System.out.println(category);
		int i=0;
		if(category.equals("option1")) {
			if(cha.equals(""))
				sql="select * from visitor";
			else
			sql="select * from visitor where id='"+cha+"' or visitor_name='"+cha+"' or owner_id='"+cha+"' or visitor_relation='"+cha+"' or visitor_tell='"+cha+"' or visitor_start='"+cha+"' or visitor_stop='"+cha+"' or visitor_picture='"+cha+"' or visitor_remark='"+cha+"'";
		}else if(category.equals("option2")) {
			sql="select * from visitor where visitor_name='"+cha+"'";
		}else if(category.equals("option3")) {
			sql="select * from visitor where owner_id='"+cha+"'";
		}else if(category.equals("option4")){
			sql="select * from visitor where visitor_tell='"+cha+"'";
		}else {
			sql="select * from visitor where visitor_start='"+cha+"'";
		}
		System.out.println(sql);
		try {
			System.out.println("3");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			ArrayList idlist=new ArrayList();
			ArrayList namelist=new ArrayList();
			ArrayList telllist=new ArrayList();
			ArrayList ownerlist=new ArrayList();
			ArrayList datalist=new ArrayList();
			while(rs.next()) {
				idlist.add(rs.getString("id"));
				namelist.add(rs.getString("visitor_name"));
				telllist.add(rs.getString("visitor_tell"));
				ownerlist.add(rs.getString("owner_id"));
				datalist.add(rs.getString("visitor_start"));
				i++;
			}
			rs.close();
			con.close();
			Visitor[] visitorlist=new Visitor[i];
			for(i=0;i<namelist.size();i++) {

				visitorlist[i]=new Visitor();
				visitorlist[i].setId(idlist.get(i).toString());
				visitorlist[i].setName(namelist.get(i).toString());
				visitorlist[i].setTell(telllist.get(i).toString());
				visitorlist[i].setOwnerid(ownerlist.get(i).toString());
				visitorlist[i].setStart(datalist.get(i).toString());
				System.out.println(visitorlist[i].getName());
//			
			}
			request.getSession().setAttribute("visitor",visitorlist);
			request.getSession().setAttribute("idlist",idlist);
			request.getSession().setAttribute("namelist", namelist);
			request.getSession().setAttribute("telllist", telllist);
			request.getSession().setAttribute("ownerlist",ownerlist);
			request.getSession().setAttribute("datalist", datalist);
	
		} catch (Exception e) {
			// TODO: handle exception
		}			
		response.sendRedirect("face/table-list-visitor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
