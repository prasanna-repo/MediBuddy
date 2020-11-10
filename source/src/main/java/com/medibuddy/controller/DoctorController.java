package com.medibuddy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medibuddy.model.DoctorInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.service.DoctorService;

/**
 * @author Prasanna
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	DoctorService doctorService;
	
	/**
	 * @Controller - Get Doctor Information
	 *
	 */
	@RequestMapping(value = "/getDoctorInfo", method = RequestMethod.GET)
	private List<DoctorInfo> getDoctorInfo(){
		LOG.info("Getting Doctor Info!!!");
		return doctorService.getDoctorInfo();
	}
	
	/**
	 * @Controller - Save Doctor Information
	 *
	 */
	@RequestMapping(value = "/saveDoctorInfo", method = RequestMethod.POST)
	private ResponseInfo getDoctorInfo(@RequestBody DoctorInfo doctorInfo){
		LOG.info("Saving Doctor Info!!!");
		return doctorService.saveDoctorInfo(doctorInfo);
	}
	
	/**
	 * @Controller - Update Doctor Information
	 *
	 */
	@RequestMapping(value = "/updateDoctorInfo", method = RequestMethod.POST)
	private List<DoctorInfo> updateDoctorInfo(@RequestBody DoctorInfo doctorInfo){
		LOG.info("Updating Doctor Info!!!");
		return doctorService.updateDoctorInfo(doctorInfo);
	}
	
	/**
	 * @Controller - Delete Doctor Information
	 *
	 */
	@RequestMapping(value = "/deleteDoctorInfo", method = RequestMethod.GET)
	private List<DoctorInfo> deleteDoctorInfo(@RequestParam("id") String id){
		LOG.info("Deleting Doctor Info!!!");
		return doctorService.deleteDoctorInfo(id);
	}
	
	/**
	 * @Controller - Get Doctor Information By Specialization
	 *
	 */
	@RequestMapping(value = "/getDoctorInfoBySpecialization", method = RequestMethod.GET)
	private List<DoctorInfo> getDoctorInfoBySpecialization(@RequestParam("specializationId") String specializationId){
		LOG.info("Getting Doctor Info by Specialization!!!");
		return doctorService.getDoctorInfoBySpecialization(specializationId);
	}
	
	

}
