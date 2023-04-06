package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import user.User;
import user.controller.UserDao;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDao userDao = UserDao.getInstance();
		User user = userDao.getUserById(id);
		
		if(user != null && password.equals(user.getPassword())){
			session.setAttribute("log", user);
			
			response.sendRedirect("/");
		}
		else{
			response.sendRedirect("logIn.jsp");
		}
		
	}

}
