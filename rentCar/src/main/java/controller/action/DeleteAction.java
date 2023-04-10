package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.controller.UserDao;

public class DeleteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("userCode");

		int userCode = 1001;
		if (code != null) {
			userCode = Integer.parseInt(code);
			
			UserDao userDao = UserDao.getInstance();
			userDao.removeUserByUserCode(userCode);
			
			
			request.getSession().removeAttribute("log");
			response.sendRedirect("/");
		}
		else {
			response.sendRedirect("mypage");
		}
		
		
	}

}
