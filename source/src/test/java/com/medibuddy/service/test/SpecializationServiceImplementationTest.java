package com.medibuddy.service.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.medibuddy.dao.SpecializationDao;
import com.medibuddy.model.SpecializationInfo;
import com.medibuddy.service.SpecializationServiceImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SpecializationServiceImplementationTest {
	
	@Mock
	SpecializationDao specializationDao;
	
	@InjectMocks
	SpecializationServiceImplementation specializationServiceImplmentation;
	
	@Test
	void getSpecializationInfo() {
		List<SpecializationInfo> specializationInfoList = new ArrayList<>();
		SpecializationInfo specializationInfo = new SpecializationInfo();
		specializationInfo.setId("1");
		specializationInfo.setName("Cardiology");
		specializationInfo.setDescription("Heart related symptoms and issues");
		specializationInfoList.add(specializationInfo);
		doReturn(1L).when(specializationDao).count();
		doReturn(specializationInfoList).when(specializationDao).findAll();
		assertEquals("Cardiology", specializationServiceImplmentation.getSpecializationInfo().get(0).getName());
	}
	
	@Test
	void saveSpecializationInfo() {
		List<SpecializationInfo> specializationInfoList = new ArrayList<>();
		SpecializationInfo specializationInfo = new SpecializationInfo();
		specializationInfo.setId("1");
		specializationInfo.setName("Cardiology");
		specializationInfo.setDescription("Heart related symptoms and issues");
		specializationInfoList.add(specializationInfo);
		doReturn(specializationInfo).when(specializationDao).save(Mockito.any(SpecializationInfo.class));
		doReturn(1L).when(specializationDao).count();
		doReturn(specializationInfoList).when(specializationDao).findAll();
		assertEquals(1, specializationServiceImplmentation.getSpecializationInfo().size());
	}
	
	@Test
	void deleteSpecializationInfo() {
		List<SpecializationInfo> specializationInfoList = new ArrayList<>();
		SpecializationInfo specializationInfo = new SpecializationInfo();
		specializationInfo.setId("1");
		specializationInfo.setName("Cardiology");
		specializationInfo.setDescription("Heart related symptoms and issues");
		specializationInfoList.add(specializationInfo);
		doNothing().when(specializationDao).deleteById("1");
		doReturn(1L).when(specializationDao).count();
		assertEquals(0, specializationServiceImplmentation.getSpecializationInfo().size());
	}
	
}
