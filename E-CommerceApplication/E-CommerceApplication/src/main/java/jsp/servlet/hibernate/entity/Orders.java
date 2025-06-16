package jsp.servlet.hibernate.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private Date orderDate;
	private int orderAmt;
	
	@ManyToMany
	private List<Product> orderedProd;
	
	public int getOrderId() {
		return orderId;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderAmt() {
		return orderAmt;
	}

	public void setOrderAmt(int orderAmt) {
		this.orderAmt = orderAmt;
	}

	public List<Product> getOrderedProd() {
		return orderedProd;
	}

	public void setOrderedProd(List<Product> orderedProd) {
		this.orderedProd = orderedProd;
	}

}
