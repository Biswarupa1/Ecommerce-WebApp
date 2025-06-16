package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.WishlistDao;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/addToWishlistFromProd-url")
public class AddToWishFromProdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		//get the prodId and wishId
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		int wishId = user.getWishlish().getWishId();
		
		//add prod to wishlist
		WishlistDao.addtoWishlist(wishId,prodId);
		
		session.setAttribute("mesg", "Product added to Wishlist successfully!");
		resp.sendRedirect("find-all-product-url");
	}
	
}
