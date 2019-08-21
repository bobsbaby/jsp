package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/userPagingList")
public class UserPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page, pagesize 파라미터 받기 --> 파라미터는 문자 형식으로 
		String pageStr = request.getParameter("page");
		String pagesizeStr = request.getParameter("pagesize");
		Page page = new Page(Integer.parseInt(pageStr), Integer.parseInt(pagesizeStr));
		
		//userservice 객체를 이용하여 getUserPagingList를 호출 
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>) resultMap.get("userList");
		//반환된 사용자 리스트를 request객체에 속성으로 저장
		int paginationSize = (Integer)resultMap.get("pagenationSize");
		request.setAttribute("userList", userList);
		request.setAttribute("pagenationSize", paginationSize);
		
		//조회된 사용자 리스트 정보를 html로 만들어줄 jsp로 요청 위임
		//webapp/useruserPagingList.jsp
//				 userList.jsp 복사 
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
		
		
	}
}
