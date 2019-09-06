package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.User;

//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사용자가 로그인을 했는지 
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session =  httpRequest.getSession();
		User S_USERVO =  (User) session.getAttribute("S_USERVO");
		
		String uri = httpRequest.getRequestURI();
		
		//로그인을 체크하지 말아야 하는 url을 확인 
		//style.CSS
		if(uri.endsWith("/login") ||uri.endsWith(".css") ||uri.endsWith(".js") ) {
			chain.doFilter(request, response);
		} 
			
		//로그인하지 않은 상황
		else if(S_USERVO == null) {
			//로그인 화면으로 이동
//			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/login");
			//httpResponse.sendRedirect(httpResponse.getContextPath() + "/login");
		}
		
		else {
			//기존 요청 처리 진행 
			chain.doFilter(request, response);
		}
		
		//Yes -> chain.doFilter() 다음 filter 혹은 servlet 요청 전송 
		//no -> request, response 객체를 이용하여 login 화면으로 이동
		
		//로그인 요청 (login.jsp 로그인하기 버튼 눌렀을 때) 
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
