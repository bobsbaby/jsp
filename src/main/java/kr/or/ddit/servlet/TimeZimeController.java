package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/timeZone")
public class TimeZimeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] timeZoneList = TimeZone.getAvailableIDs();
		req.setAttribute("timeZoneList", timeZoneList);
		//날짜 설정
		req.setAttribute("dt", new Date());
		req.getRequestDispatcher("/jst1/timeZone.jsp").forward(req, resp);
	}
	
}
