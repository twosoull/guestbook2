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
			RequestDispatcher rs = request.getRequestDispatcher("./WEB-INF/list.jsp");
			rs.forward(request, response);

			// insert
		} else if ("insert".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");

			guestVo = new GuestVo(name, password, content);

			guestDao.Insert(guestVo);

			response.sendRedirect("/guestbook2/gbc?action=list");
		} else if ("delete".equals(action)) {
			String password = request.getParameter("password");
			int no = Integer.parseInt(request.getParameter("no"));
			// 받은 no와 password로 delete 용 Vo객체 생성
			guestVo = new GuestVo(no, password);

			// password 체크용 객체 생성
			GuestVo checkpassw = guestDao.checkPassword(no);

			if (password.equals(checkpassw.getPassword())) {
				//no와 password 일치
				guestDao.delete(guestVo);
				response.sendRedirect("/guestbook2/gbc?action=list");

			} else {
				//no와 password 불일치
				request.setAttribute("no", no);
				RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/deletefailpage.jsp");
				rd.forward(request, response);
			}

		} else if ("deleteform".equals(action)) {

			int no = Integer.parseInt(request.getParameter("no"));

			request.setAttribute("no", no);
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/writeform.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}

}
