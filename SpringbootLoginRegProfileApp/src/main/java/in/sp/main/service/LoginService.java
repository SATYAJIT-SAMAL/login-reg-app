package in.sp.main.service;

import java.util.List;

import in.sp.main.beans.Student;

public interface LoginService {
	public List<Student> loginService(String email, String password);

}
