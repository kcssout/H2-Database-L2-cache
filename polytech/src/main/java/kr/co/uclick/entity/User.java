package kr.co.uclick.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {

	@Id
	@Column(name="no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
 
	@Column(name="name", length = 20)
	private String name;
 
	
	//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="user", orphanRemoval = true)
	@Cascade({org.hibernate.annotations.CascadeType.ALL})	//OneToMany에서 cascade 조건시 부모엔티티를 지울경우 하위엔티티도 같이 지워지게 해주기위해설정
	@OnDelete(action = OnDeleteAction.CASCADE)	//이거 해주면 foreign키에 on delete cascade 걸어줌
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Collection<Phone> phone;

	public User(){}

	public User(String name) {
		this.name = name;
	}
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Phone> getPhone() {
		return phone;
	}

	public void setPhone(Collection<Phone> phone) {
		this.phone = phone;
	}
	
	public void addPhone(Phone p) {
		if(phone == null) {
			phone = new ArrayList<Phone>();
		}
		phone.add(p);
	}
	@Override
	public String toString() {
		String result = "[USER_"+no+"] " + name;
		return result;
	}
	
	public String UserString() {
		String result = "[USER_"+ no + "] " + name;
		for( Phone p : phone ){
			result += "\n  " + p.toString();
		}
		return result;
	}


}





