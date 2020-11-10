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
import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.service.PatientService;
/**
 * @author Prasanna
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/patient")
public class PatientController {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	PatientService patientService;
	
	/**
	 * @Controller - Get Patient Information
	 *
	 */
	@RequestMapping(value = "/getPatientInfo", method = RequestMethod.GET)
	public List<PatientInfo> getPatientInfo(){
		LOG.info("Getting Patient Info!!!");
		return patientService.getPatientInfo();
	}
	
	/**
	 * @Controller - Save Patient Information
	 *
	 */
	@RequestMapping(value = "/savePatientInfo", method = RequestMethod.POST)
	public ResponseInfo savePatientInfo(@RequestBody PatientInfo patientInfo){
		LOG.info("Saving Patient Info!!!");
		return patientService.savePatientInfo(patientInfo);
	}
	
	/**
	 * @Controller - Update Patient Information
	 *
	 */
	@RequestMapping(value = "/updatePatientInfo", method = RequestMethod.POST)
	private List<PatientInfo> updatePatientInfo(@RequestBody PatientInfo patientInfo){
		LOG.info("Updating Patient Info!!!");
		return patientService.updatePatientInfo(patientInfo);
	}
	
	/**
	 * @Controller - Delete Patient Information
	 *
	 */
	@RequestMapping(value = "/deletePatientInfo", method = RequestMethod.GET)
	private List<PatientInfo> deletePatientInfo(@RequestParam("id") String id){
		LOG.info("Deleting Patient Info!!!");
		return patientService.deletePatientInfo(id);
	}

}
