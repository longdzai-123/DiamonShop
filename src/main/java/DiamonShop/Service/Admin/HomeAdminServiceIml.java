package DiamonShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillsDao;
import DiamonShop.Dao.BillsDetailDao;
import DiamonShop.Dao.CategorysDao;
import DiamonShop.Dto.ListBillDetailDto;
import DiamonShop.Entity.BillDetail;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.Categorys;
@Service
public class HomeAdminServiceIml implements IHomeAdminService{
    
	@Autowired
	BillsDao billsDao;
	@Autowired 
	BillsDetailDao billsDetailDao; 
	@Autowired 
	CategorysDao categorysDao;
	
	public List<Bills> getlistBills() {
		return billsDao.getlistBills();
	}

	public List<BillDetail> getlistDetail(long id) {
		
		return billsDao.getlistDetail(id);
	}
	public List<ListBillDetailDto> ListBillsDetail(long id){
		return billsDetailDao.ListBillsDetail(id);
	}
	
	public int AddCategory(Categorys category) {
		return categorysDao.AddCategory(category);
	} 
	public int DeleteCategory(long id){
		return categorysDao.DeleteCategory(id);
	}
}
