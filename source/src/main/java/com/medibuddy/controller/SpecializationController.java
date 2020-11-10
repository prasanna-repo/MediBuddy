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

import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.model.SpecializationInfo;
import com.medibuddy.service.SpecializationService;

/**
 * @author Prasanna
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/specialization")
public class SpecializationController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	SpecializationService specializationService;
	
	
	/**
	 * @Controller - Get Specialization Information
	 *
	 */
	@RequestMapping(value = "/getSpecializationInfo", method = RequestMethod.GET)
	public List<SpecializationInfo> getSpecializationInfo(){
		LOG.info("Getting Specialization Info!!!");
		return specializationService.getSpecializationInfo();
	}
	
	/**
	 * @Controller - Save Specialization Information
	 *
	 */
	@RequestMapping(value = "/saveSpecializationInfo", method = RequestMethod.POST)
	public ResponseInfo saveSpecializationInfo(@RequestBody SpecializationInfo specializationInfo){
		LOG.info("Saving Specialization Info!!!");
		return specializationService.saveSpecializationInfo(specializationInfo);
	}
	
	/**
	 * @Controller - Update Specialization Information
	 *
	 */
	@RequestMapping(value = "/updateSpecializationInfo", method = RequestMethod.POST)
	private List<SpecializationInfo> updateSpecializationInfo(@RequestBody SpecializationInfo specializationInfo){
		LOG.info("Updating Specialization Info!!!");
		return specializationService.updateSpecializationInfo(specializationInfo);
	}
	
	/**
	 * @Controller - Delete Specialization Information
	 *
	 */
	@RequestMapping(value = "/deleteSpecializationInfo", method = RequestMethod.GET)
	private List<SpecializationInfo> deleteSpecializationInfo(@RequestParam("id") String id){
		LOG.info("Deleting Specialization Info!!!");
		return specializationService.deleteSpecializationInfo(id);
	}

}