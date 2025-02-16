<%@ page import="uk.ac.ucl.dataframe.SubItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<%
    int dataId = (int) request.getAttribute("dataId");
    int parentItemId = (int) request.getAttribute("parentItemId");
    int parentDataframeId = (int) request.getAttribute("parentDataframeId");
%>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/subItem/new">Create New SubItem</a></li>
        <li><a href="${pageContext.request.contextPath}/subItem/search">Search in all SubItems</a></li>
    </ul>
</div>
<div class="main">
    <form id="editSubItemForm" action="${pageContext.request.contextPath}/subItem/edit" method="post">
        <input type="hidden" id="dataId" name="dataId" value=<%=dataId%> required="required"/><br>
        <input type="hidden" id="parentItemId" name="parentItemId" value=<%=parentItemId%> required="required"/><br>
        <input type="hidden" id="parentDataframeId" name="parentDataframeId"
               value=<%=parentDataframeId%> required="required"/><br>
        <label for="dataType">dataType:</label><br>
        <input type="text" id="dataType" name="dataType" required="required"/><br>
        <label for="data">data:</label><br>
        <input type="text" id="data" name="data" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Update</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
