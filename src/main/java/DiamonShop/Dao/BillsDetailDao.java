package DiamonShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ListBillDetailDto;
import DiamonShop.Dto.ListBillDetailDtoMapper;

@Repository
public class BillsDetailDao extends BaseDao {
    public StringBuffer SqlBillsDetail() {
    	StringBuffer sql = new StringBuffer();
    	sql.append("select");
    	sql.append(" p.id as id_product,");
    	sql.append(" p.name,");
    	sql.append(" p.price,");
    	sql.append(" b.quanty,");
    	sql.append(" b.total,");
    	sql.append(" c.img");
    	sql.append(" from");
    	sql.append(" products as p");
    	sql.append(" inner join");
    	sql.append(" billtail as b");
    	sql.append(" on p.id = b.id_product");
    	sql.append(" inner join");
    	sql.append(" colors as c");
    	sql.append(" on p.id = c.id_product");
    	
    	return sql; 
    }
    public List<ListBillDetailDto> ListBillsDetail(long id) {
    	StringBuffer sql = SqlBillsDetail();
    	sql.append(" where b.id_bills = "+id+" ");
    	List<ListBillDetailDto> listbilldetail = _jdbcTemplate.query(sql.toString(), new ListBillDetailDtoMapper()); 
    	return listbilldetail; 	
    }
}
