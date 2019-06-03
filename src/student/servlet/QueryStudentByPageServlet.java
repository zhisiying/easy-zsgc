package student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.entity.Page;
import student.entity.Student;
import student.service.StudentService;


public class QueryStudentByPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public QueryStudentByPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 StudentService studentSerivice = new StudentService();
		int count = studentSerivice.getTotalCount() ;//数据总数
		
		//将分页所需的5个字段（其中有1个自动计算，因此实际只需要组装4个即可），组装到page对象之中
		Page page = new Page();
		
		
		String cPage = request.getParameter("currentPage")  ;//
		
	
		
		if(cPage == null) {
			cPage = "1" ;
		}
		
	
		
		int currentPage = Integer.parseInt( cPage );
		page.setCurrentPage(currentPage);
//		int currentPage = 2;//页码
		
		//注意 顺序
		int totalCount = studentSerivice.getTotalCount() ;//总数据数
		page.setTotalCount(totalCount);
		
		/* currentPage：当前页（页码）  
	  	 students :当前页的数据集合（当前页的所有学生）
		
		*/
		int pageSize = 3;
		page.setPageSize(pageSize);
		List<Student>  students  = studentSerivice.queryStudentsByPage(currentPage, pageSize) ;
		System.out.println(students);
		System.out.println(count);
		
		
	
		
		page.setStudents(students);
		request.setAttribute("p", page);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
