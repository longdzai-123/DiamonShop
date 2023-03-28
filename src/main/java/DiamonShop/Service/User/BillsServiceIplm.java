package DiamonShop.Service.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillsDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.BillDetail;
import DiamonShop.Entity.Bills;

@Service
public class BillsServiceIplm implements IBillsService{
	
	@Autowired
	private BillsDao billsDao;

	public int AddBills(Bills bill) {			
		return billsDao.AddBills(bill);
	}

	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		
		long idBills = billsDao.GetIdLastBills();
		
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			
			BillDetail billDetail = new BillDetail();
			billDetail.setId_product(itemCart.getValue().getProductsDto().getId_product());
			billDetail.setId_bills(idBills);
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			
			billsDao.AddBillsDetail(billDetail);
		}
		
	}
	

}
