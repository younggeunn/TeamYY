package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.command.BoardModifyCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardModifyAction implements Action {

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "redirect:/board/detail.do?bno=" + request.getParameter("bno");

		// 입력
		BoardModifyCommand command 
			= HttpRequestParameterAdapter.execute(request, BoardModifyCommand.class);
		 
		BoardVO board = command.toBoardVO();

		String title = HTMLInputFilter.htmlSpecialChars(board.getTitle());
		board.setTitle(title);

		// 처리 (기능)
		boardService.modify(board);
		
		return url;
	}

}
