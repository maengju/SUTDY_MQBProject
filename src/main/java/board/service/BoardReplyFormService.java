package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardReplyFormService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//원글번호
		int pseq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//응답
		
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		
		request.setAttribute("display", "/board/boardReplyForm.jsp");
		return "/index.jsp";
		
	}

}
