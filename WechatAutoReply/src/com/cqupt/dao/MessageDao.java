package com.cqupt.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.cqupt.bean.Message;
import com.cqupt.db.DBAccess;

public class MessageDao {
	/**
	 * 根据command和description查询消息列表
	 * @param command
	 * @param description
	 * @return
	 */
//	public List<Message> getMessageList(String command,String description){
//	String URL="jdbc:mysql://127.0.0.1:3306/wechat?serverTimezone=UTC&charcaterEncoding=utf8&useUincode=true&useSSL=false";
//	String USERNAME="root";
//	String PASSWORD="1234";
//		List<Message> messages = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
//			StringBuffer sql = new StringBuffer("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paramList = new ArrayList<String>();
//			if(command!=null&&!"".equals(command)){
//				sql.append(" and COMMAND =?");
//				paramList.add(command);
//			}
//			if(description!=null&&!"".equals(description)){
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement ps = conn.prepareStatement(sql.toString());
//			for(int i=0;i<paramList.size();i++){
//				ps.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs=ps.executeQuery();
//			while(rs.next()){
//				Message message = new Message();
//				messages.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messages;
//	}
	
	/*
	 * 获取数据列表
	 */
	public List<Message> getMessageList(String command,String description){
		SqlSession sqlSession=null;
		DBAccess dbAccess=new DBAccess();
		List<Message> messages = new ArrayList<Message>();
		try {
			sqlSession=dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			messages=sqlSession.selectList("Message.getMessageList",message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		return messages;
	}
	
	
	/**
	 * 删除单项数据
	 * @param id
	 */
	public void deleteOne(int id){
		SqlSession sqlSession=null;
		DBAccess dbAccess = new DBAccess();
		try {
			sqlSession=dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		}
	}
	
	/**
	 *删除多项数据
	 */
	public void deleteBatch(List<Integer> ids){
		SqlSession sqlSession=null;
		DBAccess dbAccess = new DBAccess();
		try {
			sqlSession=dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
