package student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Student;
import student.service.StudentService;


@WebServlet("/AddStudentSeverlet")
public class AddStudentSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int number =  Integer.parseInt(request.getParameter("snumber"));
		String name = request.getParameter("sname");
		 int age = Integer.parseInt(request.getParameter("sage"));
		 String address = request.getParameter("saddress");
		 Student student = new Student(number,name,age,address);
		 StudentService studentSerivice = new StudentService();
		boolean result = studentSerivice.addStudent(student);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out  = response.getWriter();
		if (result){
			response.sendRedirect("QueryAllStudentServlet");
			out.write("Success  成功  ");;
		}
		else {
			out.write(" 此人已存在");;
			
		}
	}   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
