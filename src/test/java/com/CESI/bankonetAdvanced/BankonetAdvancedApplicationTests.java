//package com.CESI.accessingdatamysql.Controller;
package main.java.com.CESI.accessingdatamysql.Controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


//@ExtendWith(SpringExtension.class)
//@SpringBootTest

//@WebMvcTest(bankonetAdvanced.class)

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class BankonetAdvancedApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getToto() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk())
//		.andExpect(content().string(equalTo("toto")));
		mvc.perform(MockMvcRequestBuilders.get("/toto"))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("toto")));
	}

}
