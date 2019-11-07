package com.tyn.boot.entitiy;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_free_replies")
public class FreeBoardReply {
	
	@Id
	@GeneratedValue
	private Long rno;
	
	private String reply;
	private String replyer;
	
	@CreationTimestamp
	private Timestamp replydate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
	
	//양방향 관게 설정 : 댓글///////////////////////
	@ManyToOne
	private FreeBoard board;
	
	public FreeBoard getBoard() {
		return board;
	}

	public void setBoard(FreeBoard board) {
		this.board = board;
	}
	////////////////////////////////////////
	
	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Timestamp getReplydate() {
		return replydate;
	}

	public void setReplydate(Timestamp replydate) {
		this.replydate = replydate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "FreeBoardReply [rno=" + rno + ", reply=" + reply + ", replyer=" + replyer + ", replydate=" + replydate
				+ ", updatedate=" + updatedate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result + ((replydate == null) ? 0 : replydate.hashCode());
		result = prime * result + ((replyer == null) ? 0 : replyer.hashCode());
		result = prime * result + ((rno == null) ? 0 : rno.hashCode());
		result = prime * result + ((updatedate == null) ? 0 : updatedate.hashCode());
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
		FreeBoardReply other = (FreeBoardReply) obj;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (replydate == null) {
			if (other.replydate != null)
				return false;
		} else if (!replydate.equals(other.replydate))
			return false;
		if (replyer == null) {
			if (other.replyer != null)
				return false;
		} else if (!replyer.equals(other.replyer))
			return false;
		if (rno == null) {
			if (other.rno != null)
				return false;
		} else if (!rno.equals(other.rno))
			return false;
		if (updatedate == null) {
			if (other.updatedate != null)
				return false;
		} else if (!updatedate.equals(other.updatedate))
			return false;
		return true;
	}
	
}
