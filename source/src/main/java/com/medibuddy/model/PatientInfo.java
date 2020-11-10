package com.medibuddy.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Prasanna
 *
 */
@Entity
@Table(name = "[PatientInfo]")
public class PatientInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String doctorId;
	private String age;
	private String gender;
	private String address;
	private String contact;
	private Date lastVisited;
	private String history;
	
	@ManyToOne
	@JoinColumn(name = "doctorId", updatable=false, insertable=false)
	private DoctorInfo doctorInfo;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the doctorId
	 */
	public String getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * @return the lastVisited
	 */
	public Date getLastVisited() {
		return lastVisited;
	}
	/**
	 * @param lastVisited the lastVisited to set
	 */
	public void setLastVisited(Date lastVisited) {
		this.lastVisited = lastVisited;
	}
	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}
	/**
	 * @param history the history to set
	 */
	public void setHistory(String history) {
		this.history = history;
	}
	
}
 