package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Order;


@Repository
public interface OrdersRepository extends JpaRepository<Order, Integer>{

}
