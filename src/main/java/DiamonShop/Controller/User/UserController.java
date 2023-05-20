package DiamonShop.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") Users user) {
		int count = accountServiceImpl.AddAccount(user);
		if(count > 0) {
			_mvShare.addObject("status", "Đăng ký thành công");
		}else {
			_mvShare.addObject("status", "Đăng ký không thành công");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
		
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("user") Users user) {
		user = accountServiceImpl.CheckAccount(user);
		if(user != null) {
			
			if(user.getId_categorymember()== 1) {
				
				_mvShare.setViewName("redirect:trang-chu");
				
				session.setAttribute("loginInfo", user);
			}
			if(user.getId_categorymember() == 2) 
			{   
			    _mvShare.setViewName("redirect:admin/home");  
			    
			    session.setAttribute("loginAdminInfo", user);
			}
		}
		else {
			_mvShare.addObject("statusLogin", "Đăng nhập không thành công");
		}
		return _mvShare;
		
	}
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("loginInfo");
		return "redirect:" +request.getHeader("Referer") ;
	}

}
