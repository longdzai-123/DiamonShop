package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CommentDao;
import DiamonShop.Dao.ProductsDao;
import DiamonShop.Dto.ProductsDto;
import DiamonShop.Entity.Comments;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    ProductsDao productsDao;
    @Autowired
    CommentDao commentDao;
	public List<ProductsDto> GetProductsByID(long id) {
		  
		return productsDao.GetProductsByID(id);
	}
	public List<ProductsDto> GetProductsByIDCategory(int id) {
		
		return productsDao.GetAllProductsByID(id);
	}
	public int AddComment(Comments comments) {
		return commentDao.AddComment(comments);
		
	}
	public List<Comments> getListCommentByID(long id){
		return commentDao.getListCommentByID(id);
	}
  
}
