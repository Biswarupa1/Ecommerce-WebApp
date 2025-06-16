package jsp.servlet.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.servlet.hibernate.dao.ProductDao;
import jsp.servlet.hibernate.entity.Product;
import jsp.servlet.hibernate.entity.User;

@WebServlet("/find-all-product-url")
public class DisplayAllProductServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> prodList = ProductDao.findAllProducts();
		
		//display the list of products
		req.setAttribute("prodList", prodList);
		req.getRequestDispatcher("product.jsp").include(req, resp);
	}
	
}
