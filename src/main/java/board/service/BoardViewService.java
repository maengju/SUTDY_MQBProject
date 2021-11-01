package board.service;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BoardViewService implements CommandProcess  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardView.jsp");
		return "/index.jsp";
		
	}

}
