<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Page</title>
</head>
<body>
<h3>user list here:</h3>
<a href="add">add user</a><br>
<c:forEach items="${user }" var="u">
name:<a href="${u.value.name }">${u.value.name}</a>-
sex:${u.value.sex }-
age:${u.value.age }-
Email:${u.value.email }-
<a href="${u.value.name }/update">update</a>-
<a href="${u.value.name }/delete">delete</a>
<br>

</c:forEach>

</body>
</html>