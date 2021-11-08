package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imageboard.dao.ImageboardDAO;

public class ImageboardDeleteService  implements CommandProcess  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//data
		String[] check = request.getParameterValues("check"); // 선택한 값들만 넘어온다.
		
		ImageboardDAO imageboardDAO=ImageboardDAO.getInstance();
		imageboardDAO.imageboardDelete(check);
		
		request.setAttribute("display", "/imageboard/imageboardDelete.jsp");
		return "/index.jsp";
	}

}
