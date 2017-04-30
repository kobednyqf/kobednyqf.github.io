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
	 
	 //连接数据源 
	public static Connection getConn() {
	    String driver = "com.mysql.jdbc.Driver";
	    String url = "jdbc:mysql://localhost:3306/px?characterEncoding=UTF-8";//myreport数据库名
	    String username = "root";//用户名
	    String password = "root";//密码
	    Connection conn = null;
	    try {
	        Class.forName(driver); //classLoader,加载对应驱动
	        conn = (Connection) DriverManager.getConnection(url, username, password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	 

	//关闭数据源
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
	
	
				//插入数据
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
					throw new RuntimeException("执行查询方法异常:"+e.getMessage());
					 
				}
				finally
				{
					close(conn, ps, rs);
				}
				
			}
	
			//根据sql返回String
			public static String getString(String sql)
			{
				String str[] = getStr(sql);
				if (str == null) { return null; }
				return str[0];
			}
			// 得到一个String[]
			public static String[] getStr(String sql)
			{
				List list = getStrsList(sql);
				if (list.size() == 0) { return null; }
				return (String[]) list.get(0);
			}
			//根据sql返回List
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
					throw new RuntimeException("执行查询方法异常:"+e.getMessage());
				}
				finally
				{
					close(conn, ps, rs);
				}
				return ls;
			}
	
			//将数据返回结果resultset转为List对象
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
