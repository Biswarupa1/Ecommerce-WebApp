package jsp.servlet.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.WishlistDao;
import jsp.servlet.hibernate.entity.Product;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/display-wishlist-url")
public class DisplayWishlistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		List<Product> prodList = WishlistDao.prodInWishlist(user.getUserId());
		req.setAttribute("prodList", prodList);
		req.getRequestDispatcher("wishlist.jsp").include(req, resp);
	}
	
}
