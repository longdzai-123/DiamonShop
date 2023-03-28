package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;
@Service
public interface IProductsearch {
     public List<ProductsDto> GetProductsBySearch(String name);
     public List<ProductsDto> GetAllProduct();
     public List<ProductsDto> GetDataProductsPaginateSearch(String name, int start, int totalPage);
}
