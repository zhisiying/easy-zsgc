<%@page import="student.entity.Page"%>
<%@page import="student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:odd").css("background-color","lightgray");
		});
	
	</script>
	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<%
		/*
			在分页显示的前提下：显示数据jsp需要哪些数据：
					当前页  currentPage
					页面大小 pageSize
					当前页的数据集合  students
					总数据 totalCount
					总页数   totalPage
							-->新建Page类，用于封装以上5个字段
		*/
	
	
	
		//error:adderror 失败
		//否则：1 确实执行了增加    2直接访问查询全部页面
		String error = (String)request.getAttribute("error") ;//addError
		if(error!=null){
			if(error.equals("addError")){
				out.print("增加失败！");
			}else if(error.equals("noaddError")){
				out.print("增加成功！");
			}//根本没有执行增加
		}	
		
	%>


		<table border="1px">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<%
				//获取request域中的数据
				Page p  = (Page)request.getAttribute("p") ;
			    List<Student> students = (List<Student>) request.getAttribute("student");
			
			
			
				for(Student student: students){
			%>
					<tr>
						<td><a href="QueryStudentServlet?snumber=<%=student.getSnumber() %>"><%=student.getSnumber() %></a>      </td>
						
						
						<td><%=student.getSname() %></td>
						<td><%=student.getSage() %></td>
						<td> <a href="DeleteStudentServlet?snumber=<%=student.getSnumber() %>   ">删除</a> </td>
						
					</tr>
			<%
				}
			
			
			%>
		
		</table>
		<a href="add.jsp">新增</a>
		
	
		
		
		
		
</body>
</html>