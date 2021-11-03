package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplyService implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		int pseq = Integer.parseInt(request.getParameter("pseq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		String name = (String) session.getAttribute("memName");
		String id = (String) session.getAttribute("memId");
		String email = (String) session.getAttribute("memEmail");
			
		Map<String, String> map = new HashMap<String, String>();
		map.put("pseq", pseq+"");
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardReply(map);
		
		//응답
		return "/board/boardReply.jsp";
		
	}

}
