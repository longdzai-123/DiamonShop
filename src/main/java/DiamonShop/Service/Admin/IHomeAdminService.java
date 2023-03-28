package DiamonShop.Service.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Entity.Bills;

@Service
public interface IHomeAdminService {
	public List<Bills> getlistBills();
  
}
