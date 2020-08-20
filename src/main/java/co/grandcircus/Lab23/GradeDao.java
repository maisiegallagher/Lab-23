package co.grandcircus.Lab23;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class GradeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// METHOD #1
	public List<Grade> findAll() {
		
		return jdbcTemplate.query("SELECT * FROM grade", new BeanPropertyRowMapper<>(Grade.class));
	}
	

	// METHOD #2
	public Grade findById(Long id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		Grade match = jdbcTemplate.queryForObject("SELECT * FROM grade WHERE id = ?", new BeanPropertyRowMapper<>(Grade.class), id);
		// If nothing matched, match will be null.
		return match;
	}
	
	
	// METHOD #3
	public void create(Grade grade) {
		String sql = "INSERT INTO grade (name, type, score, total) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, grade.getName(), grade.getType(), grade.getScore(), grade.getTotal());
	}
	
	
	// METHOD #4
	public void delete(Long id) {
		String sql = "DELETE FROM grade WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
}
