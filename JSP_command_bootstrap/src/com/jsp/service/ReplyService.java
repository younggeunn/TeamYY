package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.ReplyVO;

public interface ReplyService {

	Map<String, Object> getReplyList(int bno, SearchCriteria cri) throws SQLException;

	int getReplyListCount(int bno) throws SQLException;

	void registReply(ReplyVO reply) throws SQLException;

	void modifyReply(ReplyVO reply) throws SQLException;

	void removeReply(int rno) throws SQLException;
}
