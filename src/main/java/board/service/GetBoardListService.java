package board.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		//data
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB //1페이지당 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);

		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.getBoardList(map);
		
		
		//List -> JSON변환
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(BoardDTO boardDTO : list) {
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
			}//for
			
			json.put("list", array);
			
		}
		System.out.println("json ="+json);
		
		request.setAttribute("list", json);
		
		return "/board/getBoardList.jsp";
	}

}
