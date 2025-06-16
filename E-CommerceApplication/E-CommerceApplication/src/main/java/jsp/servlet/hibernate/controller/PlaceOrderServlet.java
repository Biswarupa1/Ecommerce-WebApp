package jsp.servlet.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.OrdersDao;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/placeOrder-url")
public class PlaceOrderServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		//get the cartId and userId
		int cartId = user.getCart().getCartId();
		int userId = user.getUserId();
		
		OrdersDao.placeOrder(userId,cartId);
		session.setAttribute("mesg", "Order Places Succesfully!");
		resp.sendRedirect("display-cart-url");
	}

	
}
