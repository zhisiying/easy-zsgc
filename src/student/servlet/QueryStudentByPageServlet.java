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
		int count = studentSerivice.getTotalCount() ;//��������
		
		//����ҳ�����5���ֶΣ�������1���Զ����㣬���ʵ��ֻ��Ҫ��װ4�����ɣ�����װ��page����֮��
		Page page = new Page();
		
		
		String cPage = request.getParameter("currentPage")  ;//
		
	
		
		if(cPage == null) {
			cPage = "1" ;
		}
		
	
		
		int currentPage = Integer.parseInt( cPage );
		page.setCurrentPage(currentPage);
//		int currentPage = 2;//ҳ��
		
		//ע�� ˳��
		int totalCount = studentSerivice.getTotalCount() ;//��������
		page.setTotalCount(totalCount);
		
		/* currentPage����ǰҳ��ҳ�룩  
	  	 students :��ǰҳ�����ݼ��ϣ���ǰҳ������ѧ����
		
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
