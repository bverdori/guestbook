package com.guest.app;

public class GuestBook {
	private String no;			// 방명록 등록 번호
	private String email;		// 방명록 등록 E-mail
	private String passwd;		// 방명록 등록 비밀번호
	private String txt;			// 방명록 등록 내용
	private String regdate;		// 방명록 등록 날짜
	private String modified;	// 방명록 수정 날짜 (초기 입력시 등록 날짜와 동일, 글 수정할 시 갱신)
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}	
}
