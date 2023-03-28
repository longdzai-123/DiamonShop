package DiamonShop.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Comments;
import DiamonShop.Entity.MapperCmt;
@Repository
public class CommentDao extends BaseDao{
    
	public int AddComment(Comments comments) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO comments ");
		sql.append("( ");
		sql.append("  id_cmt, ");
		sql.append("  id_product, ");
		sql.append("  name_user, ");
		sql.append("  content ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("  '"+comments.getId_cmt()+"', ");
		sql.append("  '"+comments.getId_product()+"', ");
		sql.append("  '"+comments.getName_user()+"', ");
		sql.append("  '"+comments.getContent()+"' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		
		return insert;		
	}
	
	public List<Comments> getListCommentByID(long id){
		String sql = "select * from comments where id_product='"+id+"'";
		List<Comments> list = _jdbcTemplate.query(sql, new MapperCmt());
		return list;		
	}
}
