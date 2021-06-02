<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Return</a></li>
    </ul>
</div>
<h2>An error occurred!</h2>
<div>
    <p>
        <%
            String e = (String) request.getAttribute("e");
            System.out.println(e);
        %>
        <%=e%>
    </p>
</div>
</body>
</html>
