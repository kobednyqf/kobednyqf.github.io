package com.model;

public class Store {
	private String store_id;
	private String medicine_id;
	private String number;
	private String place;
	private String active_time;
	private String inactive_time;
	private String price;
	private String status;
	private String medicine_name;
	private String medicine_detail;
	public Store(String store_id, String medicine_id, String number,
			String place, String active_time, String inactive_time,
			String price, String status, String medicine_name,
			String medicine_detail) {
		super();
		this.store_id = store_id;
		this.medicine_id = medicine_id;
		this.number = number;
		this.place = place;
		this.active_time = active_time;
		this.inactive_time = inactive_time;
		this.price = price;
		this.status = status;
		this.medicine_name = medicine_name;
		this.medicine_detail = medicine_detail;
	}
	public Store() {
		super();
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getActive_time() {
		return active_time;
	}
	public void setActive_time(String active_time) {
		this.active_time = active_time;
	}
	public String getInactive_time() {
		return inactive_time;
	}
	public void setInactive_time(String inactive_time) {
		this.inactive_time = inactive_time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getMedicine_detail() {
		return medicine_detail;
	}
	public void setMedicine_detail(String medicine_detail) {
		this.medicine_detail = medicine_detail;
	}
	 
}
