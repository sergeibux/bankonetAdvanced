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



@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class BankonetAdvancedApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getToto() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/toto"))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("toto")));
	}

	@Test
	public void getClient() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/client/toString?id=0"))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Client [IdClient=0, Nom=me, Prenom=myself]")));
	}

	@Test
	public void getCompteCourant() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/compteCourant/toString?id=0"))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("[CompteCourant [IdComteCourant=0, montantDecouvertAutorise=0.0], CompteCourant [IdComteCourant=0, montantDecouvertAutorise=0.0], CompteCourant [IdComteCourant=0, montantDecouvertAutorise=0.0], CompteCourant [IdComteCourant=0, montantDecouvertAutorise=0.0], CompteCourant [IdComteCourant=0, montantDecouvertAutorise=0.0]]")));
	}
	

}
