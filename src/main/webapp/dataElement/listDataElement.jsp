<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>
<%@ page import="uk.ac.ucl.dataframe.DataElement" %>

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
<ul>
    <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/dataElement/new">Create New DataElement</a></li>
</ul>

<table>
    <thead>
    <tr>
        <td>DataID</td>
        <td>DataType</td>
        <td>Data</td>
        <td>Action/Update</td>
        <td>Action/Delete</td>
    </tr>
    </thead>

    <tbody>
    <%
        List<DataElement> dataElements = (List<DataElement>) request.getAttribute("dataElements");
    %>
    <%
        for (DataElement dataElement : dataElements) {
    %>

    <tr>
        <td><%=dataElement.getDataId()%></td>
        <td><%=dataElement.getDataType()%></td>
        <td><%=dataElement.getData()%></td>
        <td>
            <form id="updateItemForm" action="${pageContext.request.contextPath}/item/update" method="get">
                <input type="hidden" id="updateItemId" name="updateItemId" value=<%=dataElement.getDataId()%> required="required" />
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteItemForm" action="${pageContext.request.contextPath}/item/delete" method="post">
                <input type="hidden" id="deleteItemId" name="deleteItemId" value=<%=dataElement.getDataId()%> required="required" />
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
