package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.StuDao;
import com.domain.Student;
import com.uitl.JDBCUtil;

public class StuDaoImpl implements StuDao {

	@Override
	public List<Student> findAll() {
		List<Student>list = new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql="select * from t_stu";
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				
		  Student stu = new Student(rs.getInt("id"),
				  rs.getString("name"), 
				  rs.getInt("age"),
				  rs.getString("gender"),
				  rs.getString("address"));
		   		list.add(stu);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}
		
		
		return list;
	}

}
