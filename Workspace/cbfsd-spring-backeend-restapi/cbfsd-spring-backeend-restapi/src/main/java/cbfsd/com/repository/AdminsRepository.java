package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Admin;


@Repository
public interface AdminsRepository extends JpaRepository<Admin, Integer>{

	//JPQL Query 
	@Query("select ad from Admin ad where ad.email = :emailname and ad.password = :pass")
	public Admin signIn(@Param("emailname") String email, @Param("pass") String password);
}
