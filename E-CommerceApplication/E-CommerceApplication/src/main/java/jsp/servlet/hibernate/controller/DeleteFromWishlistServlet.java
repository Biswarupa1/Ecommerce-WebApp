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

@WebServlet("/deletefromwishlist-url")
public class DeleteFromWishlistServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		//get the cartId and wishId
		int prodId = Integer.parseInt(req.getParameter("prodId"));
		int wishId = user.getWishlish().getWishId();
		
		WishlistDao.deleteFromWishlist(wishId,prodId);
		resp.sendRedirect("display-wishlist-url");
		
	}
	
}
