package com.guest.app;

public class GuestBook {
	private String no;			// ���� ��� ��ȣ
	private String email;		// ���� ��� E-mail
	private String passwd;		// ���� ��� ��й�ȣ
	private String txt;			// ���� ��� ����
	private String regdate;		// ���� ��� ��¥
	private String modified;	// ���� ���� ��¥ (�ʱ� �Է½� ��� ��¥�� ����, �� ������ �� ����)
	
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
