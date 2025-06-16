package jsp.servlet.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jsp.servlet.hibernate.entity.Product;
import jsp.servlet.hibernate.entity.User;
import jsp.servlet.hibernate.entity.Wishlist;

public class WishlistDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	public static void addtoWishlist(int wishId, int prodId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		//get the wishlist and product in the currt session
		Wishlist wishlist = em.find(Wishlist.class, wishId);
		Product prod = em.find(Product.class, prodId);
		
		//get the list of product in wishlist
		List<Product> prodList = wishlist.getProductInWishlist();
		if(prodList==null) {
			prodList = new ArrayList<Product>();
		}
		prodList.add(prod);
		
		//set the updated prodlist
		wishlist.setProductInWishlist(prodList);
		
		tnx.commit();
		em.close();
	}
	public static List<Product> prodInWishlist(int userId) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, userId);
		Wishlist wishlist = user.getWishlish();
		
		List<Product> prodList = wishlist.getProductInWishlist();
		prodList.size();
		
		em.close();
		return prodList;
	}
	public static void deleteFromWishlist(int wishId, int prodId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		Wishlist wishlist = em.find(Wishlist.class, wishId);
		Product prod = em.find(Product.class, prodId);
		
		List<Product> prodList = wishlist.getProductInWishlist();
		prodList.remove(prod);
		
		wishlist.setProductInWishlist(prodList);
		
		tnx.commit();
		em.close();
	}

}
