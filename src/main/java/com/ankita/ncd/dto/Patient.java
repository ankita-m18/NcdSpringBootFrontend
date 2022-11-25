package com.ankita.ncd.dto;

public class Patient 
{
	private String patientid;
	private String firstname;
	private String lastname;	
	private String gender;
	private String phone;
	private String birthday;
	private int pincode;
	private int score;
	private String screening;
	
	
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getScreening() {
		return screening;
	}
	public void setScreening(String screening) {
		this.screening = screening;
	}
	
	public Patient(String patientid, String firstname, String lastname, String gender, String phone, String birthday,
			int pincode, int score, String screening) {
		super();
		this.patientid = patientid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.pincode = pincode;
		this.score = score;
		this.screening = screening;
	}
	
	public Patient()
	{
		
	}
	
	
}
