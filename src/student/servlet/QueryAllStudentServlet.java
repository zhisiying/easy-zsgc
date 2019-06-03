package student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Student;
import student.service.StudentService;

/**
 * Servlet implementation class QueryAllStudentServiet
 */
@WebServlet("/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 StudentService studentSerivice = new StudentService();
		 List<Student> student = studentSerivice.queryAllStudents();
		 System.out.print(student);
		 request.setAttribute("student", student);
		 request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
