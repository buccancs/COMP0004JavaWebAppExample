<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>

<html>
<head>
    <title>Item Storage</title>
    <link href="../styles.css" rel="stylesheet">
</head>
<body>
<div>
    <ul>
        <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/subItem/new">Create New SubItem</a></li>
        <li><a href="${pageContext.request.contextPath}/subItem/search">Search in all Dataframes</a></li>
    </ul>
</div>
<%
    List<Dataframe> dataframes = (List<Dataframe>) request.getAttribute("dataframes");
%>
<div>
    <form id="createItemForm" action="${pageContext.request.contextPath}/subItem/new" method="post">

        <label for="parentItemId">Choose your item to assign to:</label><br>
        <select name="parentItemId" id="parentItemId">
            <%
                for (Dataframe dataframe : dataframes) {
            %>
            <optgroup label="DataframeId: <%=dataframe.getDataframeId()%>">
            <%
                for (Item item : dataframe.getItems()){
            %>
                <option value=<%=item.getItemId()%>><%=item.getItemId()%></option>
            <%
                }
            %>
            </optgroup>
            <%
                }
            %>
        </select><br>
        <label for="parentDataframeId">Choose your parent DF of your selected Item:</label><br>
        <select name="parentDataframeId" id="parentDataframeId">
            <%
                for (Dataframe dataframe : dataframes) {
            %>
            <option value=<%=dataframe.getDataframeId()%>><%=dataframe.getDataframeId()%></option>
            <%
                }
            %>
        </select><br>
        <label for="dataId">dataId:</label><br>
        <input type="text" id="dataId" name="dataId" required="required"/><br>
        <label for="dataType">dataType:</label><br>
        <input type="text" id="dataType" name="dataType" required="required"/><br>
        <label for="data">data:</label><br>
        <input type="text" id="data" name="data" required="required"/><br>
        <div class="form-actions"><br>
            <button type="submit">Create</button>
            <button type="button" onclick="history.go(-1)">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>
