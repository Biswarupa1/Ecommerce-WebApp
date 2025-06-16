package jsp.servlet.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp.servlet.hibernate.entity.Product;

public class ProductDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	public static List<Product> findAllProducts() {
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("from Product");
		List<Product> prodList = query.getResultList();
		em.close();
		
		return prodList;
	}
	
}
