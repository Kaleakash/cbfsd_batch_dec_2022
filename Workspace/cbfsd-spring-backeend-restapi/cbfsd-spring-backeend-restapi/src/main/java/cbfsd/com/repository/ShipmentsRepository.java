package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Shipment;


@Repository
public interface ShipmentsRepository extends JpaRepository<Shipment, Integer>{

}
