package com.tyn.boot.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pdsfiles")
public class PDSFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fno;
	private String pdsfiles;
	
	public Long getFno() {
		return fno;
	}
	public void setFno(Long fno) {
		this.fno = fno;
	}
	public String getPdsfiles() {
		return pdsfiles;
	}
	public void setPdsfiles(String pdsfiles) {
		this.pdsfiles = pdsfiles;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fno == null) ? 0 : fno.hashCode());
		result = prime * result + ((pdsfiles == null) ? 0 : pdsfiles.hashCode());
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
		PDSFile other = (PDSFile) obj;
		if (fno == null) {
			if (other.fno != null)
				return false;
		} else if (!fno.equals(other.fno))
			return false;
		if (pdsfiles == null) {
			if (other.pdsfiles != null)
				return false;
		} else if (!pdsfiles.equals(other.pdsfiles))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PDSFile [fno=" + fno + ", pdsfiles=" + pdsfiles + "]";
	}
	
}
