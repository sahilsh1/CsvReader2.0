package com.csvreader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SampleInventory {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String code;
	private String name;
	private String batch;
	private int stock;
	private int deal;
	private int free;
	private double mrp;
	private String expDate;
	private String company;
	private String supplier;
	

	public SampleInventory(String code, String name, String batch, int stock, int deal, int free, double mrp,
			String expDate, String company,String supplier) {
		super();
		this.code = code;
		this.name = name;
		this.batch = batch;
		this.stock = stock;
		this.deal = deal;
		this.free = free;
		this.mrp = mrp;
		this.expDate = expDate;
		this.company = company;
		this.supplier=supplier;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	

	@Override
	public String toString() {
		return "SampleInventory [code=" + code + ", name=" + name + ", batch=" + batch + ", stock=" + stock + ", deal="
				+ deal + ", free=" + free + ", mrp=" + mrp + ", expDate=" + expDate + ", company=" + company + "]";
	}
	
	
	
	
}
