<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	</head>

	<body>
		欢迎登陆！<br>
		<form action="user/login.do" method="post">
			用户名:<input type="text" name="userName"><br>
			密&nbsp;&nbsp;&nbsp;码:<input type="password" name="passWord"><br>
			<input type="submit" name="submit" value="登陆"><br>
		</form>
	</body>
</html>
