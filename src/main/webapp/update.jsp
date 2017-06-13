<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update user page</title>
</head>
<body>
<h3>update user</h3>
<sf:form method="post" modelAttribute="user">
name:<sf:input path="name"/>
sex:<sf:input path="sex"/>
age:<sf:input path="age"/>
email:<sf:input path="email"/>
<input type="submit" value="update">
</sf:form>
</body>
</html>