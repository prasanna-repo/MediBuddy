package com.medibuddy.service.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.medibuddy.dao.PatientDao;
import com.medibuddy.model.PatientInfo;
import com.medibuddy.service.PatientServiceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientServiceImplementationTest {
	
	@Mock
	PatientDao patientDao;
	
	@InjectMocks
	PatientServiceImplementation patientServiceImplmentation;
	
	@Test
	void getPatientInfo() {
		List<PatientInfo> patientInfoList = new ArrayList<>();
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setId("1");
		patientInfo.setName("David");
		patientInfo.setDoctorId("1");
		patientInfo.setAge("28");
		patientInfo.setGender("M");
		patientInfo.setAddress("Florida");
		patientInfo.setContact("9858263726");
		patientInfo.setHistory("Next week");
		patientInfo.setLastVisited(new Date());
		patientInfoList.add(patientInfo);
		doReturn(1L).when(patientDao).count();
		doReturn(patientInfoList).when(patientDao).findAll();
		assertEquals("David", patientServiceImplmentation.getPatientInfo().get(0).getName());
	}
	
	@Test
	void savePatientInfo() {
		List<PatientInfo> patientInfoList = new ArrayList<>();
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setId("1");
		patientInfo.setName("David");
		patientInfo.setDoctorId("1");
		patientInfo.setAge("28");
		patientInfo.setGender("M");
		patientInfo.setAddress("Florida");
		patientInfo.setContact("9858263726");
		patientInfo.setHistory("Next week");
		patientInfo.setLastVisited(new Date());
		patientInfoList.add(patientInfo);
		doReturn(patientInfo).when(patientDao).save(Mockito.any(PatientInfo.class));
		doReturn(1L).when(patientDao).count();
		doReturn(patientInfoList).when(patientDao).findAll();
		assertEquals(1, patientServiceImplmentation.getPatientInfo().size());
	}
	
	@Test
	void deletePatientInfo() {
		List<PatientInfo> patientInfoList = new ArrayList<>();
		PatientInfo patientInfo = new PatientInfo();
		patientInfo.setId("1");
		patientInfo.setName("David");
		patientInfo.setDoctorId("1");
		patientInfo.setAge("28");
		patientInfo.setGender("M");
		patientInfo.setAddress("Florida");
		patientInfo.setContact("9858263726");
		patientInfo.setHistory("Next week");
		patientInfo.setLastVisited(new Date());
		patientInfoList.add(patientInfo);
		doNothing().when(patientDao).deleteById("1");
		doReturn(1L).when(patientDao).count();
		assertEquals(0, patientServiceImplmentation.getPatientInfo().size());
	}
	
}
