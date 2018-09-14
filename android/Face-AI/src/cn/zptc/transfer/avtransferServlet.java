package cn.zptc.transfer;

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
 * Servlet implementation class avtransferServlet
 */
@WebServlet("/avtransferServlet")
public class avtransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("3");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			Statement st = con.createStatement();
			String sql="select * from applyvisitor";
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			ArrayList idlist=new ArrayList();
			ArrayList namelist=new ArrayList();
			ArrayList owneridlist=new ArrayList();
			ArrayList relationlist=new ArrayList();
			ArrayList telllist=new ArrayList();
			ArrayList startlist=new ArrayList();
			while(rs.next()) {
				idlist.add(rs.getString("applyid"));
				namelist.add(rs.getString("applyvisitor_name"));
				owneridlist.add(rs.getString("applyowner_id"));
				relationlist.add(rs.getString("applyvisitor_relation"));
				telllist.add(rs.getString("applyvisitor_tell"));
				startlist.add(rs.getString("applyvisitor_start"));
				i++;
			}
			rs.close();
			con.close();
			Visitor[] visitorlist=new Visitor[i];
			for(i=0;i<namelist.size();i++) {

				visitorlist[i]=new Visitor();
				visitorlist[i].setId(idlist.get(i).toString());
				visitorlist[i].setName(namelist.get(i).toString());
				visitorlist[i].setOwnerid(owneridlist.get(i).toString());
				visitorlist[i].setRelation(relationlist.get(i).toString());
				visitorlist[i].setTell(telllist.get(i).toString());
				visitorlist[i].setStart(startlist.get(i).toString());
				System.out.println(visitorlist[i].getName());
//			
			}
			request.getSession().setAttribute("visitor",visitorlist);
			request.getSession().setAttribute("idlist",idlist);
			request.getSession().setAttribute("relationlist",relationlist);
			request.getSession().setAttribute("namelist", namelist);
			request.getSession().setAttribute("telllist", telllist);
			request.getSession().setAttribute("ownerlist",owneridlist);
			request.getSession().setAttribute("datalist", startlist);
	
		} catch (Exception e) {
			// TODO: handle exception
		}			
		response.sendRedirect("face/form.jsp");
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
