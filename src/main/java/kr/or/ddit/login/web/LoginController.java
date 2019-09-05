package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;



/**
 * Servlet implementation class LoginController / loadonstartup -> 요청이 없어도 서버가 기동이 될때 init메서드 호출
 */
@WebServlet(urlPatterns = {"/login"}, loadOnStartup = 5)
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private IUserService userService;
	
	//controller가 실행될때 init 메서드 실행
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

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
		//웹브라우저가 보낸 cookie 확인 

		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				logger.debug("cooke name : {}, cookie value : {}", cookie.getName(),cookie.getValue());
			}
		}
		//응답을 생성할 때 웹브라우저에게 쿠키를 저장할 것을 지시
		Cookie cookie = new Cookie("serverGen", "serverValue");
		cookie.setMaxAge(60*60*24*7);		//7일의 유효기간을 갖는 쿠키
		response.addCookie(cookie);

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
		
		Map<String, String[]> requestMap = request.getParameterMap();
		//setParameter 메소드가 존재하지 않으니까 map 객체에 직접 넣으면 되지 않을까 ? 
		//requestMap.put("UNT_CD", new String[] {"DDIT"});
		
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		manageUserIdCookie(request, response, userId);

		logger.debug("userId : {}", userId);
		logger.debug("passWord : {}", pass);

		//db에서 조회해온 사용자 정보
		//UserVo userVo = new UserVo();
		User user = userService.getUser(userId);

		//db에 존재하지 않는 사용자 체크 -->로그인 화면으로 이동
		if(user ==null) {
			doGet(request, response);

			//		 userVo.setUserNm("정브라우니");
			//		 userVo.setUserId("brown");
			//		 userVo.setPass("brown1234");

			//사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 동일할 경우 --> webapp/main.jsp
			//사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 다를 경우 --> webapp/login/login.jsp
		} else if(user.checkLoginValidate(userId, pass)){

			//	 if(userId.equals(userVo.getUserId())&&pass.equals(userVo.getPass())) {


			//세션 객체를 얻는 방법 
			HttpSession session = request.getSession();
			logger.debug("session.getId() : {} " ,session.getId());

			session.setAttribute("S_USERVO", user);
			request.setAttribute("elTest", "elTestValue");

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

	private void manageUserIdCookie(HttpServletRequest request, HttpServletResponse response, String userId) {
		//rememberMe 파라미터가 존재할 경우 userId를 cookie로 생성 
		String rememberMe = request.getParameter("rememberMe");
		Cookie cookie = new Cookie("userId", userId);
		if(rememberMe !=null) {
			cookie.setMaxAge(60*60*24*30); //30일로 유효기간 설정
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
	}

}
