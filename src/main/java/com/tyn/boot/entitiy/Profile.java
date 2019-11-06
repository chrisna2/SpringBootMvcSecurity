package com.tyn.boot.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_profiles")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	private String fname;
	private boolean current;
	
	//이런식으로 Porfile에 Member 정보를 주입시켜 준다.
	@ManyToOne // 多 대 1 관계
	private Member member;
	
	public Long getFno() {
		return fno;
	}
	public void setFno(Long fno) {
		this.fno = fno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public boolean isCurrent() {
		return current;
	}
	public void setCurrent(boolean current) {
		this.current = current;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (current ? 1231 : 1237);
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((fno == null) ? 0 : fno.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (current != other.current)
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (fno == null) {
			if (other.fno != null)
				return false;
		} else if (!fno.equals(other.fno))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Profile [fno=" + fno + ", fname=" + fname + ", current=" + current + "]";
	}
	
	
	
	
	
}
