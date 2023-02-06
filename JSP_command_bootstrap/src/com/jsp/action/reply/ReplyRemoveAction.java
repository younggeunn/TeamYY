package com.jsp.action.reply;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.PageMaker;
import com.jsp.command.ReplyRemoveConmmand;
import com.jsp.command.SearchCriteria;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.service.ReplyService;

public class ReplyRemoveAction implements Action{

	private ReplyService replyService;

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = null;
		//넘어가는파라메터 페이지,rno,bno 요것들을 받음(받기가 까다로워서 command 객체를 하나만듬)
		ReplyRemoveConmmand removeCMD = HttpRequestParameterAdapter
				.execute(request, ReplyRemoveConmmand.class);
		//DB
		replyService.removeReply(removeCMD.getRno());
		
		//page Num
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(new SearchCriteria());
		pageMaker.setTotalCount(replyService.getReplyListCount(removeCMD.getBno()));
		
		int realEndPage = pageMaker.getRealEndPage();
		
		int page = removeCMD.getPage();
		if(page>realEndPage) {
			page =realEndPage;
		}
		
		PrintWriter out = response.getWriter();
		out.print(page);
		out.close();
		return url;
		
	}

}
