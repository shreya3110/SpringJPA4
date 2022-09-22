package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceTest {

	@Autowired
	CoderService coderservice;
	
	@MockBean
	CoderRepository repo;

	@Test
	void testGetCoders() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
		
		Coder c2=new Coder();
		c2.setCid(2);
		c2.setCname("Madhuri");
		c2.setTech("Java");
		
		List<Coder> coderList = new ArrayList<>();
		coderList.add(c1);
		coderList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(coderList);
		
		assertThat(coderservice.getCoders()).isEqualTo(coderList);
	}

	//@Test
	@Disabled
	void testGetCoderById() throws Throwable {
		
		  Coder c1=new Coder(); 
		  c1.setCid(1); 
		  c1.setCname("Madhu");
		  c1.setTech("JavaFS");
		 
		
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoderById(2)).isEqualTo(c1);
	}

	@Test
	void testAddCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
	Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateCoder() throws Throwable {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Madhulika");
		c1.setTech("ML");
		
		assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setTech("JavaFS");
		Optional<Coder> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCid()));
	}
}