package in.sp.main.dao;

import java.util.List;

import in.sp.main.beans.Student;

public interface LoginDao {
	
	public List<Student> loginDao(String email,String password);
	
		
	

}
