package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.MapperCategorys;
import DiamonShop.Entity.Users;

@Repository
public class CategorysDao extends BaseDao{
	
	
	public List<Categorys> GetDataCategorys(){
		List<Categorys> list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";	
		list= _jdbcTemplate.query(sql, new MapperCategorys());
		return list;
	}
	
	public int AddCategory(Categorys category) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO categorys ");
		sql.append("( ");
		sql.append("  id, ");
		sql.append("  name, ");
		sql.append("  description ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("  '"+category.getId()+"', ");
		sql.append("  '"+category.getName()+"', ");
		sql.append("  '"+category.getDescription()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;
	}
	
	public int DeleteCategory(long id){
		String sql = "delete from categorys where id ='"+id+"'";
		int delete = _jdbcTemplate.update(sql);
		return delete;
	}
	
}
