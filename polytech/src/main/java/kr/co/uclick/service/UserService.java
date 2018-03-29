package kr.co.uclick.service;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public List<User> findUser(String name){
		return userRepository.findUser(name);
	}
	
	public void updateName(String newName, Long no) {
		userRepository.updateName(newName, no);		
	}
	
	public void deleteById(Long no) {
		userRepository.deleteById(no);
	}
	
	
}
