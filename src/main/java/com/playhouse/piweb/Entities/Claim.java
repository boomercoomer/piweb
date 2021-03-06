package com.playhouse.piweb.Entities;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Claims")
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClaim;
	private String subject;
	  @Temporal (TemporalType.DATE)
	  private Date dateClaim;
	private int qrcode;
	private String fileType;
	
	@Enumerated (EnumType.STRING)
	private Status status;
	public enum Status {
		treated, not_treated, pending_treatment
	}

	
	//**********************@ManyToOne
	//	@JoinColumn(name = "iduser")
	//	private Parent parent;*******************************
	public Claim(String subject, Date dateClaim, int qrcode, String fileType, Status status) {
		super();
		this.subject = subject;
		this.dateClaim = dateClaim;
		this.qrcode = qrcode;
		this.fileType = fileType;
		this.status = status;
	}

	//*****************************************************
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	//*****************************************************
	public int getIdClaim() {
		return idClaim;
	}
	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDateClaim() {
		return dateClaim;
	}
	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}
	public int getQrcode() {
		return qrcode;
	}
	public void setQrcode(int qrcode) {
		this.qrcode = qrcode;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
