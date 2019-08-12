package kr.or.ddit.dbConnection;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//loadOnStartup 속성 설정에 의해 dbcpservlet으로 최초 요청이 오지 않더라도 
//서버가 기동되는 과정에서 init 메소드 호출이 이루어진다. 
@WebServlet(urlPatterns = "/DbcpServlet", loadOnStartup = 1)
public class DbcpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DbcpServlet.class);
	//connection pool 생성 
	//servlet application(servletContext)얻어오기 
	//jsp : application/ session/ request / pageContext(page)
	// servlet : request.getSession() / request / N/A
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("DbcpServlet init()");
		ServletContext application = config.getServletContext();
		
		//database connection pool 객체를 생성
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("KSR");
		ds.setPassword("java");
		ds.setInitialSize(10); //초기 사이즈 설정
		
		application.setAttribute("ds", ds);
	}
	
	
	
	
	

}
