package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Whishlist;


@Repository
public interface WishlistRepository extends JpaRepository<Whishlist, Integer>{

}
