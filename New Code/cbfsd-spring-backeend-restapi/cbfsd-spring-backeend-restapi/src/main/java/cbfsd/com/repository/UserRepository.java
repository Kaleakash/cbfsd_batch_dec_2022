package cbfsd.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.email =:email and u.password = :password")
	public User findUser(@Param("email") String email,@Param("password") String password);
	
	
}
