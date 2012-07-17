<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form:form method="POST" commandName="product" style="padding:8px">
    <p>
        Description<br/>
        <form:input path="description"/>
    </p>
    <p>
        Price<br/>
        <form:input path="price"/>
    </p>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
