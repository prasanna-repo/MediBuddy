package com.medibuddy.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.medibuddy.dao.SpecializationDao;
import com.medibuddy.exception.resolver.DataNotFoundExceptionResolver;
import com.medibuddy.exception.resolver.EmptyResultDataAccessExceptionResolver;
import com.medibuddy.exception.resolver.NoSuchElementExceptionResolver;
import com.medibuddy.exception.resolver.NullPointerExceptionResolver;
import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.model.SpecializationInfo;

/**
 * @author Prasanna
 *
 */
@Service
public class SpecializationServiceImplementation implements SpecializationService {
	
	@Autowired
	SpecializationDao specializationDao;

	/**
	 * @Service - Get Specialization Information
	 *
	 */
	@Override
	public List<SpecializationInfo> getSpecializationInfo() {
		if(specializationDao.count() > 0) {
			return (List<SpecializationInfo>) specializationDao.findAll();
		}else {
			throw new DataNotFoundExceptionResolver("No Data Found");
		}
	}
	

	/**
	 * @Service - Save Specialization Information
	 *
	 */
	@Override
	public ResponseInfo saveSpecializationInfo(SpecializationInfo specializationInfo) {
		if(specializationInfo.getName().equals("") || specializationInfo.getDescription().equals("")) {
			throw new NullPointerExceptionResolver("Missing Parameters");
		}else {
			specializationDao.save(specializationInfo);
			ResponseInfo response = new ResponseInfo();
			response.setMessage("SUCCESS");
			return response;
		}

	}
	
	/**
	 * @Service - Update Specialization Information
	 *
	 */
	@Override
	public List<SpecializationInfo> updateSpecializationInfo(SpecializationInfo specializationInfo) {
		try {
			if(specializationInfo.getId ().equals("") || specializationInfo.getName().equals("") || specializationInfo.getDescription().equals("")) {
				throw new NullPointerExceptionResolver("Missing Parameters");
			}else {
				try {
					SpecializationInfo updateInfo = specializationDao.findById(specializationInfo.getId()).get();
					updateInfo.setName(specializationInfo.getName());
					updateInfo.setDescription(specializationInfo.getDescription());
					specializationDao.save(specializationInfo);
					return getSpecializationInfo();
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
	 * @Service - Delete Specialization Information
	 *
	 */
	@Override
	public List<SpecializationInfo> deleteSpecializationInfo(String id) {
		try {
			specializationDao.deleteById(id);
			return getSpecializationInfo();
		}catch(EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessExceptionResolver("Expected data not found in Repository");
		}
	}
	
}
