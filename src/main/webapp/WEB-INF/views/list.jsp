<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing Products</h1>
<c:forEach items="${products}" var="prd">
	<a href="edit?id=${prd.id}">${prd.id} -
	${prd.description} ${prd.price}</a>
	<br />
</c:forEach>
<a href="edit"> Add Product</a>
</body>
</html>
