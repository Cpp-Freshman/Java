package com.dao.impl;

import com.dao.UserDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.uitl.JDBCUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean login(String username,String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql="select * from t_user where username=? and password=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			 rs=ps.executeQuery();
		
			
			return rs.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);
		}
		
		return false;
	}

	@Override
	public boolean Register(String userName, String passWord) {
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn = JDBCUtil.getConn();
				
				String sql="insert into t_user values(null,?,?)";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, passWord);
				
				return ps.executeUpdate()>0 ? true:false;
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.release(conn, ps, rs);
			}
		return false;
	}

}