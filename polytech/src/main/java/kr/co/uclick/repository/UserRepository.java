package kr.co.uclick.repository;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByName(String name);
	
	public List<User> findAll();
	
	@Transactional
	@Modifying
	@Query("select u from User u where u.name like %?1%")
	@QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value ="true"),
			 @QueryHint(name = "org.hibernate.cacheMode", value ="NORMAL"),
			 @QueryHint(name = "org.hibernate.cacheRegion", value ="user-find")})
	public List<User> findUser(String name);
		
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.no = ?2")
	public void updateName(String newName, Long seq);

	@Transactional
	@Modifying
	@Query("delete from User u where u.no = :no")
	public void deleteById(@Param("no") Long no);
}


