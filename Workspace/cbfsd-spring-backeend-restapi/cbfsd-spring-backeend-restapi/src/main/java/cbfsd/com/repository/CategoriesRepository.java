package cbfsd.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cbfsd.com.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
