package jsp.servlet.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jsp.servlet.hibernate.entity.Cart;
import jsp.servlet.hibernate.entity.Product;

public class CartDao {
static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	public static void addTocart(int cartId, int prodId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		// Re-fetch the Cart and Product in the same session
        Cart cart = em.find(Cart.class, cartId);
        Product product = em.find(Product.class, prodId);
	    
	    // Get the current list and add new product
	    List<Product> currProd = cart.getProductInCart();
	    if (currProd == null) {
	    	currProd = new ArrayList<>();
	    }
	    currProd.add(product);
	    
	    // Set the updated list
	    cart.setProductInCart(currProd);
		
		tnx.commit();
		em.close();	
	}
	public static List<Product> prodInCart(int cartId) {
		EntityManager em = emf.createEntityManager();
		
		// re-fetch the Cart in the same session 
		Cart cart = em.find(Cart.class, cartId);
		
		//Force initialization of the lazy collection inside open session
        List<Product> prodList = cart.getProductInCart();
        prodList.size(); // This triggers the loading from DB
		
		em.close();
		return prodList;
	}
	public static void deleteFromCart(int cartId, int prodId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		//re-fetch the cart and product in the same session
		Cart cart = em.find(Cart.class, cartId);
		Product prod = em.find(Product.class, prodId);
		
		//get the list of prod in cart
		List<Product> prodList = cart.getProductInCart();
		prodList.remove(prod);
		
		cart.setProductInCart(prodList);
		
		tnx.commit();
		em.close();	
	}
	public static int getCartAmt(int cartId) {
		EntityManager em = emf.createEntityManager();
		
		//get the list of prod in cart
		List<Product> prodList = prodInCart(cartId);
		
		int totalAmt = 0;
		for(Product prod: prodList)
			totalAmt+=prod.getProdPrice();
		
		return totalAmt;
	}
	public static void dltAllProdFromCart(int cartId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		//get the cart in the current session
		Cart cart = em.find(Cart.class, cartId);
		
		//get the list of prod in cart
		List<Product> prodList = cart.getProductInCart();
		prodList.removeAll(prodList);
		
		tnx.commit();
		em.close();
	}

}
