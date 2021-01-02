package com.lvtrai.demotpc.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvtrai.demotpc.form.ProductFilterForm;
import com.lvtrai.demotpc.form.SortFilter;
import com.lvtrai.demotpc.model.Brand;
import com.lvtrai.demotpc.model.Category;
import com.lvtrai.demotpc.model.Product;
import com.lvtrai.demotpc.service.ProductService;


@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/store")
	public String store(@ModelAttribute("filters") ProductFilterForm filters, Model model) {
		Integer page = filters.getPage();			
		int pagenumber = (page == null ||  page <= 0) ? 0 : page-1;
		SortFilter sortFilter = new SortFilter(filters.getSort());	
		Page<Product> pageresult = productService.findProductsByCriteria(PageRequest.of(pagenumber,9, sortFilter.getSortType()), 
																filters.getPricelow(), filters.getPricehigh(), 
																filters.getSize(), filters.getCategory(), filters.getBrand(), filters.getSearch());	
		model.addAttribute("allCategories", productService.getAllCategories());
		model.addAttribute("allBrands", productService.getAllBrands());
		model.addAttribute("allSizes", productService.getAllSizes());
		model.addAttribute("products", pageresult.getContent());
		model.addAttribute("totalitems", pageresult.getTotalElements());
		model.addAttribute("itemsperpage", 12);
		return "store";
	}
	
	
	@RequestMapping("/product-detail")
	public String productDetail(@PathParam("id") Long id, Model model) {
		Product product = productService.findProductById(id);
		
		String preselectedBrands = "";
		for (Brand brand : product.getBrands()) {
			preselectedBrands += (brand.getName() + ",");
		}
		String preselectedCategorys = "";
		for (Category category : product.getCategories()) {
			preselectedCategorys += (category.getName() + ",");
		}	
		model.addAttribute("preselectedBrands", preselectedBrands);
		model.addAttribute("preselectedCategorys", preselectedCategorys);
		model.addAttribute("product", product);
		model.addAttribute("notEnoughStock", model.asMap().get("notEnoughStock"));
		model.addAttribute("addProductSuccess", model.asMap().get("addProductSuccess"));
		return "productDetail";
	}
	

}
