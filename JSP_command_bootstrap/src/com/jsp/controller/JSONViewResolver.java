package com.jsp.controller;import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONViewResolver {

	public static void view(HttpServletResponse response, Object target)throws Exception{
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		//content Type 결정 application/json
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// json형태로 내보내기
		out.println(mapper.writeValueAsString(target));
		
		
		out.close();
		
	}
}
