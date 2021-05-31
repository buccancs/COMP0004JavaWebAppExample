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
            <form id="updateItemForm" action="${pageContext.request.contextPath}/dataElement/update" method="get">
                <input type="hidden" id="updateDataElementId" name="updateDataElementId" value=<%=dataElement.getDataId()%> required="required" />
                <input type="hidden" id="updateParentItemId" name="updateParentItemId" value=<%=dataElement.getParentItemId()%> required="required" />
                <input type="hidden" id="updateParentDataframeId" name="updateParentDataframeId" value=<%=dataElement.getParentDataframeId()%> required="required" />
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteItemForm" action="${pageContext.request.contextPath}/dataElement/delete" method="post">
                <input type="hidden" id="deleteDataElementId" name="deleteDataElementId" value=<%=dataElement.getDataId()%> required="required" />
                <input type="hidden" id="deleteParentItemId" name="deleteParentItemId" value=<%=dataElement.getParentItemId()%> required="required" />
                <input type="hidden" id="deleteParentDataframeId" name="deleteParentDataframeId" value=<%=dataElement.getParentDataframeId()%> required="required" />
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
