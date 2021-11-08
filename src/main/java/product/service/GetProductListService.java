package product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import product.bean.ProductDTO;
import product.dao.ProductDAO;

public class GetProductListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//data
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB 
		//1페이지당 3개씩
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		ProductDAO productDAO=ProductDAO.getInstance();
		List<ProductDTO> list = productDAO.getProductList(map);
		
		
		JSONObject json = new JSONObject();
		if(list != null) {
			
			JSONArray array = new JSONArray();
			for(ProductDTO productDTO : list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", productDTO.getSeq());
				temp.put("img", productDTO.getImg());
				temp.put("name", productDTO.getName());
				temp.put("unit", productDTO.getUnit());
				temp.put("qty", productDTO.getQty());
				temp.put("total", productDTO.getTotal());
				temp.put("rate", productDTO.getRate());
				temp.put("discount", productDTO.getDiscount());
				temp.put("price",productDTO.getPrice());
				
				array.add(temp);
			}//for
			json.put("list", array);
			
			
		}
		
		System.out.println("json = "+json);
		
		request.setAttribute("list", json);
		
		return "/product/getProductList.jsp";
	}

}
