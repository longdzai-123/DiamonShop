package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.Users;
import DiamonShop.Service.User.BillsServiceIplm;
import DiamonShop.Service.User.CartServiceIplm;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceIplm cartService;
	@Autowired 
	private BillsServiceIplm billsService;
	
	 @RequestMapping(value = "/gio-hang") 
	 public ModelAndView Index() {
			_mvShare.addObject("slides", _homeService.GetDataSlide());
			_mvShare.addObject("categorys", _homeService.GetDataCategorys());
			_mvShare.addObject("products", _homeService.GetDataProductsDto());
			_mvShare.setViewName("user/cart/list_cart");
			return _mvShare;
		}
	
	
	
	
     @RequestMapping(value = "/AddCart/{id}")
     public String AddCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
    	 HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
    	 if(cart == null) {
    		 cart = new  HashMap<Long, CartDto>();
    	 }
    	 cart = cartService.AddCart(id, cart);
    	 session.setAttribute("Cart", cart);
    	 session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
    	 session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
  	 
    	 return "redirect:"+request.getHeader("Referer");   	 
     }
     
     @RequestMapping(value = "/EditCart/{id}/{quanty}")
     public String EditCart(HttpServletRequest request,HttpSession session, @PathVariable long id, @PathVariable int quanty) {
    	 HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
    	 if(cart == null) {
    		 cart = new  HashMap<Long, CartDto>();
    	 }
    	 cart = cartService.EditCart(id, quanty, cart);
    	 session.setAttribute("Cart", cart);
    	 session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
    	 session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
  	 
    	 return "redirect:"+request.getHeader("Referer");   	 
     }
     
     
     @RequestMapping(value = "/DeleteCart/{id}")
     public String DeleteCart(HttpServletRequest request,HttpSession session, @PathVariable long id) {
    	 HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
    	 if(cart == null) {
    		 cart = new  HashMap<Long, CartDto>();
    	 }
    	 cart = cartService.DeleteCart(id, cart);
    	 session.setAttribute("Cart", cart);
    	 session.setAttribute("TotalQuantyCart", cartService.totalQuanty(cart));
    	 session.setAttribute("TotalPriceCart", cartService.totalPrice(cart));
    	 
    	 return "redirect:"+request.getHeader("Referer");
     }
     
     @RequestMapping(value = "/checkout" , method = RequestMethod.GET)
     public ModelAndView CheckOut(HttpServletRequest request,HttpSession session) {
    	_mvShare.setViewName("user/bills/checkout");
    	Bills bills = new Bills();
    	Users loginInfo = (Users)session.getAttribute("loginInfo");
    	if(loginInfo != null) {
    		bills.setAddress(loginInfo.getAddress());
    	    bills.setDisplay_name(loginInfo.getDisplay_name());
    	    bills.setUser(loginInfo.getUser());
    	}
    	_mvShare.addObject("bills", bills);
    	 return _mvShare;
     }
     
     @RequestMapping(value = "/checkout" , method = RequestMethod.POST)
     public String CheckOutBill(HttpServletRequest request,HttpSession session, @ModelAttribute("bills") Bills bill ) {
    	 String totalQuantyCart = session.getAttribute("TotalQuantyCart").toString();
    	 String totalPriceCart = session.getAttribute("TotalPriceCart").toString();
    	 bill.setQuanty(Integer.parseInt(totalQuantyCart));
    	 bill.setTotal(Double.parseDouble(totalPriceCart));
    	 
    	if(billsService.AddBills(bill) > 0) {
    		HashMap<Long, CartDto> carts =  (HashMap<Long, CartDto>)session.getAttribute("Cart");
    		billsService.AddBillsDetail(carts);
    	}
    	session.removeAttribute("Cart");
    	 return "redirect:gio-hang";
     }
     
     
}
