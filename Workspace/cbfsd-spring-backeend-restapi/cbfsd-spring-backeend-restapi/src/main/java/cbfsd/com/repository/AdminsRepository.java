package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Admins;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Integer>{

}
