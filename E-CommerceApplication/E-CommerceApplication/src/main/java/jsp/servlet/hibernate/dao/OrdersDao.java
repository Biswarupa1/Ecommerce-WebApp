package jsp.servlet.hibernate.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jsp.servlet.hibernate.entity.Cart;
import jsp.servlet.hibernate.entity.Orders;
import jsp.servlet.hibernate.entity.Product;
import jsp.servlet.hibernate.entity.User;

public class OrdersDao {
static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	public static void placeOrder(int userId, int cartId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		//re-fetch user and cart 
		User user = em.find(User.class, userId);
		Cart cart = em.find(Cart.class,cartId);
		
		//get the list of prod present in cart
		List<Product> prodList = cart.getProductInCart();
		prodList.size();
		
		// add the prodList into order
		Orders orders = new Orders();
		orders.setOrderDate(new Date()); //set date that satisfy db date format
		orders.setOrderAmt(CartDao.getCartAmt(cartId));
		orders.setOrderedProd(new ArrayList<>(prodList));
		
		//add the prodList into order
		List<Orders> ordersList = user.getOrders();
		if(ordersList==null || ordersList.isEmpty())
			ordersList = new ArrayList<Orders>();
		ordersList.size();
		ordersList.add(orders);
		
		//map the orders to user
		user.setOrders(ordersList);
		
		//delete the prod in cart
		cart.getProductInCart().clear();
		
		//persist the orders
		em.persist(orders);
		
		tnx.commit();
		em.close();
	}
	public static List<Orders> orderDetails(int userId) {
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, userId);
		List<Orders> orderList = user.getOrders();
		orderList.size();
		
		em.close();
		return orderList;
	}
	public static List<Product> getOrderedProd(int orderId){
		EntityManager em = emf.createEntityManager();
		
		Orders orders = em.find(Orders.class, orderId);
		List<Product> orderedProd = orders.getOrderedProd();
		orderedProd.size();
		
		em.close();
		return orderedProd;
	}
	
}
