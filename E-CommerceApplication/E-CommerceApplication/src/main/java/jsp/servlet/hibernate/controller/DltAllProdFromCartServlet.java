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

@WebServlet("/delete-all-prod-url")
public class DltAllProdFromCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		
		int cartId = user.getCart().getCartId();
		CartDao.dltAllProdFromCart(cartId);
		
		resp.sendRedirect("cart.jsp");
	}
	
}
