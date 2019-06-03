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


@WebServlet("/QueryStudentServlet")
public class QueryStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int number =  Integer.parseInt(request.getParameter("snumber"));
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();// œÏ”¶∂‘œÛ
		 StudentService studentSerivice = new StudentService();
		Student student = studentSerivice.queryStudentBySno(number) ;
		 out.println(number);
		 request.setAttribute("student", student);
		 request.getRequestDispatcher("/test1.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
