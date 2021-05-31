<%--
  Created by IntelliJ IDEA.
  User: Duy An Tran
  Date: 5/30/2021
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Update Item</h1>
                </div>

                <form id="updateITemForm " action="${pageContext.request.contextPath}/?item={id}/update" method="post" class="form-horizontal">

                    <fieldset>

                        <div class="control-group">
                            <label class="control-label" for="itemId">itemId:</label>
                            <div class="controls">
                                <input type="text" id="itemId" name="itemId" value="${requestScope.item.itemId}" disabled="disabled"/>
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="label">label:</label>
                            <div class="controls">
                                <input type="text" id="label" name="title" value="${requestScope.item.label}" required="required" autofocus="autofocus" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="description">description:</label>
                            <div class="controls">
                                <input type="text" id="description" name="description" value="${requestScope.item.description}" required="required" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="status">Status:</label>
                            <div class="controls">
                                <select id="status" name="status">
                                    <option value="false">Todo</option>
                                    <option value="true">Done</option>
                                </select>
                            </div>
                        </div>


                        <input type="hidden" name="parentId" value="${requestScope.item.parentId}"/>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-refresh icon-white"></i> Update</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>

                </form>

            </div>
        </div>
    </div>
</div>
</body>
</html>
