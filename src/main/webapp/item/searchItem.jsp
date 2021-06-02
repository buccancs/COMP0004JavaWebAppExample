<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Item</a></li>
        <li><a href="${pageContext.request.contextPath}/item/search">Search in all Items</a></li>
    </ul>
</div>
<div>
    <form id="searchItemForm" action="${pageContext.request.contextPath}/item/search" method="post">
        <label for="searchTerm">Search in Items:</label><br>
        <input type="text" id="searchTerm" name="searchTerm" required="required"/><br>
            <button type="submit">Search</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
    </form>
</div>
</body>
</html>