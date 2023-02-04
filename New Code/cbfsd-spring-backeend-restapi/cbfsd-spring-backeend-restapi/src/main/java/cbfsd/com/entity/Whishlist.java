package cbfsd.com.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the whishlist database table.
 * 
 */
@Entity
@NamedQuery(name="Whishlist.findAll", query="SELECT w FROM Whishlist w")
public class Whishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="whishListid")
	private int whishListId;
	@Column(name="productid")
	private int productId;
	@Column(name="userid")
	private int userId;

	public Whishlist() {
	}

	public int getWhishListId() {
		return this.whishListId;
	}

	public void setWhishListId(int whishListId) {
		this.whishListId = whishListId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}