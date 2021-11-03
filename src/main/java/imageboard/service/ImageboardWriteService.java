package imageboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;

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
													,"UTF-8");
		
		return null;
	}

}
