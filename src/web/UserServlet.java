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
	//��¼
	if("login".equals(method)) {
	UserInfo info = dao.query(username, password);
	if(info == null) {
		//��ת����¼ҳ��
		request.setAttribute("mgs","��¼ʧ��");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}else {
		System.out.println("��¼�ɹ�");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		request.getRequestDispatcher("book").forward(request, response);
	}
	
	}
	//ע��
	if("reg".equals(method)) {
		UserInfo info = new UserInfo();
		info.setUsername(username);
		info.setPassword(password);
		int rows = dao.insert(info);
		if(rows > 0) {
			System.out.println("ע��ɹ�");
			//response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg","ע��ʧ��");
			request.getRequestDispatcher("reg.jsp").forward(request, response);
		}
		
	}
	}
}
