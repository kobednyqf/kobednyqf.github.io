package com.db;
 

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sun.security.timestamp.TSRequest;
 

 
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.org.apache.bcel.internal.generic.Select;

public class DB {
	 
	 //��������Դ 
	public static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/px?characterEncoding=UTF-8";//myreport���ݿ���
	    String username = "root";//�û���
	    String password = "root";//����
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,���ض�Ӧ����
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	 

	//�ر�����Դ
	public static void close(
	    Connection con, PreparedStatement stmt, ResultSet rs) {	 
		try {
			if (rs != null) rs.close();
		} catch (SQLException se) { 
		} 
		try {
			if (stmt != null) stmt.close();
		} catch (SQLException se) { 
		} 
		try {
			if (con != null && !con.isClosed()) con.close();
		} catch (SQLException e) { 
		} finally {
			con = null;
		}
	}
	
	
				//��������
			public boolean insertSQL(String sql){ 
				Connection conn = null ; 
				 PreparedStatement ps = null;
				 ResultSet rs = null;  
				try
				{     
					conn =getConn();
					ps = (PreparedStatement)conn.prepareStatement(sql); 
				    ps.execute(); 
				    return true;
				}
				catch (Exception e)
				{ 
					e.printStackTrace();
					throw new RuntimeException("ִ�в�ѯ�����쳣:"+e.getMessage());
					 
				}
				finally
				{
					close(conn, ps, rs);
				}
				
			}
	
			//����sql����String
			public static String getString(String sql)
			{
				String str[] = getStr(sql);
				if (str == null) { return null; }
				return str[0];
			}
			// �õ�һ��String[]
			public static String[] getStr(String sql)
			{
				List list = getStrsList(sql);
				if (list.size() == 0) { return null; }
				return (String[]) list.get(0);
			}
			//����sql����List
			public static List getStrsList(String sql)
			{
				List ls = new ArrayList(); 
				Connection conn = null ; 
				 PreparedStatement ps = null;
				 ResultSet rs = null;  
				try
				{  
					conn =getConn();
					ps = (PreparedStatement)conn.prepareStatement(sql); 
					rs = ps.executeQuery();
					ls = transtoStrsList(rs);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					throw new RuntimeException("ִ�в�ѯ�����쳣:"+e.getMessage());
				}
				finally
				{
					close(conn, ps, rs);
				}
				return ls;
			}
	
			//�����ݷ��ؽ��resultsetתΪList����
			private static List transtoStrsList(ResultSet rs) throws SQLException
			{
				List ls = new ArrayList();
				int cols = rs.getMetaData().getColumnCount();
				while (rs.next())
				{
					String strs[] = new String[cols];
					for (int i=1; i<=cols; i++)
					{

						strs[i-1] = rs.getString(i);
					}
					ls.add(strs);
				}
				return ls;

			}
	  
	  
}
