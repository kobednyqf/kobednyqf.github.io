package com.model;
//变量私有，函数公有，只能通过函数间接修改私有变量
public class Medicine {
	private String medicine_id; 
	private String medicine_name;
	private String medicine_detail;
	private String medicine_cata;
	
	
	//	在视图调用过
	public String getMedicine_id() {
		return medicine_id;
	}
	//在控制器中使用过
	public void setMedicine_id(String medicine_id) {
		this.medicine_id = medicine_id;
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
	public String getMedicine_cata() {
		return medicine_cata;
	}
	public void setMedicine_cata(String medicine_cata) {
		this.medicine_cata = medicine_cata;
	}
	//药的重写
	public Medicine(String medicine_id, String medicine_name,
			String medicine_detail, String medicine_cata) {
		super();//从父类初始化
		this.medicine_id = medicine_id;
		this.medicine_name = medicine_name;
		this.medicine_detail = medicine_detail;
		this.medicine_cata = medicine_cata;
	}
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
	
	
}
