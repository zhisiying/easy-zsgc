<%@page import="student.entity.Student"%>
<%@page import="java.util.List"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		
		Student students = (Student)request.getAttribute("student") ;
		
		%>
		<!--  通过表单展示此人信息 -->
		<form action="UpdateStudentServlet" method="post" >
		用户账号：<input type="text" name="snumber" id="snumber" value="<%=students.getSnumber()%>" readonly="readonly" /><br/>
		姓名:<input type="text" name="sname"id="sname"  value="<%=students.getSname()%>" /><br>
		年龄:<input type="text" name="sage"id="sage" value="<%=students.getSage()%>" /><br>
		地址:<input type="text" name="saddress" id="saddress" value="<%=students.getSaddress()%>" /><br>
        <button  type="submit" method="post">修改</button>
				
		</form>


</body>
</html>