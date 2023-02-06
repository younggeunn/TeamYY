package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.action.Action;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardRegistAction implements Action{

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면
				String url="/board/regist_success";
				
				//입력
				BoardVO board = HttpRequestParameterAdapter.execute(request, BoardVO.class);
				
				String title = HTMLInputFilter.htmlSpecialChars(board.getTitle()); 
				board.setTitle(title);
				
				//처리 (기능)
				boardService.regist(board);
							
				//출력
				return url;
			}
}
