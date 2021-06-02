<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>

<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<ul>
    <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Dataframe</a></li>
    <li><a href="${pageContext.request.contextPath}/dataframe/search">Search in all Dataframes</a></li>
</ul>

<table>
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
        <td><%=dataframe.getDataframeId()%>
        </td>
        <td><%=dataframe.getLabel()%>
        </td>
        <td><%=dataframe.getDescription()%>
        </td>
        <td>
            <form id="requestItemsForm" action="${pageContext.request.contextPath}/items" method="get">
                <input type="hidden" id="requestItemsDataframeId" name="requestItemsDataframeId"
                       value=<%=dataframe.getDataframeId()%> required="required"/>
                <button type="submit">Items</button>
            </form>
        </td>
        <td>
            <form id="editDataframeForm" action="${pageContext.request.contextPath}/dataframe/edit" method="get">
                <input type="hidden" id="editDataframeId" name="editDataframeId"
                       value=<%=dataframe.getDataframeId()%> required="required"/>
                <button type="submit">Update</button>
            </form>
        </td>
        <td>
            <form id="deleteDataframeForm" action="${pageContext.request.contextPath}/dataframe/delete" method="post">
                <input type="hidden" id="deleteDataframeId" name="deleteDataframeId"
                       value=<%=dataframe.getDataframeId()%> required="required"/>
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
