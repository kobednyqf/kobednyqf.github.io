package com.model;

public class Sale {
	private String sale_id ;
	private String store_id;
	private String number;
	private String price;
	private String create_time;
	private String medicine_name;
	private String medicine_cata;
	public String getSale_id() {
		return sale_id;
	}
	public void setSale_id(String sale_id) {
		this.sale_id = sale_id;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getMedicine_cata() {
		return medicine_cata;
	}
	public void setMedicine_cata(String medicine_cata) {
		this.medicine_cata = medicine_cata;
	}
	public Sale() {
		super();
	}
 	 
	
}
