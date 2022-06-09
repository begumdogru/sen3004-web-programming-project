package sen3004.app4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sen3004.app4.model.SampleObject;

@Repository
public class App4Repository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
		
	
	private RowMapper<SampleObject> rowMapper = new RowMapper<SampleObject>() {

		@SuppressWarnings("unchecked")
		@Override
		public SampleObject mapRow(ResultSet rs, int rowNum) throws SQLException {
			SampleObject product = new SampleObject();
			product.setName(rs.getString("name"));
			product.setPrice(rs.getDouble("price"));
			product.setQuantity(rs.getInt("quantity"));
			product.setDate( rs.getObject("dateOfProduct", LocalDate.class));
			product.setCheckboxSelection( (List<String>) rs.getObject("checkbox"));
			
			return product;
		}
		
	};
	
	public List<SampleObject> findAll(){
		String sql = "select * from sampleobject";
		return jdbcTemplate.query(sql, rowMapper);
	};

	public void create(SampleObject product){
		String sql = "insert into sampleobject(name,price,quantity,dateOfProduct,checkbox) values(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, product.getName(),product.getPrice(), product.getQuantity(), product.getDate(), product.getCheckboxSelection());
	};
	
	public void delete( String name) {
		String sql = "delete from sampleobject where name = ?";
		jdbcTemplate.update(sql,name);
	}
	
}
