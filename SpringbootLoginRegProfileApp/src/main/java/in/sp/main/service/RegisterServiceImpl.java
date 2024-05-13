package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.beans.Student;
import in.sp.main.dao.RegisterDao;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	RegisterDao registerDao;
	
	@Override
	public boolean registerService(Student std) {
		
		boolean status=registerDao.registerDao(std);
		
		return status;
	}

}
