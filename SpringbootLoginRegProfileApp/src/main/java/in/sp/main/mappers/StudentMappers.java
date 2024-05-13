package in.sp.main.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.sp.main.beans.Student;

public class StudentMappers implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		String name1=rs.getString("name");
		String email1=rs.getString("email");
		String pass11=rs.getString("password");
		String gender1=rs.getString("gender");
		String city1=rs.getString("city");
		
		Student std= new Student();
		std.setName(name1);
		std.setEmail(email1);
		std.setPassword(pass11);
		std.setGender(gender1);
		std.setCity(city1);
		
		return std;
	}

}
