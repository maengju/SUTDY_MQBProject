package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import imageboard.bean.ImageboardDTO;
import imageboard.dao.ImageboardDAO;

public class ImageboardWriteService  implements CommandProcess  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제폴더
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		
		//upload
		MultipartRequest multi = new MultipartRequest(request
													,realFolder
													,5*1024*1024 //5mb
													,"UTF-8"
													,new DefaultFileRenamePolicy() // 같은이름이엿을때 뒤에 번호 붙여서 올려줌
													);
		
		
		//Data 업로드를 하게되면 모든권한이 multi쪽으로 가게됨
		String imageId = multi.getParameter("imageId");
		String imageName = multi.getParameter("imageName");
		int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent = multi.getParameter("imageContent");
		//String image1 = multi.getOriginalFileName("image1");
		String image1 = multi.getFilesystemName("image1");
		
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		imageboardDTO.setImageId(imageId);
		imageboardDTO.setImageName(imageName);
		imageboardDTO.setImagePrice(imagePrice);
		imageboardDTO.setImageQty(imageQty);
		imageboardDTO.setImageContent(imageContent);
		imageboardDTO.setImage1(image1); //file명만 (파일자체를 실어가는게아님)
		
		//DB
		ImageboardDAO imageboardDAO = ImageboardDAO.getInstance();
		imageboardDAO.imageboardWrite(imageboardDTO);
		
		request.setAttribute("display", "/imageboard/imageboardWrite.jsp");
		return "/index.jsp";
	}

}
