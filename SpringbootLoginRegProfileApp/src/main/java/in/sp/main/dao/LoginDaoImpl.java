package in.sp.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.beans.Student;
import in.sp.main.mappers.StudentMappers;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate; //object created by spring boot automatically
	
	@Override
	public List<Student> loginDao(String email, String password) {
		List<Student> student_details=null;
		try {
			String mysql_query="select * from register where email=? and password=?";
			
			 student_details =jdbcTemplate.query(mysql_query,new StudentMappers(),new Object[] {email, password});
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return student_details;
	}

}
