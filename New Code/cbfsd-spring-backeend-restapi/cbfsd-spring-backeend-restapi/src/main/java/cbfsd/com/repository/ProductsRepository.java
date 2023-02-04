package cbfsd.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Product;



@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>{

	@Query(value="select * from products p, imageinfo i where p.productId=i.product_productid and image_id=0",nativeQuery = true)
	public List<Product> findProductWithImages();

}
