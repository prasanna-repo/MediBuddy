package com.medibuddy.controller.test;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
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
import com.medibuddy.controller.SpecializationController;
import com.medibuddy.model.SpecializationInfo;
import com.medibuddy.model.ResponseInfo;
import com.medibuddy.service.SpecializationServiceImplementation;

@WebMvcTest(controllers = SpecializationController.class)
public class SpecializationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	SpecializationServiceImplementation specializationServiceImplementation;
	
	@InjectMocks
	SpecializationController specializationController;
	
	public static final MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	@Test
	void getSpecializationInfo() throws Exception {
		List<SpecializationInfo> specializationInfo = new ArrayList<>();
		doReturn(specializationInfo).when(specializationServiceImplementation).getSpecializationInfo();
		mockMvc.perform(get("/specialization/getSpecializationInfo")).andExpect(status().isOk());
	}
	
	@Test
	void saveSpecializationInfo() throws Exception {
		SpecializationInfo specializationInfo = new SpecializationInfo();
		ResponseInfo responseInfo = new ResponseInfo();
		specializationInfo.setName("Cardiology");
		doReturn(responseInfo).when(specializationServiceImplementation).saveSpecializationInfo(Mockito.any(SpecializationInfo.class));
		mockMvc.perform(post("/specialization/saveSpecializationInfo").contentType(mediaType).content(jsonConverter(specializationInfo))).andExpect(status().isOk());
	}
	
	@Test
	void updateSpecializationInfo() throws Exception {
		List<SpecializationInfo> specializationInfoList = new ArrayList<>();
		SpecializationInfo specializationInfo = new SpecializationInfo();
		specializationInfo.setId("1");
		specializationInfo.setName("Cardiology");
		specializationInfoList.add(specializationInfo);
		doReturn(specializationInfoList).when(specializationServiceImplementation).updateSpecializationInfo(Mockito.any(SpecializationInfo.class));
		mockMvc.perform(post("/specialization/updateSpecializationInfo").contentType(mediaType).content(jsonConverter(specializationInfo))).andExpect(status().isOk());
	}
	
	@Test
	void deleteSpecializationInfo() throws Exception {
		List<SpecializationInfo> specializationInfoList = new ArrayList<>();
		SpecializationInfo specializationInfo = new SpecializationInfo();
		specializationInfo.setId("1");
		specializationInfo.setName("Cardiology");
		specializationInfoList.add(specializationInfo);
		doReturn(specializationInfoList).when(specializationServiceImplementation).deleteSpecializationInfo("1");
		mockMvc.perform(get("/specialization/deleteSpecializationInfo?id=/{id}", 1L)).andExpect(status().isOk());
	}
	
	
	byte[] jsonConverter(Object specializationData) throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		return objMap.writeValueAsBytes(specializationData);
	}
		
	
}
