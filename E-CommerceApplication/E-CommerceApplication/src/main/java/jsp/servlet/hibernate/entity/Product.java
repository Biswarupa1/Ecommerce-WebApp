package jsp.servlet.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prodId;
	private String prodName;
	private String prodBrand;
    private String prodCatgy;
	private int prodPrice;
	
	public int getProdId() {
		return prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdBrand() {
		return prodBrand;
	}
	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}
	public String getProdCatgy() {
		return prodCatgy;
	}
	public void setProdCatgy(String prodCatgy) {
		this.prodCatgy = prodCatgy;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodBrand=" + prodBrand + ", prodCatgy="
				+ prodCatgy + ", prodPrice=" + prodPrice + "]";
	}
	
	
}
