package com.medibuddy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Prasanna
 *
 */
@Entity
@Table(name = "[DoctorInfo]")
public class DoctorInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String specializationId;
	private String gender;
	private String address;
	private String contact;
	private Date joinedOn;
	
	@OneToMany(mappedBy = "doctorInfo", cascade = CascadeType.ALL)
	private List<PatientInfo> patientInfo;
	
	@ManyToOne
	@JoinColumn(name = "specializationId", updatable=false, insertable=false)
	private SpecializationInfo specializationInfo;
	
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
	 * @return the patientInfo
	 */
	public List<PatientInfo> getPatientInfo() {
		return patientInfo;
	}
	/**
	 * @param patientInfo the patientInfo to set
	 */
	public void setPatientInfo(List<PatientInfo> patientInfo) {
		patientInfo = patientInfo;
	}
	/**
	 * @return the specializationId
	 */
	public String getSpecializationId() {
		return specializationId;
	}
	/**
	 * @param specializationId the specializationId to set
	 */
	public void setSpecializationId(String specializationId) {
		this.specializationId = specializationId;
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
	 * @return the joinedOn
	 */
	public Date getJoinedOn() {
		return joinedOn;
	}
	/**
	 * @param joinedOn the joinedOn to set
	 */
	public void setJoinedOn(Date joinedOn) {
		this.joinedOn = joinedOn;
	}
	
}
 