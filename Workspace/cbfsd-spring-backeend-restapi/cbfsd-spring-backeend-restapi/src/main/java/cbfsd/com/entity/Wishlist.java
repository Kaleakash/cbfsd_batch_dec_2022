package cbfsd.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wishlist {
	@Id
	@Column(name="wishlistid")
	private int wishlistId;
	@Column(name="productid")
	private int productId;
	@Column(name="userid")
	private int userId;
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wishlist(int wishlistId, int productId, int userId) {
		super();
		this.wishlistId = wishlistId;
		this.productId = productId;
		this.userId = userId;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", productId=" + productId + ", userId=" + userId + "]";
	}
	
}
