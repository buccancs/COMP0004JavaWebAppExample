<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>

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
<%
    List<Dataframe> dataframes = (List<Dataframe>) request.getAttribute("dataframes");
%>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/item/new">Create New Item</a></li>
    </ul>
</div>
<div>
    <form id="createItemForm" action="${pageContext.request.contextPath}/item/new" method="post">

        <label for="parentId">Choose your dataframe to assign to:</label><br>
        <select name="parentId" id="parentId">
            <%
                for (Dataframe dataframe : dataframes) {
            %>
            <option value=<%=dataframe.getDataFrameId()%>><%=dataframe.getDataFrameId()%></option>
            <%
                }
            %>
        </select><br>

        <label for="itemId">itemId:</label><br>
        <input type="text" id="itemId" name="itemId" required="required"/><br>
        <label for="label">label:</label><br>
        <input type="text" id="label" name="label" required="required" /><br>
        <label for="description">description:</label><br>
        <input type="text" id="description" name="description" required="required" /><br>
        <label for="group">group:</label><br>
        <input type="text" id="group" name="group" required="required" /><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
