<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
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
            <option value=<%=dataframe.getDataframeId()%>><%=dataframe.getDataframeId()%>
            </option>
            <%
                }
            %>
        </select><br>

        <label for="itemId">itemId:</label><br>
        <input type="text" id="itemId" name="itemId" required="required"/><br>
        <label for="label">label:</label><br>
        <input type="text" id="label" name="label" required="required"/><br>
        <label for="description">description:</label><br>
        <input type="text" id="description" name="description" required="required"/><br>
        <label for="group">group:</label><br>
        <input type="text" id="group" name="group" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
