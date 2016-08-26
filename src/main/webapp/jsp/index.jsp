<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>极客影院首页</title>

</head>
<body>		
	<div id="message">	
		<br/>
		<font size=10px>欢迎来到极客影院</font> <br />	
		<br />
		<br /> <a href="<%=request.getContextPath()%>/jsp/login.jsp">登录</a>
		<br /> <br />
		<br /> <a href="<%=request.getContextPath()%>/jsp/show.jsp">电影展示</a>
		<br /> <br />
		<br /> <a href="<%=request.getContextPath()%>/jsp/insert.jsp">电影增加</a>
		
	</div>
</body>
</html>