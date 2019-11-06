package com.tyn.boot.entitiy;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pds")
public class PDSBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String pname;
	private String pwriter;
	
	
	//이렇게 1개만  지정이 되게 되면 JPA에서는 무조건 여러개의 데이터를 저장하기 위해서 "별도의 테이블"을 '자동으로' 생성하게 된다.
	@OneToMany(cascade = CascadeType.ALL)//영속성 전이에 대한 설정 (특정 날짜에 대한 데이터가 사라지면 관련된 일정도 같이 삭제 되어야 함) : 모든 변경에 대한 전이	
	@JoinColumn(name="pdsno")//이게 조인 키가 되어 테이블에 연관관계를 이어 주게 된다. 여기서 pdsno == pid 이다.
	private List<PDSFile> files;
	
	public List<PDSFile> getFiles() {
		return files;
	}
	public void setFiles(List<PDSFile> files) {
		this.files = files;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPwriter() {
		return pwriter;
	}
	public void setPwriter(String pwriter) {
		this.pwriter = pwriter;
	}
	
	@Override
	public String toString() {
		return "PDSBoard [pid=" + pid + ", pname=" + pname + ", pwriter=" + pwriter + ", files=" + files + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
		result = prime * result + ((pwriter == null) ? 0 : pwriter.hashCode());
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
		PDSBoard other = (PDSBoard) obj;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		if (pwriter == null) {
			if (other.pwriter != null)
				return false;
		} else if (!pwriter.equals(other.pwriter))
			return false;
		return true;
	}
	
}
