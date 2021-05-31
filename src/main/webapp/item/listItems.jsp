<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>

<html>
<head>
    <title>Item List</title>
</head>
    <thead>
        <tr>
            <th>ID</th>
            <th>Label</th>
            <th>Description</th>
            <th>Group</th>
            <th>Items</th>
            <th>Action</th>
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
            <td><%=item.getLabel()%></td>
            <td><%=item.getDescription()%></td>
            <td><%=item.getGroup()%></td>
            <td>DataElements</td>
        </tr>
    <%
        }
    %>
    </tbody>
</html>
