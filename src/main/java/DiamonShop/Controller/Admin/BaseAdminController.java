package DiamonShop.Controller.Admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Service.User.HomeServiceImpl;

public class BaseAdminController {
	@Autowired
	HomeServiceImpl homeServiceImpl;
	public ModelAndView _mvshare = new ModelAndView();
	@PostConstruct
	public ModelAndView Init() {
		_mvshare.addObject("categorys", homeServiceImpl.GetDataCategorys());
		return _mvshare;
	}
}
