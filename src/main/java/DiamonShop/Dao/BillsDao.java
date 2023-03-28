package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.BillDetail;
import DiamonShop.Entity.Bills;
import DiamonShop.Entity.MapperBillDetail;
import DiamonShop.Entity.MapperBills;

@Repository
public class BillsDao extends BaseDao{
	
	
	
	public int AddBills(Bills bill) { 
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO bills ");
		sql.append("( ");
		sql.append("  user, ");
		sql.append("  phone, ");
		sql.append("  display_name, ");
		sql.append("  address, ");
		sql.append("  total, ");
		sql.append("  quanty, ");
		sql.append("  note ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("  '"+bill.getUser()+"', ");
		sql.append("  '"+bill.getPhone()+"', ");
		sql.append("  '"+bill.getDisplay_name()+"', ");
		sql.append("  '"+bill.getAddress()+"', ");
		sql.append("  '"+bill.getTotal()+"', ");
		sql.append("  '"+bill.getQuanty()+"', ");
		sql.append("  '"+bill.getNote()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;
	}
    
	public long GetIdLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}

	public int AddBillsDetail(BillDetail billDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO billtail ");
		sql.append("(");
		sql.append("  id_product, ");
		sql.append("  id_bills, ");
		sql.append("  quanty, ");
		sql.append("  total ");
		sql.append(")");
		sql.append("VALUES ");
		sql.append("(");
		sql.append("  '"+billDetail.getId_product()+"', ");
		sql.append("  '"+billDetail.getId_bills()+"', ");
		sql.append("  '"+billDetail.getQuanty()+"', ");
		sql.append("  '"+billDetail.getTotal()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;
		
	}
	public List<Bills> getlistBills(){
		List<Bills> list = new ArrayList<Bills>();
		String sql = "select * from bills"; 
		list = _jdbcTemplate.query(sql, new MapperBills());		
		return list;	
	}
	public List<BillDetail> getlistDetail(long id){
		String sql = "select * from billtail where id_bills ='"+id+"'";
		List<BillDetail> list = _jdbcTemplate.query(sql, new MapperBillDetail() );
		return list;
	}
}
