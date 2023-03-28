package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart );
	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart );
	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart );
	public int totalQuanty(HashMap<Long, CartDto> cart);
	public double totalPrice(HashMap<Long, CartDto> cart);
}
