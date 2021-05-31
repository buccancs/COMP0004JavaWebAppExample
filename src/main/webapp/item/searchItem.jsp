<%--
  Created by IntelliJ IDEA.
  User: Duy An Tran
  Date: 5/30/2021
  Time: 5:14 AM
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
                    <h1>Search results for title: '${param.title}' </h1>
                </div>

                <table class="table table-bordered table-striped">

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Label</th>
                        <th>Description</th>
                        <th>Search</th>
                        <th>Tags</th>
                        <th>Items</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${requestScope.todoList}" var="currentTodo">
                        <tr>
                            <td>${currentTodo.id}</td>
                            <td><tl:highlight pattern="${param.title}" cssClass="label label-warning">${currentTodo.title}</tl:highlight></td>
                            <td><fmt:formatDate value="${currentTodo.dueDate}" pattern="dd/MM/yyyy"/></td>
                            <td><i class="icon-circle-arrow-<tl:priorityIcon priority="${currentTodo.priority}"/>"></i> ${currentTodo.priority}</td>
                            <td><span class="label <tl:statusStyle status="${currentTodo.done}"/> "> <tl:statusLabel status="${currentTodo.done}"/></span></td>
                            <td>
                                <a class="btn btn-mini btn-primary" href="/todos/update?todoId=${currentTodo.id}"><i class="icon-edit icon-white"></i> Edit</a>
                                <a class="btn btn-mini btn-danger" data-toggle="modal" href="#confirm_delete_${currentTodo.id}"><i class="icon-remove icon-white"></i> Delete</a>
                                <div class="modal hide" id="confirm_delete_${currentTodo.id}">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">×</button>
                                        <h3>Confirmation</h3>
                                    </div>
                                    <div class="modal-body">
                                        <p>Are you sure to delete todo ${currentTodo.id} '${currentTodo.title}' ?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <form action="/todos/delete.do" method="post">
                                            <input type="hidden" name="todoId" value="${currentTodo.id}">
                                            <a href="#" class="btn" data-dismiss="modal">Cancel</a> <button type="submit" class="btn btn-primary">Confirm</button>
                                        </form>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

                <c:if test="${empty requestScope.todoList}">
                    <div class="alert alert-info">
                        <div align="center">No todo with title '${param.title}'</div>
                    </div>
                </c:if>

                <c:if test="${not empty requestScope.todoList}">
                    <div align="center">
                        <button class="btn" onclick="javascript:window.print()">
                            <i class="icon-print"></i>
                            Print todo list
                        </button>
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>
</body>
</html>
