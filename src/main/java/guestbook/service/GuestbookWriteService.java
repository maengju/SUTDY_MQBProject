package guestbook.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import guestbook.dao.GuestbookDAO;

public class GuestbookWriteService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 데이터
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String guestSubject = request.getParameter("guestSubject");
		String guestContent = request.getParameter("guestContent");
		
		

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("email", email);
		map.put("guestSubject", guestSubject);
		map.put("guestContent", guestContent);

		// DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.guestbookWrite(map);

		// 응답
		return "/guestbook/guestbookWrite.jsp";
	}

}
