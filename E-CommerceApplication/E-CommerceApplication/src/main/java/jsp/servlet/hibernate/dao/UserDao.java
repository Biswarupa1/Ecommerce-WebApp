package jsp.servlet.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp.servlet.hibernate.entity.Cart;
import jsp.servlet.hibernate.entity.User;

public class UserDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");
	public static void signUp(User u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tnx = em.getTransaction();
		tnx.begin();
		
		em.persist(u);
		
		tnx.commit();
		em.close();
	}
	public static User checkCredentail(String userEmail, String userPass) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("from User u where u.userEmail=?1 and u.userPass=?2");
			query.setParameter(1, userEmail);
			query.setParameter(2, userPass);
			return (User) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}
	public static String findUserName(String userEmail) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from User u where u.userEmail=?1");
		query.setParameter(1, userEmail);
		User u = (User) query.getSingleResult();
		em.close();
		if(u!=null)
			return u.getUserName();  //return userName
		return null;
	}
	public static boolean userExistsByEmail(String userEmail) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from User u where u.userEmail=?1");
		query.setParameter(1, userEmail);
		List<User> u = query.getResultList();
		em.close();
		return !u.isEmpty();
	}
	public static User findUserIdbyEmail(String userEmail) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from User u where u.userEmail=?1");
		query.setParameter(1, userEmail);
		User u = (User)query.getSingleResult();
		em.close();
		return u;
	}

}
