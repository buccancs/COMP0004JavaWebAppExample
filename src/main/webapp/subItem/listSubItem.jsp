<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>
<%@ page import="uk.ac.ucl.dataframe.SubItem" %>
<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/subItem/new">Create New SubItem</a></li>
    <li><a href="${pageContext.request.contextPath}/subItem/search">Search in all SubItems</a></li>
</ul>

<table>
    <thead>
    <tr>
        <td>DataID</td>
        <td>DataType/Label</td>
        <td>Data</td>
        <td>Action/Update</td>
        <td>Action/Delete</td>
    </tr>
    </thead>

    <tbody>
    <%
        List<SubItem> subItems = (List<SubItem>) request.getAttribute("subItems");
    %>
    <%
        for (SubItem subItem : subItems) {
    %>

    <tr>
        <td><%=subItem.getDataId()%>
        </td>
        <td><%=subItem.getDataType()%>
        </td>
        <td><%=subItem.getData()%>
        </td>
        <td>
            <form id="editItemForm" action="${pageContext.request.contextPath}/subItem/edit" method="get">
                <input type="hidden" id="editSubItemId" name="editSubItemId"
                       value=<%=subItem.getDataId()%> required="required"/>
                <input type="hidden" id="editParentItemId" name="editParentItemId"
                       value=<%=subItem.getParentItemId()%> required="required"/>
                <input type="hidden" id="editParentDataframeId" name="editParentDataframeId"
                       value=<%=subItem.getParentDataframeId()%> required="required"/>
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteItemForm" action="${pageContext.request.contextPath}/subItem/delete" method="post">
                <input type="hidden" id="deleteSubItemId" name="deleteSubItemId"
                       value=<%=subItem.getDataId()%> required="required"/>
                <input type="hidden" id="deleteParentItemId" name="deleteParentItemId"
                       value=<%=subItem.getParentItemId()%> required="required"/>
                <input type="hidden" id="deleteParentDataframeId" name="deleteParentDataframeId"
                       value=<%=subItem.getParentDataframeId()%> required="required"/>
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
