package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		System.out.println("user.getPassword() : " + user.getPassword());
		if(user != null && password.equals(user.getPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("log", user);
			
			response.sendRedirect("/");
		}
		else{
			response.sendRedirect("logIn");
		}
		
	}

}
