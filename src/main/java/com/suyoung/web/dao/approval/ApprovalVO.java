package com.suyoung.web.dao.approval;

import java.util.Date;

public class ApprovalVO {
	private int id;
	private String status;
	private int docId;
	private int personInCharge;
	private Date regDate;
	private Date modDate;
	
	private String docTitle;
	private String personInChargeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public int getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(int personInCharge) {
		this.personInCharge = personInCharge;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getPersonInChargeName() {
		return personInChargeName;
	}
	public void setPersonInChargeName(String personInChargeName) {
		this.personInChargeName = personInChargeName;
	}
	public String getDocTitle() {
		return docTitle;
	}
	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}
	
	
}
