package com.csvreader.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csvreader.helper.CSVHelper;
import com.csvreader.model.SampleInventory;
import com.csvreader.repository.SampleInventoryRepository;

@Service
public class CSVService {

	@Autowired
	private SampleInventoryRepository repository;
	
	//private String product;
	
	public void save(MultipartFile file) {
		
		try {
		      List<SampleInventory> SampleInventorys = CSVHelper.csvToSampleInventorys(file.getInputStream());
		      repository.saveAll(SampleInventorys);
		    }
		catch (IOException e) {
		      throw new RuntimeException("fail to store csv data: " + e.getMessage());
		    }
		
	}

	public List<SampleInventory> getAllSamples() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}

	public List<String> findBySupplier(String name) {
		// TODO Auto-generated method stub
		return repository.findBySupplier(name);
	}
	
	public List<String> findBySupplierProductNotExpired(String name){
		
		return findBySupplierProductNotExpired(name);
	}

	
}
