package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCmt implements RowMapper<Comments>{
    
	public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comments comment = new Comments();
		comment.setId_cmt(rs.getInt("id_cmt"));
		comment.setId_product(rs.getLong("id_product"));
		comment.setName_user(rs.getString("name_user"));
		comment.setContent(rs.getString("content"));
		return comment;
	}
}
