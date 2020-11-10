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
import com.medibuddy.controller.PatientController;
import com.medibuddy.model.PatientInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.service.PatientServiceImplementation;

@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	PatientServiceImplementation patientServiceImplementation;
	
	@InjectMocks
	PatientController patientController;
	
	public static final MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Test
	void getPatientInfo() throws Exception {
		List<PatientInfo> patientInfo = new ArrayList<>();
		doReturn(patientInfo).when(patientServiceImplementation).getPatientInfo();
		mockMvc.perform(get("/patient/getPatientInfo")).andExpect(status().isOk());
	}
	
	@Test
	void savePatientInfo() throws Exception {
		PatientInfo patientInfo = new PatientInfo();
		ResponseInfo responseInfo = new ResponseInfo();
		patientInfo.setName("David");
		patientInfo.setDoctorId("1");
		patientInfo.setAge("28");
		patientInfo.setGender("M");
		patientInfo.setAddress("Florida");
		patientInfo.setContact("9858263726");
		patientInfo.setHistory("Next week");
		patientInfo.setLastVisited(new Date());
		doReturn(responseInfo).when(patientServiceImplementation).savePatientInfo(Mockito.any(PatientInfo.class));
		mockMvc.perform(post("/patient/savePatientInfo").contentType(mediaType).content(jsonConverter(patientInfo))).andExpect(status().isOk());
	}
	
	@Test
	void updatePatientInfo() throws Exception {
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
		doReturn(patientInfoList).when(patientServiceImplementation).updatePatientInfo(Mockito.any(PatientInfo.class));
		mockMvc.perform(post("/patient/updatePatientInfo").contentType(mediaType).content(jsonConverter(patientInfo))).andExpect(status().isOk());
	}
	
	@Test
	void deletePatientInfo() throws Exception {
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
		patientInfoList.add(patientInfo);
		doReturn(patientInfoList).when(patientServiceImplementation).deletePatientInfo("1");
		mockMvc.perform(get("/patient/deletePatientInfo?id=/{id}", 1L)).andExpect(status().isOk());
	}
	
	
	byte[] jsonConverter(Object patientData) throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		return objMap.writeValueAsBytes(patientData);
	}
		
	
}
