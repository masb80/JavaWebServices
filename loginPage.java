package TaumunWebPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.loginService;
import service.dto.User;

@WebServlet("/loginPage")
public class loginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId, password;
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		loginService loginService = new loginService();
		boolean results = loginService.authenticate(userId, password);
		
		if(results){
			User user = loginService.getUserDetails(userId);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("success.jsp");
			return;
		}
		else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
