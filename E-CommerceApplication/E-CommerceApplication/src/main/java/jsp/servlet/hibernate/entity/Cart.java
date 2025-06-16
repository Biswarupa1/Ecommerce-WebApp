package jsp.servlet.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.List;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	@ManyToMany
	private List<Product> productInCart;

	public int getCartId() {
		return cartId;
	}

	public List<Product> getProductInCart() {
		return productInCart;
	}

	public void setProductInCart(List<Product> productInCart) {
		this.productInCart = productInCart;
	}
	
}
