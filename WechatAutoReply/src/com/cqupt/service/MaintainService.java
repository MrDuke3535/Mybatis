package com.cqupt.service;

import java.util.ArrayList;
import java.util.List;

import com.cqupt.dao.MessageDao;

public class MaintainService {

	/**
	 * 删除单条数据
	 * @param id
	 */
	public void deleteOne(String id){
		if(id !=null&&!"".equals(id.trim())){
			MessageDao messageDao = new MessageDao();
		    messageDao.deleteOne(Integer.parseInt(id));
		}
	}
	
	/**
	 * 删除多条数据
	 */
	public void deleteBatch(String[] ids){
		MessageDao messageDao = new MessageDao();
		List<Integer> listId = new ArrayList<Integer>();
		for(String id:ids){
			listId.add(Integer.parseInt(id));
		}
		messageDao.deleteBatch(listId);
	}

}
