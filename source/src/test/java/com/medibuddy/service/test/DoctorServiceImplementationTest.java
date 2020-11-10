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

import com.medibuddy.dao.DoctorDao;
import com.medibuddy.model.DoctorInfo;
import com.medibuddy.service.DoctorServiceImplementation;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DoctorServiceImplementationTest {
	
	@Mock
	DoctorDao doctorDao;
	
	@InjectMocks
	DoctorServiceImplementation doctorServiceImplmentation;
	
	@Test
	void getDoctorInfo() {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setId("1");
		doctorInfo.setName("Xavier");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doReturn(1L).when(doctorDao).count();
		doReturn(doctorInfoList).when(doctorDao).findAll();
		assertEquals("Xavier", doctorServiceImplmentation.getDoctorInfo().get(0).getName());
	}
	
	@Test
	void saveDoctorInfo() {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setId("1");
		doctorInfo.setName("Xavier");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doReturn(doctorInfo).when(doctorDao).save(Mockito.any(DoctorInfo.class));
		doReturn(1L).when(doctorDao).count();
		doReturn(doctorInfoList).when(doctorDao).findAll();
		assertEquals(1, doctorServiceImplmentation.getDoctorInfo().size());
	}
	
	@Test
	void deleteDoctorInfo() {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setId("1");
		doctorInfo.setName("Xavier");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doNothing().when(doctorDao).deleteById("1");
		doReturn(1L).when(doctorDao).count();
		assertEquals(0, doctorServiceImplmentation.getDoctorInfo().size());
	}
	
	
	@Test
	void getDoctorInfoBySpecialization() {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setId("1");
		doctorInfo.setName("Xavier");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doReturn(1L).when(doctorDao).count();
		doReturn(doctorInfoList).when(doctorDao).findAll();
		doReturn(doctorInfoList).when(doctorDao).getDoctorInfoBySpecializationId("1");
		assertEquals("Xavier", doctorServiceImplmentation.getDoctorInfo().get(0).getName());
	}
	
}
