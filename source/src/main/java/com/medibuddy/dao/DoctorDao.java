package com.medibuddy.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.medibuddy.model.DoctorInfo;

/**
 * @author Prasanna
 *
 */
public interface DoctorDao extends CrudRepository<DoctorInfo, String>{
	List<DoctorInfo> getDoctorInfoBySpecializationId(String specializationId);
}
