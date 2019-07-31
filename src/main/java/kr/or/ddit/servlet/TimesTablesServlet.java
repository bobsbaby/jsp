package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimesTablesServlet extends HelloServlet{
	//logger 선언 
	
	private static final Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("TimesTablesServlet doGet()");
//		logger.debug("TimesTablesServlet doGet()");
		
		
		String method = req.getMethod();
		//	if (logger.level >= trace)
		//method 인자를 추가함으로서 내부에서 method 오류 파악
		logger.trace("TimesTablesServlet doGet() {} ",  method);
		logger.debug("TimesTablesServlet doGet() {}{} ",  method, method+"test");
		logger.info("TimesTablesServlet doGet()");
		logger.warn("TimesTablesServlet doGet()");
		logger.error("TimesTablesServlet doGet()");
		
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();

		pw.write("<html>");
		pw.write("   <head>");
		pw.write("	 <title>TimeTableServlet</title>");
		pw.write(" <style> table {border-spacing : 5px;} td {border : 2px solid pink; height : 50px; width : 80px; text-align : center;} </style>");
		pw.write("   </head>");
		pw.write("    <body>");
		pw.write("    <table>");
		for(int i = 1; i <=9; i++) {
		pw.write("<tr>");
			for(int j = 2; j <= 9; j++) {
				pw.write("<td>" + j + " * " + i + "=" + i*j + "</td>" );
			}
			pw.write("</tr>");
		}
		pw.write("</table>");
		pw.write("    </body>");
		pw.write("   </html>");
	}
}
