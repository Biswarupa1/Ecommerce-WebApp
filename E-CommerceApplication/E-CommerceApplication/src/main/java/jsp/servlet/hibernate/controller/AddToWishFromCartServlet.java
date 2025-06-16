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

@WebServlet("/addToWishlistFromCart-url")
public class AddToWishFromCartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		
//		resp.sendRedirect("addtowishlist-url?prodId="+prodId);
		HttpSession session = req.getSession(false);
		User user =(User) session.getAttribute("user");
		
		int wishId = user.getWishlish().getWishId();
		int cartId = user.getCart().getCartId();
		
		//add prod to wishlist
		WishlistDao.addtoWishlist(wishId,prodId);
		CartDao.deleteFromCart(cartId, prodId);
		
		session.setAttribute("mesg", "Product added to wishlist!");
		resp.sendRedirect("display-cart-url");
	}
	
}
