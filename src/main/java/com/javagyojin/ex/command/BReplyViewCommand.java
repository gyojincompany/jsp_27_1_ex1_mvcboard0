package com.javagyojin.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javagyojin.ex.dao.BDao;
import com.javagyojin.ex.dto.BDto;

public class BReplyViewCommand implements BCommand {

	public BReplyViewCommand() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		BDao dao = new BDao();
		BDto dto = dao.reply_view(bid);	
		
		request.setAttribute("reply_view", dto);
		
		
	}

}
