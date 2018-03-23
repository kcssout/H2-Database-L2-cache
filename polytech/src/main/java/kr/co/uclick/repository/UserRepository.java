package kr.co.uclick.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.uclick.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByName(String name);
	
	//public Stream<User> findAllAsStream();//대용량의 데이터를 담을 때 받으면서 이런 작업들을 할 수 있게 해주는
}


