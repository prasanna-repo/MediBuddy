package com.medibuddy.dao;

import org.springframework.data.repository.CrudRepository;

import com.medibuddy.model.PatientInfo;

/**
 * @author Prasanna
 *
 */
public interface PatientDao extends CrudRepository<PatientInfo, String>{

}
