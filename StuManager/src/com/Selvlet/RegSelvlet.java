package com.Selvlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class RegSelvlet
 */
public class RegSelvlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
	
	
		
		if(!password1.equals(password2)) {
			response.getWriter().write("两次密码不一致，请重新填写");
		}
		
		else {
			//response.getWriter().write("注册成功");
			UserDao dao = new UserDaoImpl();
			boolean isSuccess = dao.Register(username, password1);
			if(isSuccess) {
				response.getWriter().write("注册成功");
			}
			else {
				response.getWriter().write("注册失败");
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
