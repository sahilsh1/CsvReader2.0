package com.csvreader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.csvreader.model.SampleInventory;

import org.springframework.data.jpa.repository.Query;


@Repository
public interface SampleInventoryRepository extends JpaRepository<SampleInventory,Integer> {

 

	@Query("Select name from SampleInventory s where s.supplier=?1 and s.stock>0")
	List<String> findBySupplier(String name);

	@Query("Select name from SampleInventory s where s.supplier=?1 and s.>0")
	List<String> findBySupplierNotExpired(String name);
	
	@Query("Select name from SampleInventory s where s.supplier=?1 and s.date")
	List<String> findBySupplierProductNotExpired(String name);
	
	
}
