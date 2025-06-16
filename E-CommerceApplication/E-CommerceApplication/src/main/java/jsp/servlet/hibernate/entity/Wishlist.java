package jsp.servlet.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Wishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wishId;
	
	@ManyToMany
	private List<Product> productInWishlist;

	public int getWishId() {
		return wishId;
	}
	
	public List<Product> getProductInWishlist() {
		return productInWishlist;
	}

	public void setProductInWishlist(List<Product> productInWishlist) {
		this.productInWishlist = productInWishlist;
	}
	
	
}
