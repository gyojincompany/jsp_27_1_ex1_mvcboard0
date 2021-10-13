package com.javagyojin.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.javagyojin.ex.dto.BDto;

public class BDao {

	DataSource datasource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void write(String bname, String btitle, String bcontent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) "
				+ "values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			
			int rn = preparedStatement.executeUpdate();//글 내용 저장이 성공하면 rn=1
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from mvc_board order by bgroup desc, bstep asc";//id순으로 내림차순 정렬		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bdate = resultSet.getTimestamp("bdate");
				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");
				
				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(resultSet !=null) resultSet.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return dtos;
		
	}
	
	public BDto contentView(String sid) {
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from mvc_board where bid = ?";
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(sid));
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bdate = resultSet.getTimestamp("bdate");
				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");
				
				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(resultSet !=null) resultSet.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return dto;
		
	
	}

	public void modify(String bid, String bname, String btitle, String bcontent) {
		// TODO Auto-generated method stub
		
		Connection connection = null;//conn
		PreparedStatement preparedStatement = null;//psmt
		
		
		
		try {
			connection = datasource.getConnection();
			String query = "update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.parseInt(bid));
			
			int rn = preparedStatement.executeUpdate();			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void delete(String bid) {
		// TODO Auto-generated method stub
		
		Connection connection = null;//conn
		PreparedStatement preparedStatement = null;//psmt
				
		
		try {
			connection = datasource.getConnection();
			String query = "delete from mvc_board where bid = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bid));
			
			int rn = preparedStatement.executeUpdate();			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public BDto reply_view(String rid) {
		// TODO Auto-generated method stub
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from mvc_board where bid = ?";
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(rid));
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next()) {
				int bid = resultSet.getInt("bid");
				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");
				Timestamp bdate = resultSet.getTimestamp("bdate");
				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");
				
				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(resultSet !=null) resultSet.close();
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return dto;
		
		
		
	}

	public void reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into mvc_board (bid, bname, btitle, bcontent, bgroup, bstep, bindent) "
				+ "values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = datasource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.parseInt(bgroup));
			preparedStatement.setInt(5, Integer.parseInt(bstep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bindent) + 1);
			
			
			int rn = preparedStatement.executeUpdate();//글 내용 저장이 성공하면 rn=1
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement !=null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	

}
