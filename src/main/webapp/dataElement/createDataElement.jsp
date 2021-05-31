<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>

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
        <li><a href="${pageContext.request.contextPath}/dataElement/new">Create New DataElement</a></li>
    </ul>
</div>
<div>
    <form id="createItemForm" action="${pageContext.request.contextPath}/dataElement/new" method="post">

        <label for="parentDataframeId">Choose your dataframe to assign to:</label><br>
        <select name="parentDataframeId" id="parentDataframeId">
            <%
                for (Dataframe dataframe : dataframes) {
            %>
            <option value=<%=dataframe.getDataframeId()%>><%=dataframe.getDataframeId()%></option>
            <%
                }
            %>
        </select><br>
        <label for="parentItemId">Choose your item to assign to:</label><br>
        <select name="parentItemId" id="parentItemId">
            <%
                for (Dataframe dataframe : dataframes) {
                    for (Item item: dataframe.getItems()){
            %>
            <option value=<%=item.getItemId()%>><%=item.getItemId()%></option>
            <%
                }  }
            %>
        </select><br>
        <label for="dataId">dataId:</label><br>
        <input type="text" id="dataId" name="dataId" required="required" /><br>
        <label for="dataType">dataType:</label><br>
        <input type="text" id="dataType" name="dataType" required="required" /><br>
        <label for="data">data:</label><br>
        <input type="text" id="data" name="data" required="required" /><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
