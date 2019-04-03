package com.Selvlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StuDao;
import com.dao.UserDao;
import com.dao.impl.StuDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.domain.Student;

/**
 * Servlet implementation class LoginSelvlet
 */
public class LoginSelvlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(password.length() == 0) {
			response.getWriter().write("请输入密码");
			
			
			
		}
			
		else {
			UserDao dao = new UserDaoImpl();
			boolean isSuccess = dao.login(username, password);

			if(!isSuccess) {
				response.getWriter().write("用户名或者密码错误");
			}
			else {
				//1查询出信息
				List<Student>list = new StuDaoImpl().findAll();
				request.getSession().setAttribute("list", list);
				
				
				//2.跳转
				response.sendRedirect("stu_list.jsp");
			}
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	}

}
