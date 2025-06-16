package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.servlet.hibernate.dao.UserDao;
import jsp.servlet.hibernate.entity.Cart;
import jsp.servlet.hibernate.entity.User;
import jsp.servlet.hibernate.entity.Wishlist;

@WebServlet("/add-user-url")
public class AddUserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User u = new User();
		u.setUserName(req.getParameter("name"));
		u.setUserEmail(req.getParameter("email"));
		u.setUserPass(req.getParameter("password"));
		u.setUserAddr(req.getParameter("addr"));
		
		//map cart to user
		Cart c = new Cart();
		u.setCart(c);
		
		//map wishlist to user
		Wishlist w = new Wishlist();
		u.setWishlish(w);
		
		UserDao.signUp(u);
		req.setAttribute("mesg", "SignIn successful. Please login");
		req.getRequestDispatcher("signup.jsp").include(req, resp);
	}
	
}
