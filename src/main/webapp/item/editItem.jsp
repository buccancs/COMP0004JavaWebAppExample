<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/item/new">Create New Item</a></li>
        <li><a href="${pageContext.request.contextPath}/item/search">Search in all Items</a></li>
    </ul>
</div>
<%
    List<Dataframe> dataframes = (List<Dataframe>) request.getAttribute("dataframes");
%>
<div>
    <form id="editItemForm" action="${pageContext.request.contextPath}/item/edit" method="post">

        <label for="newParentId">Choose your dataframe to assign to:</label><br>
        <select name="newParentId" id="newParentId">
            <%
                for (Dataframe dataframe : dataframes) {
            %>
            <option value=<%=dataframe.getDataframeId()%>><%=dataframe.getDataframeId()%>
            </option>
            <%
                }
            %>
        </select><br>

        <input type="hidden" id="itemId" name="itemId"
               value=<%=request.getAttribute("editItemId")%> required="required"/>
        <input type="hidden" id="parentId" name="parentId"
               value=<%=request.getAttribute("editItemParentId")%> required="required"/>
        <label for="label">label:</label><br>
        <input type="text" id="label" name="label" required="required"/><br>
        <label for="description">description:</label><br>
        <input type="text" id="description" name="description" required="required"/><br>
        <label for="group">group:</label><br>
        <input type="text" id="group" name="group" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
