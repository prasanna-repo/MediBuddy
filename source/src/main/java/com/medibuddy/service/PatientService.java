package com.medibuddy.service;

import java.util.List;

import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;

/**
 * @author Prasanna
 *
 */
public interface PatientService {

	List<PatientInfo> getPatientInfo();

	ResponseInfo savePatientInfo(PatientInfo patientInfo);
	
	List<PatientInfo> updatePatientInfo(PatientInfo patientInfo);
	
	List<PatientInfo> deletePatientInfo(String id);

}