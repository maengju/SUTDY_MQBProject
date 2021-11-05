package imageboard.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardPaging;
import imageboard.bean.ImageboardDTO;
import imageboard.bean.ImageboardPaging;
import imageboard.dao.ImageboardDAO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetImageboardListService implements CommandProcess  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		//data
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB 
		//1페이지당 3개씩
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		List<ImageboardDTO> list = imageboardDAO.getImageBoardList(map);
		
		//Session
		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("memId");
		
		//paging처리
		int totalA= imageboardDAO.getTotalA();
		
		ImageboardPaging imageboardPaging = new ImageboardPaging();
		imageboardPaging.setCurrentPage(pg);
		imageboardPaging.setPageBlock(3);
		imageboardPaging.setPageSize(3);
		imageboardPaging.setTotalA(totalA);
		imageboardPaging.makePagingHTML();
				
		//list -> JSON 변환
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			
			for(ImageboardDTO imageboardDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", imageboardDTO.getSeq());
				temp.put("imageId", imageboardDTO.getImageId());
				temp.put("imageName", imageboardDTO.getImageName());
				temp.put("imagePrice", imageboardDTO.getImagePrice());
				temp.put("imageQty", imageboardDTO.getImageQty());
				temp.put("imageContent", imageboardDTO.getImageContent());
				temp.put("image1", imageboardDTO.getImage1());
				temp.put("logtime", sdf.format(imageboardDTO.getLogtime()));
				
				array.add(temp);
			}//for
			json.put("list", array);
			
			json.put("memId", memId);
			
		}
		
		//boardpaging json 변환
		JSONObject paging = new JSONObject();
		
		json.put("imageboardPaging", imageboardPaging.getPagingHTML().toString());
		
		System.out.println("json = "+json);
		
		request.setAttribute("list", json);
		
		return "/imageboard/getImageboardList.jsp";
	}

}
