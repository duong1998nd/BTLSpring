package btl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import btl.dao.ProductDAO;
import btl.entities.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO proDAO;
	
	@RequestMapping(value = {"/", "/loadProducts"})
	public String loadProducts(Model model) {
		List<Product> list = proDAO.getAllProduct();
		model.addAttribute("list", list);
		return "listProduct";
	}
	@RequestMapping("/initInsertProduct")
	public String initInsertProduct(Model model) {
		Product pro = new Product();
		model.addAttribute("pro", pro);
		return "insertProduct";
	}
	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute("pro")Product pro, Model model) {
		boolean bl = proDAO.insertProduct(pro);
		if(bl) {
			return "redirect:/loadProducts";
		}else {
			model.addAttribute("err", "Thêm mới không thành công!");
			model.addAttribute("pro", pro);
			return "insertProduct";
		}
	}
}
