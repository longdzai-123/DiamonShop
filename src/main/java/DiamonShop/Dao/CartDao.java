package DiamonShop.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.CartDto;
import DiamonShop.Dto.ProductsDto;

@Repository
public class CartDao extends BaseDao {
	
	@Autowired

	private ProductsDao productsDao;

	public HashMap<Long, CartDto> AddCart(long id, HashMap<Long, CartDto> cart) {
		CartDto itemCart = new CartDto();
		ProductsDto product = productsDao.FindProductsByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty()+1);
			itemCart.setTotalPrice(product.getPrice() * itemCart.getQuanty());
		}
		else {
			itemCart.setProductsDto(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
			
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> EditCart(long id, int quanty, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			itemCart.setTotalPrice(quanty * itemCart.getProductsDto().getPrice());
		}

		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<Long, CartDto> DeleteCart(long id, HashMap<Long, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int totalQuanty(HashMap<Long, CartDto> cart) {
		int totalQuanty = 0;
        for(Map.Entry<Long, CartDto> itemCart:cart.entrySet()) {
        	totalQuanty += itemCart.getValue().getQuanty();
        }
		
		return totalQuanty;
	}

	public double totalPrice(HashMap<Long, CartDto> cart) {
		double totalPrice = 0;
        for(Map.Entry<Long, CartDto> itemCart:cart.entrySet()) {
        	totalPrice += itemCart.getValue().getTotalPrice();
        }
		return totalPrice;
	}

}
