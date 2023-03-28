package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginatesDto;
import DiamonShop.Entity.Comments;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.PaginatesServiceImpl;
import DiamonShop.Service.User.ProductServiceImpl;
import DiamonShop.Service.User.ProductsearchIml;

@Controller
public class ProductController extends BaseController{
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired 
	ProductsearchIml productsearchIml;	
	@Autowired
	PaginatesServiceImpl paginatesService;
	
	@RequestMapping(value = { "/chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable("id") long id, HttpServletRequest request, HttpSession session) {		
		Comments comment = new Comments();
		Users loginInfo = (Users)session.getAttribute("loginInfo");
		if(loginInfo != null) {
    		comment.setId_product(id);
    	    comment.setName_user(loginInfo.getDisplay_name());
    	}
    	_mvShare.addObject("comment", comment);	
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("listcmt", productServiceImpl.getListCommentByID(id));
		_mvShare.addObject("product",productServiceImpl.GetProductsByID(id).get(0));
		int idCategory =  productServiceImpl.GetProductsByID(id).get(0).getId_category();
		_mvShare.addObject("productByIDCategory", productServiceImpl.GetProductsByIDCategory(idCategory));
		return _mvShare;
	}
	
	@RequestMapping(value = {"/tim-kiem"})
	public ModelAndView Search(@RequestParam(name="name", required = false) String name ) {
		_mvShare.setViewName("user/products/searchproduct");
		
		if(StringUtils.hasText(name)) {
			
			int totalData = productsearchIml.GetProductsBySearch(name).size();
			int totalProductsPage = 9;
			PaginatesDto paginateInfo = paginatesService.GetInfoPaginates(totalData, totalProductsPage,1);
			_mvShare.addObject("totalData", totalData);
			_mvShare.addObject("name", name);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("listsearch", productsearchIml.GetDataProductsPaginateSearch(name, paginateInfo.getStart(), totalProductsPage));
		}else {
			int totalData = productsearchIml.GetAllProduct().size();
			int totalProductsPage = 9;
			PaginatesDto paginateInfo = paginatesService.GetInfoPaginates(totalData, totalProductsPage,1);
			_mvShare.addObject("name", name);
			_mvShare.addObject("paginateInfo", paginateInfo);
			_mvShare.addObject("listsearch", productsearchIml.GetDataProductsPaginateSearch(name, paginateInfo.getStart(), totalProductsPage));
		}
		
		return _mvShare;
	}
	@RequestMapping(value = {"/tim-kiem/{currentPage}"})
	public ModelAndView ProductSearch(@RequestParam(name="name", required = false) String name, @PathVariable("currentPage") String currentPage ) {
		_mvShare.setViewName("user/products/searchproduct");
		int totalData = productsearchIml.GetProductsBySearch(name).size();
		int totalProductsPage = 9;
		PaginatesDto paginateInfo = paginatesService.GetInfoPaginates(totalData, totalProductsPage,Integer.parseInt(currentPage));
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("listsearch", productsearchIml.GetDataProductsPaginateSearch(name, paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/comment")
	  public ModelAndView AddComment(HttpServletRequest request,@ModelAttribute("comment") Comments comment) {	
		   productServiceImpl.AddComment(comment);
		  _mvShare.setViewName("redirect:"+request.getHeader("Referer"));	  
		  return _mvShare;
	  }
	
}
