package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import entity.UserInfo;
import impl.UserInfoDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=UTF-8");
	
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String method = request.getParameter("method");
	
	UserInfoDao dao = new UserInfoDaoImpl();
	//µÇÂ¼
	if("login".equals(method)) {
	UserInfo info = dao.query(username, password);
	if(info == null) {
		//Ìø×ªµ½µÇÂ¼Ò³Ãæ
		request.setAttribute("mgs","µÇÂ¼Ê§°Ü");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}else {
		System.out.println("µÇÂ¼³É¹¦");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		request.getRequestDispatcher("book").forward(request, response);
	}
	
	}
	//×¢²á
	if("reg".equals(method)) {
		UserInfo info = new UserInfo();
		info.setUsername(username);
		info.setPassword(password);
		int rows = dao.insert(info);
		if(rows > 0) {
			System.out.println("×¢²á³É¹¦");
			//response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg","×¢²áÊ§°Ü");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
		
	}
	}
}
