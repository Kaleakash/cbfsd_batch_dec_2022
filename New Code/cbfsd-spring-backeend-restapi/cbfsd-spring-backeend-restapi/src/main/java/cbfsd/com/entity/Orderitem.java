package cbfsd.com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderitems database table.
 * 
 */
@Entity
@Table(name="orderitems")
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderitemid")
	private int orderItemId;

	private int price;
	@Column(name="productcategory")
	private String productCategory;
	@Column(name="productcode")
	private String productCode;
	@Column(name="productdescription")
	private String productDescription;
	@Column(name="productimg")
	private String productImg;
	@Column(name="producttitle")
	private String productTitle;

	private int quantity;
	@Column(name="totalprice")
	private int totalPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	public Orderitem() {
	}

	public int getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImg() {
		return this.productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductTitle() {
		return this.productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Orderitem [orderItemId=" + orderItemId + ", price=" + price + ", productCategory=" + productCategory
				+ ", productCode=" + productCode + ", productDescription=" + productDescription + ", productImg="
				+ productImg + ", productTitle=" + productTitle + ", quantity=" + quantity + ", totalPrice="
				+ totalPrice + ", order=" + order + ", product=" + product + "]";
	}

	
}