package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CartDao;
import DiamonShop.Dto.CartDto;

@Service
public class CartServiceIplm implements ICartService{
	@Autowired
	private CartDao cartDao;

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.AddCart(id, cart);
	}

	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {
		
		return cartDao.EditCart(id, quanty, cart);
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		
		return cartDao.DeleteCart(id, cart);
	}

	public int totalQuanty(HashMap<Long, CartDto> cart) {
		
		return cartDao.totalQuanty(cart);
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		
		return cartDao.totalPrice(cart);
	}
	
	

}
