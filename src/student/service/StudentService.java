package student.service;

import java.util.List;


import student.dao.StudentDao;
import student.entity.Student;
import student.service.StudentService;

//ҵ���߼��㣺�߼��Ե���ɾ�Ĳ飨 ������+����  ����dao����е���װ
public class StudentService{
	StudentDao studentDao = new StudentDao();
	//����ѧ�Ų�ѯѧ��
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//��ѯȫ��ѧ��
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
		if(!studentDao.isExist(student.getSnumber())) {//������
			
			return studentDao.addStudent(student) ; 
		}else {
			System.out.println("�����Ѵ��ڣ�");
			return false ;
		}
	}
	//��ѯ��ǰҳ�����ݼ���
	
	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
		return studentDao.queryStudentsByPage(currentPage, pageSize);
	}
	
	public int getTotalCount() {
		return studentDao.getTotalCount();
	}
}
