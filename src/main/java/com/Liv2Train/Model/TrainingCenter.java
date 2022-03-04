package com.Liv2Train.Model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="TrainingCenter")
public class TrainingCenter {

	@Id
	private String _id;
	
	@Length(min=12, max=12, message = "Center Code must contains 12 characters in AlphaNumeric Pattern")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	@Indexed(unique=true)
	private String centerCode;
	
	@Size(max = 40)
	private String centerName;
	
	private Address address;
	
	private int studentCapacity;
	
	private List<String> coursesOffered;
	
	private Date createdOn;
	
	@Pattern(message="Enter valid Email-Address!!", regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String contactEmail;
	
	@Pattern(message = "Enter valid Contact Number!!", regexp="[0-9]*")
	private String contactPhone;

	
	
	public TrainingCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public TrainingCenter(String _id, @Pattern(regexp = "^[A-Za-z0-9]+$") String centerCode,
			@Size(max = 40) String centerName, Address address, int studentCapacity, List<String> coursesOffered,
			Date createdOn,
			@Pattern(message = "Enter valid Email-Address!!", regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$") String contactEmail,
			@Pattern(message = "Enter valid Contact Number!!", regexp = "[0-9]*") String contactPhone) {
		super();
		this._id = _id;
		this.centerCode = centerCode;
		this.centerName = centerName;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	@Override
	public String toString() {
		return "TrainingCenter [_id=" + _id + ", centerCode=" + centerCode + ", centerName=" + centerName + ", address="
				+ address + ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered
				+ ", createdOn=" + createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone
				+ "]";
	}
	
	
}
