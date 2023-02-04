package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Cart;



@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
