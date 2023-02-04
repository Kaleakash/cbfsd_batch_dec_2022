package cbfsd.com.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productid")
	private int productId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="addedon")
	private Date addedOn;
	
	@ElementCollection
	@OrderColumn(name = "imageId")
	@CollectionTable(name = "imageinfo")
	private String images[];

	private int price;
	@Column(name="productcode")
	private String productCode;
	@Column(name="productdescription")
	private String productDescription;
	@Column(name="producttitle")
	private String productTitle;
	
	private int rating;
	@Column(name="thumbnailimage")
	private int thumbnailImage;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="product",fetch = FetchType.EAGER)
	private List<Orderitem> orderitems;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryid")
	private Category category;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getAddedOn() {
		return this.addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}



	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getProductTitle() {
		return this.productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getThumbnailImage() {
		return this.thumbnailImage;
	}

	public void setThumbnailImage(int thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setProduct(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setProduct(null);

		return orderitem;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", addedOn=" + addedOn + ", images=" + images.length
				+ ", price=" + price + ", productCode=" + productCode + ", productDescription=" + productDescription
				+ ", productTitle=" + productTitle + ", rating=" + rating + ", thumbnailImage=" + thumbnailImage
				+ ", orderitems=" + orderitems + ", category=" + category + "]";
	}

}