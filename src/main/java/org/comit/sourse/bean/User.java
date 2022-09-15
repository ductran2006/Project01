package org.comit.sourse.bean;

import java.util.Date;
import java.util.Objects;

public class User {
	private int 	idUser;
	private String 	firstName;
	private String 	lastName;
	private String 	userName;
	private String 	password;
	private String 	email;   
	private String  boxName;   
	private String	boxType;       
	private Date 	dateRent;      
	private int 	parcel;    
   
	public User() {
	}

	public User(int idUser, String firstName, String lastName, String userName, String password, String email,
			String boxName, String boxType, Date dateRent, int parcel) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.boxName = boxName;
		this.boxType = boxType;
		this.dateRent = dateRent;
		this.parcel = parcel;
	}

	public int getIdUser() {
		return idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getBoxName() {
		return boxName;
	}

	public String getBoxType() {
		return boxType;
	}

	public Date getDateRent() {
		return dateRent;
	}

	public int getParcel() {
		return parcel;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

	public void setDateRent(Date dateRent) {
		this.dateRent = dateRent;
	}

	public void setParcel(int parcel) {
		this.parcel = parcel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boxName, idUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(boxName, other.boxName) && idUser == other.idUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", boxName=" + boxName + ", boxType="
				+ boxType + ", dateRent=" + dateRent + ", parcel=" + parcel + "]";
	}
}