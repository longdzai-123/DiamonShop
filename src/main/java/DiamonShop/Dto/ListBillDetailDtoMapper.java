package DiamonShop.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ListBillDetailDtoMapper implements RowMapper<ListBillDetailDto>{
	public ListBillDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		ListBillDetailDto listBillDetailDto = new ListBillDetailDto();
		listBillDetailDto.setId_product(rs.getLong("id_product"));
		listBillDetailDto.setName(rs.getString("name"));
		listBillDetailDto.setPrice(rs.getDouble("price"));
		listBillDetailDto.setQuanty(rs.getInt("quanty"));
		listBillDetailDto.setTotal(rs.getDouble("total"));
		listBillDetailDto.setImg(rs.getString("img"));
		return listBillDetailDto;
	}

}
