package DiamonShop.Controller.Admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import DiamonShop.Entity.Categorys;
import DiamonShop.Service.Admin.HomeAdminServiceIml;
import DiamonShop.Service.User.HomeServiceImpl;
import DiamonShop.Service.User.ProductServiceImpl;

@Controller
public class HomeAdminController extends BaseAdminController {
	@Autowired 
	HomeAdminServiceIml homeAdminServiceIml;
	@Autowired
	ProductServiceImpl productServiceImpl;
	@Autowired
	HomeServiceImpl homeServiceImpl;
	

  @RequestMapping(value = "/admin/home")
  public ModelAndView HomeAdmin() {
	  
	  _mvshare.addObject("listBills",homeAdminServiceIml.getlistBills() );
	  _mvshare.setViewName("admin/index");
	  
	  return _mvshare;
  }
  
  @RequestMapping(value = "admin/chi-tiet-don-hang/{id}")	
  public ModelAndView BillsDetail(@PathVariable("id") long id) {
	_mvshare.setViewName("admin/detailbill");
	_mvshare.addObject("listdetail", homeAdminServiceIml.getlistDetail(id));
	_mvshare.addObject("listBillDetail",homeAdminServiceIml.ListBillsDetail(id) );
	return _mvshare;  
  }
  @RequestMapping(value = "admin/danh-muc")
  public ModelAndView Category() {
	  _mvshare.addObject("categorys", homeServiceImpl.GetDataCategorys());
	  _mvshare.setViewName("admin/categorysAdmin");
	  return _mvshare;
  }
  @RequestMapping(value = "admin/them")
  public ModelAndView addCategory() {
	  Categorys categorys = new Categorys();
	  _mvshare.addObject("categorys", categorys);
	  _mvshare.setViewName("admin/addcategory");
	  return _mvshare;
  }
  @RequestMapping(value = "admin/savedanhmuc")
  public ModelAndView savecategory(@ModelAttribute("categorys") Categorys category) {
	    int kt = homeAdminServiceIml.AddCategory(category);
		_mvshare.setViewName("redirect:danh-muc");
	  return _mvshare;
  }
  
  @RequestMapping( value = "admin/delete/{id}")
  public String DeleteCategory( @PathVariable("id") long id, HttpServletRequest request) {
	 List<Categorys> list = homeServiceImpl.GetDataCategorys();
	 homeAdminServiceIml.DeleteCategory(id);
	 return "redirect:"+request.getHeader("Referer"); 
  }
  @RequestMapping(value = "admin/listAdminProduct")
  public ModelAndView AdminProduct() {
	  
	  _mvshare.setViewName("admin/category2");
	  return _mvshare;
  }
  @RequestMapping(value = "admin/allproduct/{id}")
  public ModelAndView allAdminProduct(@PathVariable("id") int id) {
	  _mvshare.addObject("listProduct", productServiceImpl.GetProductsByIDCategory(id));
	  _mvshare.setViewName("admin/listproduct");
	  return _mvshare;
  }
  
  
  
  
  
  
}
