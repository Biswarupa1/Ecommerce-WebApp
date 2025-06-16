package jsp.servlet.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.hibernate.dao.OrdersDao;
import jsp.servlet.hibernate.entity.Orders;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/display-orders-url")
public class DisplayOrdersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		
		//get the userId
		int userId = u.getUserId();
		List<Orders> ordersList = OrdersDao.orderDetails(userId);
		
		req.setAttribute("ordersList", ordersList);
		req.getRequestDispatcher("orders.jsp").include(req, resp);
		
	}
	
}
