package com.mvc.upgrade.model.dto;

import java.util.Date;

public class ABoardDto {

	private int bno;
	private String bname;
	private String bpw;
	private String btitle;
	private String bcontent;
	private Date bdate;
	
	
	public ABoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ABoardDto(int bno, String bname, String bpw, String btitle, String bcontent, Date bdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.bpw = bpw;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
	}


	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getBpw() {
		return bpw;
	}


	public void setBpw(String bpw) {
		this.bpw = bpw;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public Date getBdate() {
		return bdate;
	}


	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	
	
	
	
}
