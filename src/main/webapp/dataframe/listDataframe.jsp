<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>

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
    <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Dataframe</a></li>
</ul>

<table >
    <thead>
    <tr>
        <td>ID</td>
        <td>Label</td>
        <td>Description</td>
        <td>Items</td>
        <td>Action/Update</td>
        <td>Action/Delete</td>
    </tr>
    </thead>
    <tbody>
    <%
        List<Dataframe> dataframes = (List<Dataframe>) request.getAttribute("dataframes");
    %>
    <%
        for (Dataframe dataframe : dataframes) {
    %>
    <tr>
        <td><%=dataframe.getDataFrameId()%></td>
        <td><%=dataframe.getLabel()%></td>
        <td><%=dataframe.getDescription()%></td>
        <td>
            <form id="requestItemsForm" action="${pageContext.request.contextPath}/items" method="get">
                <input type="hidden" id="requestItemsDataframeId" name="requestItemsDataframeId" value=<%=dataframe.getDataFrameId()%> required="required" />
                <button type="submit">Items</button>
            </form>
        </td>
        <td>
            <form id="updateDataframeForm" action="${pageContext.request.contextPath}/dataframe/update" method="get">
                <input type="hidden" id="updateDataframeId" name="updateDataframeId" value=<%=dataframe.getDataFrameId()%> required="required" />
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteDataframeForm" action="${pageContext.request.contextPath}/dataframe/delete" method="post">
                <input type="hidden" id="deleteDataframeId" name="deleteDataframeId" value=<%=dataframe.getDataFrameId()%> required="required" />
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
