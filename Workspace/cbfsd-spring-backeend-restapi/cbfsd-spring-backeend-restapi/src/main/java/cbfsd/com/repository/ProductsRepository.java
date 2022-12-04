package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
