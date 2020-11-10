package com.medibuddy.service;

import java.util.List;

import com.medibuddy.model.ResponseInfo;
import com.medibuddy.model.SpecializationInfo;

/**
 * @author Prasanna
 *
 */
public interface SpecializationService {

	List<SpecializationInfo> getSpecializationInfo();

	ResponseInfo saveSpecializationInfo(SpecializationInfo specializationInfo);
	
	List<SpecializationInfo> updateSpecializationInfo(SpecializationInfo specializationInfo);
	
	List<SpecializationInfo> deleteSpecializationInfo(String id);

}