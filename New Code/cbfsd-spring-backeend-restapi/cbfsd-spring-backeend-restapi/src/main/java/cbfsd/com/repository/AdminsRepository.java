package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cbfsd.com.entity.Admin;



@Repository
public interface AdminsRepository extends JpaRepository<Admin, Integer>{

	@Query("select a from Admin a where a.email = :email and a.password = :password")
	public Admin signIn(@Param("email") String email, @Param("password") String password);
	
	@Transactional
	@Modifying
	@Query("delete from Admin a where a.email = :email")
	public int deleteAdminInfo(@Param("email") String mail);
}
