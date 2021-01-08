package com.javaex.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.guestdao.GuestbookDao;
import com.javaex.guestvo.GuestVo;
import com.javaex.util.WebUtil;

@WebServlet("/gbc")
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// action 파라미터 받기

		String action = request.getParameter("action");
		System.out.println(action);
		
		GuestVo guestVo = null;
		// dao준비
		GuestbookDao guestDao = new GuestbookDao();

		// list불러오기
		if ("list".equals(action)) {
			List<GuestVo> guestList = guestDao.getList();

			request.setAttribute("guestList", guestList);
			
			/*
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/list.jsp");
			rs.forward(request, response);
			*/
			
			WebUtil.forward(request, response, "./WEB-INF/list.jsp");
			// insert
		} else if ("insert".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			guestVo = new GuestVo(name, password, content);

			guestDao.Insert(guestVo);
			
			/*
			response.sendRedirect("/guestbook2/gbc?action=list");
			*/
			WebUtil.redirect(request, response, "/guestbook2/gbc?action=list");
			
		} else if ("delete".equals(action)) {
			String password = request.getParameter("password");
			int no = Integer.parseInt(request.getParameter("no"));
			// 받은 no와 password로 delete 용 Vo객체 생성
			guestVo = new GuestVo(no, password);
			
			//password와 no를 웨어절 하나로 비교 하는방법..
			//생각해보니 딜리트메소드는 성공하면 1을 주고
			//아무 삭제가 없으면 0을 준다
			//올바른 방법인지는 의심된다..?
			int count = guestDao.delete(guestVo);
			System.out.println(count);
			
			
			if (count >=1) {
				//no와 password 일치
				/*
				response.sendRedirect("/guestbook2/gbc?action=list");
				*/
				WebUtil.redirect(request, response,"/guestbook2/gbc?action=list");
			} else {
				//no와 password 불일치
				/*
				RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deletefailpage.jsp");
				rd.forward(request, response);
				*/
				WebUtil.forward(request, response, "./WEB-INF/deletefailpage.jsp");
				
			}

		} else if ("deleteform".equals(action)) {

			System.out.println("딜리트폼");
			/*
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/writeform.jsp");
			rd.forward(request, response);
			*/
			WebUtil.forward(request, response, "./WEB-INF/writeform.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}

}
