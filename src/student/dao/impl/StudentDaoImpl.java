//package student.dao.impl;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import student.dao.IStudentDao;
//import student.entity.Student;
//import student.util.DBUtil;
//
//
//public class StudentDaoImpl implements IStudentDao{
//
//	final String URL ="jdbc:mysql://localhost:3306/test1?user=root&password=123456&useUnicode=true&useSSL=true&characterEncoding=UTF-8";
//	
//
//	public boolean addStudent(Student student) {//zs 23 xa 
//		String sql ="insert into student(snumber,sname,sage,saddress) values(?,?,?,?) " ;
//		Object[] params = {student.getSnumber(),student.getSname(),student.getSage(),student.getSaddress()};
//		return DBUtil.executeUpdate(sql, params) ;
//	}
//	
//	
//	
//	public List<Student> queryAllStudents() {
//		PreparedStatement pstmt = null ;
//		Student student = null;
//		List<Student> students = new ArrayList<>();
//		ResultSet rs = null ;
//		try {
//			String sql = "select * from student" ;
//			 rs = DBUtil.executeQuery(sql, null) ;
//
//			  while(rs.next()) {
//				  int no =   rs.getInt("snumber") ;
//				  String name =   rs.getString("sname") ;
//				  int age =   rs.getInt("sage");
//				  String address = rs.getString("saddress") ;
//				  student = new Student(no,name,age,address);
//				  students.add(student) ;
//			  }
//			  return students ;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null ; 
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null ; 
//		}
//		finally {
//			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
////				try {
////					if(rs!=null)rs.close();
////					if(pstmt!=null)pstmt.close();
////					if(DBUtil.connection!=null)DBUtil.connection.close();
////				} catch (SQLException e) {
////					e.printStackTrace();
////				} 
//		}
//	}
//	
//	public boolean isExist(int sno) {
//		return queryStudentServlet(sno)==null? false:true  ;
//	}
//	
//
//	public Student queryStudentServlet(int sno) {//3
//		Student student = null;
//		Connection connection = null ;
//		 PreparedStatement pstmt = null ;
//		  ResultSet rs = null ; 
//		try {
//			Class.forName("oracle.jdbc.OracleDriver") ;
//			 connection = DriverManager.getConnection( URL) ;
//			 String sql = "select * from student where snumber =? " ;
//			  pstmt = connection.prepareStatement( sql) ;
//			  pstmt.setInt(1, sno);
//			   rs = pstmt.executeQuery() ;
//			  if(rs.next()) {
//				  int no =   rs.getInt("sno") ;
//				  String name =   rs.getString("sname") ;
//				  int age =   rs.getInt("sage");
//				  String address = rs.getString("saddress") ;
//				  student = new Student(no,name,age,address);
//			  }
//			  return student ;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			return null ; 
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null ; 
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null ; 
//		}
//		finally {
//				try {
//					if(rs!=null)rs.close();
//					if(pstmt!=null)pstmt.close();
//					if(connection!=null)connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				} 
//		}
//	}
//
//	@Override
//	public int getTotalCount() {
//		String sql = "select count(1) from student" ;
//		return DBUtil.getTotalCount(sql);
//	}
//
//
//	@Override
//	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean updateStudentServlet(int sno, Student student) {
//		String sql = "update student set sname =?,sage=?,saddress=? where snumber=?" ;
//		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
//		return DBUtil.executeUpdate(sql, params) ;
//	}
//
//
//	@Override
//	public Student queryStudentByNumber(int snumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public List<Student> queryAllStudentServlet() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public boolean deleteStudentByNumber(int snumber) {
//		String sql = "delete from student where snumber = ?" ;
//		Object[] params = {snumber} ;
//		return DBUtil.executeUpdate(sql, params) ;
//	}
//
//
//
//
//
////	@Override
////	public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
////		String sql = "select *from "
////					+"("
////				    +"select rownum r, t.* from"
////					+"(select s.* from student s order by sno asc) t "
////				    
////					+"where rownum<=?"
////					+")"
////					+ "where r>=?"
////				 ;
////		Object[] params = {currentPage*pageSize,(currentPage-1)*pageSize+1}; 
////		
////		List<Student> students = new ArrayList<>();
////		
////		ResultSet rs = DBUtil.executeQuery(sql, params) ;
////		
////		try {
////			while(rs.next()) {
////				Student student = new Student(rs.getInt("sno"),rs.getString("sname"),rs.getInt("sage"),rs.getString("saddress")) ;
////				students.add(student) ;
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}catch (Exception e) {
////			e.printStackTrace();
////		}
////		return students;
////	}
//
////	@Override
////	public boolean deleteStudentServlet(int sno) {
////		// TODO Auto-generated method stub
////		return false;
////	}
////
////	@Override
////	public Student queryStudentServlet(int sno) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//	
//
//	
//}
