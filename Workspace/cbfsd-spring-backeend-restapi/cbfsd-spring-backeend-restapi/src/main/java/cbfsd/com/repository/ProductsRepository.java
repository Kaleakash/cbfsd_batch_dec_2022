package cbfsd.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Product;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer>{

	@Query("select p from Product p where p.price > :price")
	public List<Product> searchProductByPrice(@Param("price") int price);
}
