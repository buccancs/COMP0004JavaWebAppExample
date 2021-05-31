<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>

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
    <li><a href="${pageContext.request.contextPath}/item/new">Create New Dataframe</a></li>
</ul>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>ParentID</td>
        <td>Label</td>
        <td>Description</td>
        <td>DataElements</td>
        <td>Action/Update</td>
        <td>Action/Delete</td>
    </tr>
    </thead>

    <tbody>
    <%
        List<Item> items = (List<Item>) request.getAttribute("items");
    %>
    <%
        for (Item item : items) {
    %>

    <tr>
        <td><%=item.getItemId()%></td>
        <td><%=item.getParentId()%></td>
        <td><%=item.getLabel()%></td>
        <td><%=item.getDescription()%></td>
        <td>
            <form id="requestItemsForm" action="${pageContext.request.contextPath}/dataElements" method="post">
                <input type="hidden" id="requestDataElementItemId" name="requestDataElementItemId" value=<%=item.getItemId()%> required="required" />
                <button type="submit">Items</button>
            </form>
        </td>
        <td>
            <form id="updateItemForm" action="${pageContext.request.contextPath}/item/update" method="get">
                <input type="hidden" id="updateItemId" name="updateItemId" value=<%=item.getItemId()%> required="required" />
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteItemForm" action="${pageContext.request.contextPath}/item/delete" method="post">
                <input type="hidden" id="deleteItemId" name="deleteItemId" value=<%=item.getItemId()%> required="required" />
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
