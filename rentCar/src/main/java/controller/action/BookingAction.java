package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String place = request.getParameter("place");
		String carName = request.getParameter("carName");
		String startDay = request.getParameter("startDay");
		String startHour = request.getParameter("startHour");
		String endDay = request.getParameter("endDay");
		String endHour = request.getParameter("endHour");
		int carCode =Integer.parseInt(request.getParameter("carCode"));
				
		System.out.println(name+place+carName);
		System.out.println(startDay+startHour);
		System.out.println(endDay+endHour);
		System.out.println(carCode+1);
		
	}

}
