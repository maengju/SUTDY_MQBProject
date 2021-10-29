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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		//dto -> json 변환
		JSONObject json = new JSONObject();
		
		if(boardDTO !=null) {
			JSONArray array = new JSONArray();
			JSONObject temp = new JSONObject();
			
			temp.put("seq", boardDTO.getSeq());
			temp.put("id", boardDTO.getId() );
			temp.put("name", boardDTO.getName());
			temp.put("email", boardDTO.getEmail());
			temp.put("subject",boardDTO.getSubject() );
			temp.put("content", boardDTO.getContent());
			temp.put("ref", boardDTO.getRef());
			temp.put("lev", boardDTO.getLev());
			temp.put("step", boardDTO.getStep());
			temp.put("pseq",boardDTO.getPseq() );
			temp.put("reply", boardDTO.getReply());
			temp.put("hit", boardDTO.getHit());
			temp.put("logtime", sdf.format(boardDTO.getLogtime()));
			
			array.add(temp);
			json.put("list", array);
		}
		
		request.setAttribute("view", json);
		return "/board/boardView.jsp";
		
	}

}
