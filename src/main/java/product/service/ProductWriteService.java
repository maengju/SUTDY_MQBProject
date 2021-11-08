package product.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;

import product.bean.ProductDTO;
import product.dao.ProductDAO;

public class ProductWriteService   implements CommandProcess  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//실제폴더
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		
		//upload
		MultipartRequest multi = new MultipartRequest(request
													,realFolder
													,5*1024*1024 
													,"UTF-8"
													);
		//Data 
		String img = multi.getOriginalFileName("img");
		String name = multi.getParameter("name");
		int unit = Integer.parseInt(multi.getParameter("unit"));
		int qty = Integer.parseInt(multi.getParameter("qty"));
		double rate = Integer.parseInt(multi.getParameter("rate"));
		
		int total = unit*qty;
		double discount = total*(rate/100);
		double price = total-discount;	
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setImg(img);
		productDTO.setName(name);
		productDTO.setUnit(unit);
		productDTO.setQty(qty);
		productDTO.setRate(rate);
		productDTO.setTotal(total);
		productDTO.setDiscount(discount);
		productDTO.setPrice(price);
		
		//db
		ProductDAO productDAO=ProductDAO.getInstance();
		productDAO.productwrite(productDTO);
		
		
		request.setAttribute("display", "/product/productWrite.jsp");
		return "/index.jsp";
	}

}
