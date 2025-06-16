package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.CartDao;
import jsp.servlet.hibernate.dao.WishlistDao;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/addToCartFromWish-url")
public class AddToCartFromWishServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		int cartId = user.getCart().getCartId();
		int wishId = user.getWishlish().getWishId();
		
		CartDao.addTocart(cartId, prodId);
		WishlistDao.deleteFromWishlist(wishId, prodId);
		
		session.setAttribute("mesg", "Product added to Cart");
		resp.sendRedirect("display-wishlist-url");
	}
	
}
