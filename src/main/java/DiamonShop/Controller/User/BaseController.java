package DiamonShop.Controller.User;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;

public class BaseController {
	@Autowired
	HomeServiceImpl _homeService;
	
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("menus", _homeService.GetDataMenus());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		return _mvShare;
	}
	
}
