package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.entity.Laptop;
import com.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	Log logger = LogFactory.getLog(CoderController.class);
	
	@Autowired
	CoderService coderservice;
	
	@GetMapping(path="getcoders")
	public List<Coder> getCoders()
	{
		List<Coder> lc=coderservice.getCoders();
		logger.info("Get Coders successfully");
		return lc;	
	}
	
	@GetMapping(path="getcoder/{cid}")
	public Coder getCoder(@PathVariable int cid) throws Throwable
	{
		Coder c=coderservice.getCoderById(cid);
		
		return c;	
	}
	
	@PostMapping("addcoder")
	public Coder addCoder(@RequestBody Coder c)
	{
		Coder c1=coderservice.addCoder(c);
		
		return c1;
		
	}
	
	@PostMapping("addcoders")
	public List<Coder> addCoders(@RequestBody List<Coder> lc)
	{
		List<Coder> lc1=coderservice.addCoders(lc);
		
		return lc1;	
	}
	
	@PutMapping(path="/c")
	public Coder updateCoder(@RequestBody Coder c) throws Throwable
	{
		Coder c1=coderservice.updateCoder(c);
		
	
		return c1;
	}
	
	@DeleteMapping(path="/deleteCoder")
	public ResponseEntity<String> deleteCoder(@RequestBody Coder e)
	{
		coderservice.deleteCoder(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoder/{eid}")
	public String deleteCoderById(@PathVariable int eid)
	{
		coderservice.deleteCoderById(eid);
		
		return "Deleted";
	}
	
	@GetMapping("getcoderbyname/{cname}")
	public Coder getCoderByCname(@PathVariable String cname)
	{
		Coder c2=coderservice.getCoderByCname(cname);
		return c2;
	}
	
	@GetMapping("getcoderbytech/{tech}")
	public List<Coder> getCoderByTechSorted(@PathVariable String tech)
	{
		List<Coder> lc=coderservice.getCoderByTechSorted(tech);
		return lc;
	}
	
	

}