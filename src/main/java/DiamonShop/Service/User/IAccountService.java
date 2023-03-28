package DiamonShop.Service.User;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;

@Service
public interface IAccountService {
	
	public int AddAccount(Users user);
	public Users CheckAccount(Users user);
}
