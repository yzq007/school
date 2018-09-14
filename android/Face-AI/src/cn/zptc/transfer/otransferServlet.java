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
import javax.swing.JOptionPane;

import cn.zptc.entity.Owner;

/**
 * Servlet implementation class otransferServlet
 */
@WebServlet("/otransferServlet")
public class otransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("2");
			Connection con = DriverManager.getConnection("jdbc:mysql://106.15.227.196:3306/ai","root","root");
			System.out.println("3");
			Statement st = con.createStatement();
			String sql="select * from owner ";
			ResultSet rs=st.executeQuery(sql);
			int i=0;
			ArrayList namelist=new ArrayList();
//			ArrayList genderlist=new ArrayList();
			ArrayList idlist=new ArrayList();
			ArrayList telllist=new ArrayList();
			ArrayList addresslist=new ArrayList();
//			ArrayList picturelist=new ArrayList();
//			ArrayList remarklist=new ArrayList();
			while (rs.next()) {
				namelist.add(rs.getString("owner_name"));
//				genderlist.add(rs.getString("owner_gender"));
				idlist.add(rs.getString("owner_id"));
				telllist.add(rs.getString("owner_tell"));
				addresslist.add(rs.getString("owner_address"));
//				picturelist.add(rs.getString("owner_picture"));
//				remarklist.add(rs.getString("owner_remark"));
				i++;				
			}
			Owner[] owners=new Owner[i];
			for(int j=0;j<i;j++) {
				owners[j]=new Owner();
				owners[j].setName(namelist.get(j).toString());
//				owners[j].setGender(genderlist.get(j).toString());
				owners[j].setId(idlist.get(j).toString());
				owners[j].setTell(telllist.get(j).toString());
				owners[j].setAddress(addresslist.get(j).toString());
//				owners[j].setPicture(picturelist.get(j).toString());
//				owners[j].setRemark(remarklist.get(j).toString());
			}
			request.getSession().setAttribute("owners", owners);
			request.getSession().setAttribute("namelist", namelist);
			request.getSession().setAttribute("idlist", idlist);
			request.getSession().setAttribute("telllist", telllist);
			request.getSession().setAttribute("addresslist", addresslist);
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
		response.sendRedirect("face/table-list-img.jsp");
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
