package com.ispan.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ispan.bean.Member;
import com.ispan.dao.MemberDao;
import com.ispan.util.CreateConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchMember")
public class SearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> searchList = new HashMap<>();
		searchList.put("mem_id",request.getParameter("id"));
		searchList.put("account",request.getParameter("account"));
		searchList.put("passwords",request.getParameter("password"));
		searchList.put("email",request.getParameter("email"));
		searchList.put("nickname",request.getParameter("nickName"));
		searchList.put("mem_name",request.getParameter("memName"));
		searchList.put("birthday",request.getParameter("birthday"));
		searchList.put("phone",request.getParameter("phone"));
		searchList.put("addres",request.getParameter("address"));
		searchList.put("consumption",request.getParameter("consumption"));
		searchList.put("regist_date",request.getParameter("registDate"));
		searchList.put("last_login_time",request.getParameter("lastLogin"));
		searchList.put("roles",request.getParameter("role"));
		searchList.put("levels",request.getParameter("level"));

		List<Member> members = new ArrayList<Member>();
		
		try (CreateConnection createConnection = new CreateConnection()) {
			MemberDao memberDao = new MemberDao(createConnection);
			members = memberDao.selectMembers(searchList);
		}
		request.setAttribute("members", members);
		request.getRequestDispatcher("/JSP/MemberSheet.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}