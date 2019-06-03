package student.service;

import java.util.List;


import student.dao.StudentDao;
import student.entity.Student;
import student.service.StudentService;

//业务逻辑层：逻辑性的增删改查（ 增：查+增）  ，对dao层进行的组装
public class StudentService{
	StudentDao studentDao = new StudentDao();
	//根据学号查询学生
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//查询全部学生
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents() ;
	}
	
	public boolean updateStudentBySno(int sno, Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student) ;
		}
		return false ;
	}	
	
	public boolean deleteStudentBySno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno) ;
		}
			return false ;
	}
	
	public boolean addStudent(Student student) {
		if(!studentDao.isExist(student.getSnumber())) {//不存在
			
			return studentDao.addStudent(student) ; 
		}else {
			System.out.println("此人已存在！");
			return false ;
		}
	}
	//查询当前页的数据集合
	
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
}
