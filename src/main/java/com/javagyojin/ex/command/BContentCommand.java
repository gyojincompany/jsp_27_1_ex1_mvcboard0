package com.javagyojin.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javagyojin.ex.dao.BDao;
import com.javagyojin.ex.dto.BDto;

public class BContentCommand implements BCommand {

	public BContentCommand() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		BDao dao = new BDao();
		BDto dto = dao.contentView(bid);
		
		//System.out.println(bid);
		
		request.setAttribute("content_view", dto);
		
	}

}
