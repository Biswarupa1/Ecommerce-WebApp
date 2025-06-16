package jsp.servlet.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.CartDao;
import jsp.servlet.hibernate.entity.Product;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/display-cart-url")
public class DisplayCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User)session.getAttribute("user");
		
		//get the cartId
		int cartId = u.getCart().getCartId();
		
		//fetch the products available in cart
		List<Product> prodList = CartDao.prodInCart(cartId);
		
		req.setAttribute("prodList", prodList);
		req.getRequestDispatcher("cart.jsp").include(req, resp);	
	}
	
}
