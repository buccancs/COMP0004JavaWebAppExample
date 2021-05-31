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
        <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Dataframe</a></li>
    </ul>
</div>
<div>
    <form id="createDataframeForm" action="${pageContext.request.contextPath}/dataframe/new" method="post">
        <label for="dataframeId">dataframeId:</label><br>
        <input type="text" id="dataframeId" name="dataframeId" required="required"/><br>
        <label for="label">label:</label><br>
        <input type="text" id="label" name="label" required="required"/><br>
        <label for="description">description:</label><br>
        <input type="text" id="description" name="description" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
