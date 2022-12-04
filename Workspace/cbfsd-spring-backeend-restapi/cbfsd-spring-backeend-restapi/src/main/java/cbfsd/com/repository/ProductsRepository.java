package cbfsd.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

	@Query("select p from Products p where p.price > :price")
	public List<Products> searchProductByPrice(@Param("price") int price);
}
