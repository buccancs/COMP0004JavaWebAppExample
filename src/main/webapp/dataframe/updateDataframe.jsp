<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Item Storage</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Dataframe</a></li>
    </ul>
</div>
<div class="main">
    <form id="updateDataframeForm" action="${pageContext.request.contextPath}/dataframe/update" method="post">
        <input type="hidden" id="dataframeId" name="dataframeId"
               value=<%=request.getAttribute("dataframeId")%> required="required"/>
        <label for="label">label:</label><br>
        <input type="text" id="label" name="label" required="required"/><br>
        <label for="description">description:</label><br>
        <input type="text" id="description" name="description" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Update</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
