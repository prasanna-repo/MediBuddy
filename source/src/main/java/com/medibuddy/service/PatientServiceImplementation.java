package com.medibuddy.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.medibuddy.controller.DoctorController;
import com.medibuddy.dao.PatientDao;
import com.medibuddy.exception.resolver.DataIntegrityExceptionResolver;
import com.medibuddy.exception.resolver.DataNotFoundExceptionResolver;
import com.medibuddy.exception.resolver.EmptyResultDataAccessExceptionResolver;
import com.medibuddy.exception.resolver.NoSuchElementExceptionResolver;
import com.medibuddy.exception.resolver.NullPointerExceptionResolver;
import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;



/**
 * @author Prasanna
 *
 */
@Service
public class PatientServiceImplementation implements PatientService {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	PatientDao patientDao;

	/**
	 * @Service - Get Patient Information
	 *
	 */
	@Override
	public List<PatientInfo> getPatientInfo() {
		if(patientDao.count() > 0) {
			return (List<PatientInfo>) patientDao.findAll();
		}else {
			throw new DataNotFoundExceptionResolver("No Data Found");
		}
	}
	

	/**
	 * @Service - Save Patient Information
	 *
	 */
	@Override
	public ResponseInfo savePatientInfo(PatientInfo patientInfo) {
		if(patientInfo.getName().equals("") || patientInfo.getDoctorId().equals("") || patientInfo.getAge().equals("") || patientInfo.getGender().equals("") || patientInfo.getAddress().equals("") || patientInfo.getContact().equals("") || patientInfo.getHistory().equals("")) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}else {
			try {
				patientInfo.setLastVisited(new Date());
				patientDao.save(patientInfo);
				ResponseInfo response = new ResponseInfo();
				response.setMessage("SUCCESS");
				return response;
			} catch(DataIntegrityViolationException e) {
				throw new DataIntegrityExceptionResolver("Key Constraint Exception. Unable to add patient");
			}
		}
	}
	
	/**
	 * @Service - Update Patient Information
	 *
	 */
	@Override
	public List<PatientInfo> updatePatientInfo(PatientInfo patientInfo) {
		if(patientInfo.getId().equals("") || patientInfo.getName().equals("") || patientInfo.getDoctorId().equals("") || patientInfo.getAge().equals("") || patientInfo.getGender().equals("") || patientInfo.getAddress().equals("") || patientInfo.getContact().equals("") || patientInfo.getHistory().equals("")) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}else {
			try {
				PatientInfo updateInfo = patientDao.findById(patientInfo.getId()).get();
				updateInfo.setName(patientInfo.getName());
				updateInfo.setDoctorId(patientInfo.getDoctorId());
				updateInfo.setAge(patientInfo.getAge());
				updateInfo.setGender(patientInfo.getGender());
				updateInfo.setAddress(patientInfo.getAddress());
				updateInfo.setContact(patientInfo.getContact());
				updateInfo.setHistory(patientInfo.getHistory());
				patientDao.save(patientInfo);
				LOG.info("Update Success");
				return getPatientInfo();
			}catch(NoSuchElementException e) {
				throw new NoSuchElementExceptionResolver("Element Not Found");
			}
		}
	}
	
	/**
	 * @Service - Delete Patient Information
	 *
	 */
	@Override
	public List<PatientInfo> deletePatientInfo(String id) {
		try {
			patientDao.deleteById(id);
			LOG.info("Delete Success");
			return getPatientInfo();
		}catch(EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessExceptionResolver("Expected data not found in Repository");
		}
	}
	
}
