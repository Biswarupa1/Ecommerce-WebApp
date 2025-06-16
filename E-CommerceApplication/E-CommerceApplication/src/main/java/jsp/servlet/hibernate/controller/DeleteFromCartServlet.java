package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.CartDao;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/deletefromcart-url")
public class DeleteFromCartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the currt user from session
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		
		//get the cartId and prodId
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		int cartId = u.getCart().getCartId();
		
		CartDao.deleteFromCart(cartId,prodId);
		
		resp.sendRedirect("display-cart-url");
		
		
	}

}
