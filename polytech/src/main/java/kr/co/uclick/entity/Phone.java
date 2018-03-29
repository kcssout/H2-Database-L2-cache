package kr.co.uclick.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Phone {	
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long seq;

	@Column(name="ph_number")
	private String ph_number;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="member_id")
	private User user;
	
	public Phone() {}	
	public Phone(User user,String ph_number){
		this.ph_number = ph_number;
		this.user = user;
	}	
	public Phone(String ph_number){
		this.ph_number = ph_number;
	}		
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPh_number() {
		return ph_number;
	}
	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}	
	@Override
	public String toString() {
		String result = "[phone_"+seq+"] 전화번호: " + ph_number;
		return result;
	}
}
