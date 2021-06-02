<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>

<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/item/new">Create New Item</a></li>
    <li><a href="${pageContext.request.contextPath}/item/search">Search in all Items</a></li>
</ul>

<table>
    <thead>
    <tr>
        <td>ID</td>
        <td>ParentID</td>
        <td>Label</td>
        <td>Description</td>
        <td>SubItems</td>
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
        <td><%=item.getItemId()%>
        </td>
        <td><%=item.getParentId()%>
        </td>
        <td><%=item.getLabel()%>
        </td>
        <td><%=item.getDescription()%>
        </td>
        <td>
            <form id="requestItemsForm" action="${pageContext.request.contextPath}/subItems" method="get">
                <input type="hidden" id="parentItemId" name="parentItemId"
                       value=<%=item.getItemId()%> required="required"/>
                <input type="hidden" id="parentDataframeId" name="parentDataframeId"
                       value=<%=item.getParentId()%> required="required"/>
                <button type="submit">Items</button>
            </form>
        </td>
        <td>
            <form id="editItemForm" action="${pageContext.request.contextPath}/item/edit" method="get">
                <input type="hidden" id="editItemId" name="editItemId"
                       value=<%=item.getItemId()%> required="required"/>
                <input type="hidden" id="editItemParentId" name="editItemParentId"
                       value=<%=item.getParentId()%> required="required"/>
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteItemForm" action="${pageContext.request.contextPath}/item/delete" method="post">
                <input type="hidden" id="deleteItemId" name="deleteItemId"
                       value=<%=item.getItemId()%> required="required"/>
                <input type="hidden" id="deleteItemParentId" name="deleteItemParentId"
                       value=<%=item.getParentId()%> required="required"/>
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
