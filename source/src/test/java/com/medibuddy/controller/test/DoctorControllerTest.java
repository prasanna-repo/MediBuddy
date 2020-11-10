package com.medibuddy.controller.test;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medibuddy.controller.DoctorController;
import com.medibuddy.model.DoctorInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.service.DoctorServiceImplementation;

@WebMvcTest(controllers = DoctorController.class)
public class DoctorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DoctorServiceImplementation doctorServiceImplementation;
	
	@InjectMocks
	DoctorController doctorController;
	
	public static final MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Test
	void getDoctorInfo() throws Exception {
		List<DoctorInfo> doctorInfo = new ArrayList<>();
		doReturn(doctorInfo).when(doctorServiceImplementation).getDoctorInfo();
		mockMvc.perform(get("/doctor/getDoctorInfo")).andExpect(status().isOk());
	}
	
	@Test
	void saveDoctorInfo() throws Exception {
		DoctorInfo doctorInfo = new DoctorInfo();
		ResponseInfo responseInfo = new ResponseInfo();
		doctorInfo.setName("Xavier");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doReturn(responseInfo).when(doctorServiceImplementation).saveDoctorInfo(Mockito.any(DoctorInfo.class));
		mockMvc.perform(post("/doctor/saveDoctorInfo").contentType(mediaType).content(jsonConverter(doctorInfo))).andExpect(status().isOk());
	}
	
	@Test
	void updateDoctorInfo() throws Exception {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setName("Michael");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doReturn(doctorInfoList).when(doctorServiceImplementation).updateDoctorInfo(Mockito.any(DoctorInfo.class));
		mockMvc.perform(post("/doctor/updateDoctorInfo").contentType(mediaType).content(jsonConverter(doctorInfo))).andExpect(status().isOk());
	}
	
	@Test
	void deleteDoctorInfo() throws Exception {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setName("Michael");
		doctorInfo.setSpecializationId("1");
		doctorInfo.setGender("M");
		doctorInfo.setAddress("Florida");
		doctorInfo.setContact("9858263726");
		doctorInfo.setJoinedOn(new Date());
		doctorInfoList.add(doctorInfo);
		doReturn(doctorInfoList).when(doctorServiceImplementation).deleteDoctorInfo(doctorInfo.getId());
		mockMvc.perform(get("/doctor/deleteDoctorInfo?id=/{id}", 1L)).andExpect(status().isOk());
	}
	
	@Test
	void getDoctorInfoBySpecialization() throws Exception {
		List<DoctorInfo> doctorInfoList = new ArrayList<>();
		DoctorInfo doctorInfo = new DoctorInfo();
		doctorInfo.setSpecializationId("1");
		doReturn(doctorInfoList).when(doctorServiceImplementation).getDoctorInfoBySpecialization(doctorInfo.getSpecializationId());
		mockMvc.perform(get("/doctor/getDoctorInfoBySpecialization?specializationId=/{specializationId}", "1")).andExpect(status().isOk());
	}
	
	byte[] jsonConverter(Object doctorData) throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		return objMap.writeValueAsBytes(doctorData);
	}
		
	
}
