package kr.or.ddit.login.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;



/**
 * Servlet implementation class LoginController / loadonstartup -> 요청이 없어도 서버가 기동이 될때 init메서드 호출
 */
@WebServlet(urlPatterns = {"/login"}, loadOnStartup = 5)
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    /**
    * Method : doGet
    * 작성자 : PC-05
    * 변경이력 :
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException
    * Method 설명 : 로그인 화면 요청 처리 (foward)
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//webapp/jsp/login.jsp --> jsp/login.jsp
    	request.getRequestDispatcher("/login/login.jsp").forward(request, response);
    	
    }

	/**
	* Method : doPost
	* 작성자 : PC-05
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 로그인 요청 처리
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("login cotriller doPost()");
		//userId. passWord 파라미터 logger 출력 
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		logger.debug("userId : {}", userId);
		logger.debug("passWord : {}", pass);
		
		//db에서 조회해온 사용자 정보
		 //UserVo userVo = new UserVo();
		 IUserDao userDao = new UserDao();
		 User user = userDao.getUser(userId);
		 
		 
//		 userVo.setUserNm("정브라우니");
//		 userVo.setUserId("brown");
//		 userVo.setPass("brown1234");
		 
		 //사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 동일할 경우 --> webapp/main.jsp
		 //사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 다를 경우 --> webapp/login/login.jsp
		 if(user.checkLoginValidate(userId, pass)){
			 
		//	 if(userId.equals(userVo.getUserId())&&pass.equals(userVo.getPass())) {
		
			 
			 //세션 객체를 얻는 방법 
			 HttpSession session = request.getSession();
			 logger.debug("session.getId() : {} " ,session.getId());
			 
			 session.setAttribute("S_USERVO", user);
			 
			 request.getRequestDispatcher("/main.jsp").forward(request, response);
		 }
		 else { 
			 //forward의 경우 request, response객체를 공유
			 //request method도 같이 공유
			 //doPost
			 //request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			 //request.setAttribute("userId", userId );
			 doGet(request, response);
		 }
	}

}
