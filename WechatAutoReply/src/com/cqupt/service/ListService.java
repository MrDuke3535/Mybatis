package com.cqupt.service;

import java.util.List;

import com.cqupt.bean.Message;
import com.cqupt.dao.MessageDao;

public class ListService {

	/**
	 * 列表相关的业务功能
	 * @param command
	 * @param description
	 * @return
	 */
	public List<Message> getMessageList(String command,String description){
		MessageDao messageDao = new MessageDao();
		return messageDao.getMessageList(command, description);
	}

}
