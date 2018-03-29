package kr.co.uclick.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	public List<User> findUser(String name);
		
	@Transactional
	@Modifying
	@Query("update User u set u.name = ?1 where u.no = ?2")
	public void updateName(String newName, Long seq);

	@Transactional
	@Modifying
	@Query("delete from User u where u.no = :no")
	public void deleteById(@Param("no") Long no);
	
	//public Stream<User> findAllAsStream();//대용량의 데이터를 담을 때 받으면서 이런 작업들을 할 수 있게 해주는

}


