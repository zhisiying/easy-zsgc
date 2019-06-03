package student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.StudentService;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		int no =  Integer.parseInt(request.getParameter("snumber"));
		StudentService service= new StudentService();
		boolean result = service.deleteStudentBySno(no);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if (result) {
		
			response.sendRedirect("QueryAllStudentServlet");
			response.getWriter().print("É¾³ý³É¹¦");
		}
		else{
			response.getWriter().print("É¾³ýÊ§°Ü");
		}
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
