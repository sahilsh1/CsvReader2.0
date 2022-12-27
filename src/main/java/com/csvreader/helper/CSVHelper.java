package com.csvreader.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.csvreader.model.SampleInventory;

import org.apache.commons.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVHelper {
		  public static String TYPE = "text/csv";
		  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

		  public static boolean hasCSVFormat(MultipartFile file) {

		    if (!TYPE.equals(file.getContentType())) {
		      return false;
		    }

		    return true;
		  }

		  public static List<SampleInventory> csvToSampleInventorys(InputStream is) {
		    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		        CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

		      List<SampleInventory> SampleInventorys = new ArrayList<SampleInventory>();

		      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

		      for (CSVRecord csvRecord : csvRecords) {
		        SampleInventory SampleInventory = new SampleInventory(
		              csvRecord.get("code"),
		              csvRecord.get("name"),
		              csvRecord.get("batch"),
		              Integer.parseInt(csvRecord.get("stock")),
		              Integer.parseInt(csvRecord.get("deal")),
		              Integer.parseInt(csvRecord.get("free")),
		              Double.parseDouble(csvRecord.get("mrp")),
		              csvRecord.get("expDate"),
		              csvRecord.get("company"),
		              csvRecord.get("supplier")
		            );
		        
		        SampleInventorys.add(SampleInventory);
		      }

		      return SampleInventorys;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		    }
		  }

}

