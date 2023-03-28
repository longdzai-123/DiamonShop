package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;

@Service
public class ProductsearchIml implements IProductsearch {
    @Autowired
    ProductsDao productsDao;
	public List<ProductsDto> GetProductsBySearch(String name) {
		return productsDao.GetProductsBySearch(name);
	}
	public List<ProductsDto> GetAllProduct() {
		
		return productsDao.GetAllProduct();
	}
	public List<ProductsDto> GetDataProductsPaginateSearch(String name, int start, int totalPage) {
		
		return productsDao.GetDataProductsPaginateSearch(name, start, totalPage);
	}
	
	
   
}
