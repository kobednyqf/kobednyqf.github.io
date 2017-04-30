package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DB;  
import com.model.Medicine;
import com.model.Sale;
import com.model.Store;
import com.model.User; 
 

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//ҳ���ȡ�������������봦��
		String command = req.getParameter("command"); 
		if(command!=null)
			command = new String(command.getBytes("ISO-8859-1"),"UTF-8"); 

		String medicine_id = req.getParameter("medicine_id"); 
		if(medicine_id!=null)
			medicine_id = new String(medicine_id.getBytes("ISO-8859-1"),"UTF-8"); 
		String medicine_name = req.getParameter("medicine_name"); 
		if(medicine_name!=null)
			medicine_name = new String(medicine_name.getBytes("ISO-8859-1"),"UTF-8"); 
		String medicine_detail = req.getParameter("medicine_detail"); 
		if(medicine_detail!=null)
			medicine_detail = new String(medicine_detail.getBytes("ISO-8859-1"),"UTF-8"); 
		String medicine_cata = req.getParameter("medicine_cata"); 
		if(medicine_cata!=null)
			medicine_cata = new String(medicine_cata.getBytes("ISO-8859-1"),"UTF-8"); 
		
		String store_id = req.getParameter("store_id"); 
		if(store_id!=null)
			store_id = new String(store_id.getBytes("ISO-8859-1"),"UTF-8"); 
		String number = req.getParameter("number"); 
		if(number!=null)
			number = new String(number.getBytes("ISO-8859-1"),"UTF-8"); 
		String place = req.getParameter("place"); 
		if(place!=null)
			place = new String(place.getBytes("ISO-8859-1"),"UTF-8"); 
		String active_time = req.getParameter("active_time"); 
		if(active_time!=null)
			active_time = new String(active_time.getBytes("ISO-8859-1"),"UTF-8"); 
		String inactive_time = req.getParameter("inactive_time"); 
		if(inactive_time!=null)
			inactive_time = new String(inactive_time.getBytes("ISO-8859-1"),"UTF-8"); 
		String price = req.getParameter("price"); 
		if(price!=null)
			price = new String(price.getBytes("ISO-8859-1"),"UTF-8"); 
		String status = req.getParameter("status"); 
		if(status!=null)
			status = new String(status.getBytes("ISO-8859-1"),"UTF-8"); 
		
		String sale_id = req.getParameter("sale_id"); 
		if(sale_id!=null)
			sale_id = new String(sale_id.getBytes("ISO-8859-1"),"UTF-8"); 
		String sale_price = req.getParameter("sale_price"); 
		if(sale_price!=null)
			sale_price = new String(sale_price.getBytes("ISO-8859-1"),"UTF-8"); 
		String create_time = req.getParameter("create_time"); 
		if(create_time!=null)
			create_time = new String(create_time.getBytes("ISO-8859-1"),"UTF-8"); 
		 

		DB db=new DB();
		//����ʵ���� 
		ArrayList<Medicine> medicineList = new ArrayList<Medicine>(); 
		ArrayList<Store> storeList = new ArrayList<Store>(); 
		ArrayList<Sale> saleList = new ArrayList<Sale>();
		
		 List temp=null; 
		 String sql="";
	    //����ҩƷ���
	    if(command.equals("add")){
	    	//�����ݿ����һ������ 
	    	sql="insert into medicine(medicine_name,medicine_detail,medicine_cata) values('"+medicine_name+"','"+medicine_detail+"','"+medicine_cata+"')";
	    	if(db.insertSQL(sql))
	    	 req.getRequestDispatcher("/success.jsp").forward(req, resp);//ִ�гɹ�ת���ɹ�����
			 else 
			req.getRequestDispatcher("/error.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ��� 
	    }
	    //ҩƷ������
	    if(command.equals("store")){ 
	    	//��ȡ����ҩƷ��¼
	    	sql ="select * from medicine ";
		    temp= (ArrayList<Medicine>) db.getStrsList(sql);  
		    //�����������medicineList������
		    for(int i=0;i<temp.size();i++){
		    	Medicine m=new Medicine();//��ҩʵ������һ��ʵ��
		    	String[]  s=(String[]) temp.get(i); 
		    	m.setMedicine_id(s[0]);
		    	m.setMedicine_name(s[1]);
		    	medicineList.add(m);
		    }
		    req.getSession().setAttribute("medicineList", medicineList);
 
	    	 req.getRequestDispatcher("/store.jsp").forward(req, resp);//ִ�гɹ�ת���ɹ�����
	    }
	    if(command.equals("storeAdd")){
	    	//���������һ������
	    	sql="insert into store(medicine_id,number,place,active_time,inactive_time,price,status) values("+medicine_id+","+number+",'"+place+"','"+active_time+"','"+inactive_time+"',"+price+",'0')";
	    	if(db.insertSQL(sql))
	    	 req.getRequestDispatcher("/success.jsp").forward(req, resp);//ִ�гɹ�ת���ɹ�����
			 else 
			req.getRequestDispatcher("/error.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ��� 
	    }
	    //����ҩƷ���
	    if(command.equals("sale")){
		    
		    temp=null;
		    //��ȡ���п���¼
		    sql="select b.medicine_name,b.medicine_detail,a.active_time,a.inactive_time,a.number,a.place,a.price,a.store_id from store a,medicine b where a.medicine_id=b.medicine_id and number<>0 ";
		    temp=(ArrayList<Store>) db.getStrsList(sql);
		  //�����������storeList������
		    for(int i=0;i<temp.size();i++){
		    	Store m=new Store();
		    	String[]  s=(String[]) temp.get(i); 
		    	m.setMedicine_name(s[0]);
		    	m.setMedicine_detail(s[1]);
		    	m.setActive_time(s[2]);
		    	m.setInactive_time(s[3]);
		    	m.setNumber(s[4]);
		    	m.setPlace(s[5]);
		    	m.setPrice(s[6]); 
		    	m.setStore_id(s[7]); 
		    	storeList.add(m);
		    }
		    req.getSession().setAttribute("storeList", storeList); 
	    	req.getRequestDispatcher("/sale.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���
	    }
	    if(command.equals("storeOut")){
			 Store  store =new Store (store_id,medicine_id,number,
						place,active_time,inactive_time,
						price,status,medicine_name,medicine_detail);
			  req.getSession().setAttribute("store", store); 
	    	req.getRequestDispatcher("/saleOut.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���
	    }	    
	    if(command.equals("storeSuccess")){
	    //����һ�����ۼ�¼
	    	sql="insert into sale(store_id,number) values("+store_id+","+number+")";
	    	if(db.insertSQL(sql)){
	    		sql="update store set number=number-"+number+" where store_id="+store_id;
	    		if(db.insertSQL(sql))
	    	    req.getRequestDispatcher("/success.jsp").forward(req, resp);//ִ�гɹ�ת���ɹ�����
	    		else
	    		req.getRequestDispatcher("/error.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ��� 
	    	}
			 else 
			req.getRequestDispatcher("/error.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ��� 
	    	
	    	req.getRequestDispatcher("/saleOut.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���
	    }		    
	    //���ۼ�¼���
	    if(command.equals("record")){
	    	//��ȡ�������ۼ�¼
		    temp=null;
		    //sql = "SELECT * FROM SALE"; 
		    sql="SELECT a.sale_id,c.medicine_name,c.medicine_cata,b.price,a.number,a.create_time from sale a,store b,medicine c where a.store_id=b.store_id and b.medicine_id=c.medicine_id";
		    System.out.print(sql); 
		    temp=(ArrayList<Sale>) db.getStrsList(sql);
		     for(int i=0;i<temp.size();i++){
		    	 Sale m=new Sale();
			    	String[]  s=(String[]) temp.get(i); 
			    	m.setSale_id(s[0]);
			    	m.setMedicine_name(s[1]);
			    	m.setMedicine_cata(s[2]);
			    	m.setPrice(s[3]);
			    	m.setNumber(s[4]);
			    	m.setCreate_time(s[5]);  
			    	saleList.add(m);
			    }
		     req.getSession().setAttribute("saleList", saleList);
	    	req.getRequestDispatcher("/record.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���

	    }
	    //�����������
	    if(command.equals("past")){
	    	//��ȡ���й���ҩƷ������
		    temp=null;
		     sql="select b.medicine_name,b.medicine_detail,a.active_time,a.inactive_time,a.number,a.place,a.price,a.store_id from store a,medicine b where a.medicine_id=b.medicine_id and number<>0 and inactive_time<SYSDATE()";
		     temp=(ArrayList<Store>) db.getStrsList(sql);
			    for(int i=0;i<temp.size();i++){
			    	Store m=new Store();
			    	String[]  s=(String[]) temp.get(i); 
			    	m.setMedicine_name(s[0]);
			    	m.setMedicine_detail(s[1]);
			    	m.setActive_time(s[2]);
			    	m.setInactive_time(s[3]);
			    	m.setNumber(s[4]);
			    	m.setPlace(s[5]);
			    	m.setPrice(s[6]); 
			    	m.setStore_id(s[7]); 
			    	storeList.add(m);
			    }
			    req.getSession().setAttribute("storeList", storeList); 
	    	req.getRequestDispatcher("/past.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���
	    }
	    //����������ʾ���
	    if(command.equals("limit")){
	    	//��ȡ���е���10��������ҩƷ������
		    temp=null;
		     sql="select b.medicine_name,b.medicine_detail,a.active_time,a.inactive_time,a.number,a.place,a.price,a.store_id from store a,medicine b where a.medicine_id=b.medicine_id and number<10 and number>0";
		     temp=(ArrayList<Store>) db.getStrsList(sql);
			    for(int i=0;i<temp.size();i++){
			    	Store m=new Store();
			    	String[]  s=(String[]) temp.get(i); 
			    	m.setMedicine_name(s[0]);
			    	m.setMedicine_detail(s[1]);
			    	m.setActive_time(s[2]);
			    	m.setInactive_time(s[3]);
			    	m.setNumber(s[4]);
			    	m.setPlace(s[5]);
			    	m.setPrice(s[6]); 
			    	m.setStore_id(s[7]); 
			    	storeList.add(m);
			    }
			    req.getSession().setAttribute("storeList", storeList); 
	    	req.getRequestDispatcher("/limit.jsp").forward(req, resp);//ִ�гɹ�ת��ʧ�ܽ���
	    }
	    
	    
	}

}
