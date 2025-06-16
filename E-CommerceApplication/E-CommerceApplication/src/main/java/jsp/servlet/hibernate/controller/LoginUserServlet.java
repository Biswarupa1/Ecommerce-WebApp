package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.UserDao;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/login-user-url")
public class LoginUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userEmail = req.getParameter("userEmail");
		String userPass = req.getParameter("userPass");
		
		//check user exits or not
		if(UserDao.userExistsByEmail(userEmail)) {
			//check credentials is crrt or not
			User user = UserDao.checkCredentail(userEmail,userPass);
			if(user!=null) {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				resp.sendRedirect("homepage.jsp");
			}
			else{
				req.setAttribute("errMesg", "Invalid Credentails");
				req.getRequestDispatcher("index.jsp").include(req, resp);
			}
		}
		else {
			req.setAttribute("errMesg", "Email not registered!Please SignUp");
			req.getRequestDispatcher("index.jsp").include(req, resp);
		}
	}

	
	
}
