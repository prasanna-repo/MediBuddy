package com.medibuddy.service;

import java.util.List;

import com.medibuddy.model.DoctorInfo;
import com.medibuddy.model.ResponseInfo;

/**
 * @author Prasanna
 *
 */
public interface DoctorService {

	List<DoctorInfo> getDoctorInfo();

	ResponseInfo saveDoctorInfo(DoctorInfo doctorInfo);
	
	List<DoctorInfo> updateDoctorInfo(DoctorInfo doctorInfo);
	
	List<DoctorInfo> getDoctorInfoBySpecialization(String specializationId);
	
	List<DoctorInfo> deleteDoctorInfo(String id);

}