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

@WebServlet("/addToCartFromProd-url")
public class AddToCartFromProdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); // false = don't create new session if it doesn't exist
		User u = (User) session.getAttribute("user");
		
		int cartId = u.getCart().getCartId();
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		CartDao.addTocart(cartId,prodId);
		
		session.setAttribute("mesg", "Product added to cart successfully!");
        resp.sendRedirect("find-all-product-url");
	}	
}
