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
import com.medibuddy.dao.DoctorDao;
import com.medibuddy.exception.resolver.DataNotFoundExceptionResolver;
import com.medibuddy.exception.resolver.EmptyResultDataAccessExceptionResolver;
import com.medibuddy.exception.resolver.NoSuchElementExceptionResolver;
import com.medibuddy.exception.resolver.DataIntegrityExceptionResolver;
import com.medibuddy.exception.resolver.NullPointerExceptionResolver;
import com.medibuddy.model.DoctorInfo;
import com.medibuddy.model.ResponseInfo;

/**
 * @author Prasanna
 *
 */
@Service
public class DoctorServiceImplementation implements DoctorService {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorDao doctorDao;
	
	/**
	 * @Service - Get Doctor Information
	 *
	 */
	@Override
	public List<DoctorInfo> getDoctorInfo() {
		if(doctorDao.count() > 0) {
			return (List<DoctorInfo>) doctorDao.findAll();
		}else {
			throw new DataNotFoundExceptionResolver("No Data Found");
		}
	}
	
	/**
	 * @Service - Save Doctor Information
	 *
	 */
	@Override
	public ResponseInfo saveDoctorInfo(DoctorInfo doctorInfo) {
		if(doctorInfo.getName().equals("") || doctorInfo.getSpecializationId().equals("") || doctorInfo.getGender().equals("") || doctorInfo.getAddress().equals("") || doctorInfo.getContact().equals("")) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}else {
			try {
				doctorInfo.setJoinedOn(new Date());
				doctorDao.save(doctorInfo);
				ResponseInfo response = new ResponseInfo();
				response.setMessage("SUCCESS");
				return response;
			}catch(DataIntegrityViolationException e) {
				throw new DataIntegrityExceptionResolver("Key Constraint Exception. Unable to add Doctor");
			}

		}
	}
	
	/**
	 * @Service - Update Doctor Information
	 *
	 */
	@Override
	public List<DoctorInfo> updateDoctorInfo(DoctorInfo doctorInfo) {
		try {
			if(doctorInfo.getId().equals("") || doctorInfo.getName().equals("") || doctorInfo.getSpecializationId().equals("") || doctorInfo.getGender().equals("") || doctorInfo.getAddress().equals("") || doctorInfo.getContact().equals("")) {
				throw new NullPointerExceptionResolver("Missing Parameters");
			}else {
				try {
					DoctorInfo updateInfo = doctorDao.findById(doctorInfo.getId()).get();
					updateInfo.setName(doctorInfo.getName());
					updateInfo.setSpecializationId(doctorInfo.getSpecializationId());
					updateInfo.setGender(doctorInfo.getGender());
					updateInfo.setAddress(doctorInfo.getAddress());
					updateInfo.setContact(doctorInfo.getContact());
					doctorDao.save(doctorInfo);
					LOG.info("Update Success");
					return getDoctorInfo();
				}catch(NoSuchElementException e) {
					throw new NoSuchElementExceptionResolver("Element Not Found");
				}
			}
		}
		catch(NullPointerException e) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}
	}
	
	/**
	 * @Service - Get Doctor Information by Specialization
	 *
	 */
	@Override
	public List<DoctorInfo> getDoctorInfoBySpecialization(String specializationId) {
		if(specializationId.equals("")) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}else {
			List<DoctorInfo> doctorInfoBySpecialization = doctorDao.getDoctorInfoBySpecializationId(specializationId);
			if(doctorInfoBySpecialization.size() > 0) {
				return (List<DoctorInfo>) doctorDao.getDoctorInfoBySpecializationId(specializationId);
			}else {
				throw new DataNotFoundExceptionResolver("No Data Found");
			}
		}
	}
	
	/**
	 * @Service - Delete Doctor Information
	 *
	 */
	@Override
	public List<DoctorInfo> deleteDoctorInfo(String id) {
		try {
			doctorDao.deleteById(id);
			LOG.info("Delete Success");
			return getDoctorInfo();	
		}catch(EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessExceptionResolver("Expected data not found in Repository");
		}

	}
	
}
