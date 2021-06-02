<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
    </ul>
</div>
<div>
    <form id="searchItemForm" action="${pageContext.request.contextPath}/search" method="post">
        <label for="dataStructure">Choose in which Data Structure you want to search:</label><br>
        <select id="dataStructure" name="dataStructure">
            <option value="dataframe">Dataframes</option>
            <option value="item">Items</option>
            <option value="subItem">SubItems</option>
        </select><br>
        <label for="searchTerm">Search term:</label><br>
        <input type="text" id="searchTerm" name="searchTerm" required="required"/><br>
        <button type="submit">Search</button>
        <button type="button" onclick="history.go(-1)">Cancel</button>
    </form>
</div>
</body>
</html>