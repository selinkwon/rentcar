package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserRequestDto;
import user.controller.UserDao;

public class UpdateAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("userCode");
		int userCode = 1001;
		if (code != null) {
			userCode = Integer.parseInt(code);
		}
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String joindate = request.getParameter("joindate");

		UserRequestDto userDto = new UserRequestDto(userCode, name, id, password, contact, joindate);
		UserDao userDao = UserDao.getInstance();
		userDao.updateUser(userDto);
		
		User log = userDao.getUserById(id);
		HttpSession session = request.getSession();
		session.setAttribute("log", log);

		response.sendRedirect("/");
	}

}
