package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductsDto;
import DiamonShop.Dto.ProductsDtoMapper;

@Repository
public class ProductsDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");

		return sql;
	}
	
	private StringBuffer sqlproductsearch(String name) {
		StringBuffer sql = SqlString();
		sql.append(" where p.name like '%"+name+"%'");
		
		return sql;
		
	}

	private String SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer sql = SqlString();
		sql.append("where 1 = 1 ");
		if (highLight) {
			sql.append("and p.highlight = true ");
		}
		if (newProduct) {
			sql.append("and p.new_product = true ");
		}

		sql.append("group by p.id, c.id_product ");
		sql.append("order by rand() ");
	
		if (highLight) {
			sql.append("limit 9 ");
		}
		if (newProduct) {
			sql.append("limit 12 ");
		}
		return sql.toString();
	}

	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("where 1 = 1 ");
		sql.append("and id_category = "+id+" ");

		return sql;
	}

	private String SqlProductsPaginate(int id,int start, int totalPage) {
		StringBuffer sql = SqlProductsByID(id);
		sql.append("limit " + start + ", " + totalPage);

		return sql.toString();
	}

	public List<ProductsDto> GetDataProductsDto() {
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProducts(true, false);
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;

	}

	public List<ProductsDto> GetAllProductsByID(int id) {		
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql = SqlProductsByID(id).toString();
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;

	}

	public List<ProductsDto> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<ProductsDto> listByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDtoMapper());
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if(listByID.size() > 0) {
			String sql = SqlProductsPaginate(id,start,totalPage);
			list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		}
		
		return list;

	}
	
	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("where 1 = 1 ");
		sql.append("and id_product = "+id+" ");
		sql.append("limit 1 ");

		return sql.toString();
	}

	public List<ProductsDto> GetProductsByID(long id) {
		String sql = SqlProductByID(id);
		List<ProductsDto> listProduct = _jdbcTemplate.query(sql, new ProductsDtoMapper());

		return listProduct;
	}
    
	public ProductsDto FindProductsByID(long id) {
		String sql = SqlProductByID(id);
		ProductsDto Product = _jdbcTemplate.queryForObject(sql, new ProductsDtoMapper());

		return Product;
	}
	
	public List<ProductsDto> GetProductsBySearch(String name){
		String sql = sqlproductsearch(name).toString();
		
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		
		list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}

	public List<ProductsDto> GetAllProduct() {
		String sql = SqlString().toString();
		List<ProductsDto> list = _jdbcTemplate.query(sql, new ProductsDtoMapper());
		return list;
	}
	
	public String SqlProductsPaginateSearch(String name, int start, int totalPage) {
			StringBuffer sql = sqlproductsearch(name);
			sql.append(" limit "+start+" ," +totalPage);
			
		return sql.toString();
	}
	public List<ProductsDto> GetDataProductsPaginateSearch(String name, int start, int totalPage){
		StringBuffer sql = sqlproductsearch(name);
	    
		List<ProductsDto> listSearch = _jdbcTemplate.query(sql.toString(),new ProductsDtoMapper() );
		
		if(listSearch.size() > 0) {
			listSearch = _jdbcTemplate.query(SqlProductsPaginateSearch(name, start, totalPage).toString(), new ProductsDtoMapper());
		}
		return listSearch;
	}
	
}
