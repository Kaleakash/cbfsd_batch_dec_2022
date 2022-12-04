package cbfsd.com.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	private int productId;
	@Column(name = "producttitle")
	private String productTitle;
	@Column(name = "productdescription")
	private String productDescription;
	@Column(name = "productcode")
	private String productCode;
	//private List<String> images;
	@Column(name = "thumbnailimage")
	private int thumbnailImage;
	private int price;	
	@Column(name = "addedon")
	private LocalDate addedOn;
	private int rating;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Products(int productId, String productTitle, String productDescription, String productCode,
//			List<String> images, int thumbnailImage, int price, LocalDate addedOn, int rating) {
//		super();
//		this.productId = productId;
//		this.productTitle = productTitle;
//		this.productDescription = productDescription;
//		this.productCode = productCode;
//		this.images = images;
//		this.thumbnailImage = thumbnailImage;
//		this.price = price;
//		this.addedOn = addedOn;
//		this.rating = rating;
//	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
//	public List<String> getImages() {
//		return images;
//	}
//	public void setImages(List<String> images) {
//		this.images = images;
//	}
	public int getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(int thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productTitle=" + productTitle + ", productDescription="
				+ productDescription + ", productCode=" + productCode + ", thumbnailImage=" + thumbnailImage
				+ ", price=" + price + ", addedOn=" + addedOn + ", rating=" + rating + "]";
	}

	
}
