package com.javagyojin.ex.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javagyojin.ex.dao.BDao;

public class BModifyCommand implements BCommand {

	public BModifyCommand() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BDao dao = new BDao();
		dao.modify(bid, bname, btitle, bcontent);
	}

}
