package student.servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.StudentService;
import student.entity.Student;


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no =  Integer.parseInt(request.getParameter("snumber"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("sddress");
		Student student= new Student(name,age,address);
		 StudentService studentSerivice = new StudentService();
		 boolean result = studentSerivice.updateStudentBySno(no, student);
		 response.setContentType("text/html; charset=UTF-8");
		 response.setCharacterEncoding("utf-8");
		 PrintWriter out  = response.getWriter();
			if (result){
			
				 response.sendRedirect("QueryAllStudentServlet");
			}
			else {
				out.write("fail  Ê§°Ü ");;
				
			}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
