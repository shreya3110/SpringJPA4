package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Coder;

//@Repository
public interface CoderRepository extends JpaRepository<Coder, Integer>
{
	public Coder getCoderByCname(String cname);
	
	@Query("select c from Coder c where tech=?1 order by cname")
	public List<Coder> getCoderByTechSorted(String tech);
}