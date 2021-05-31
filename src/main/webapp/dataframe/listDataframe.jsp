<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="uk.ac.ucl.dataframe.Item" %>
<%@ page import="uk.ac.ucl.dataframe.Dataframe" %>
<html lang="en">
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
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <ul class="nav">
                    <li><a href="${pageContext.request.contextPath}/dataframes">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/dataframe/new">Create New Dataframe</a></li>
                </ul>
            </div>
        </div>
    </div>

        <table class="table table-bordered table-striped">

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
                <td><a href="${pageContext.request.contextPath}/items?dataframeId=<%=dataframe.getDataFrameId()%>"> Items</a></td>
                <td><a href="${pageContext.request.contextPath}/dataframe/update?dataframeId=<%=dataframe.getDataFrameId()%>"> Update</a></td>
                <td><a href="${pageContext.request.contextPath}/dataframe/delete?dataframeId=<%=dataframe.getDataFrameId()%>"> Delete</a></td>
            </tr>

            <%
                }
            %>

            </tbody>
        </table>
    </body>
</html>
