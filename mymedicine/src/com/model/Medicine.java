package com.model;
//����˽�У��������У�ֻ��ͨ����������޸�˽�б���
public class Medicine {
	private String medicine_id; 
	private String medicine_name;
	private String medicine_detail;
	private String medicine_cata;
	
	
	//	����ͼ���ù�
	public String getMedicine_id() {
		return medicine_id;
	}
	//�ڿ�������ʹ�ù�
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
	//ҩ����д
	public Medicine(String medicine_id, String medicine_name,
			String medicine_detail, String medicine_cata) {
		super();//�Ӹ����ʼ��
		this.medicine_id = medicine_id;
		this.medicine_name = medicine_name;
		this.medicine_detail = medicine_detail;
		this.medicine_cata = medicine_cata;
	}
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
	
	
}
