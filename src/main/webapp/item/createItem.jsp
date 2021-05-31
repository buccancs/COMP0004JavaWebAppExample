<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row">
        <div class="span9">
            <div class="well">
                <div class="page-header">
                    <h1>Create a new todo</h1>
                </div>

                <form id="createItemForm" action="${pageContext.request.contextPath}/items/new" method="post" class="form-horizontal">

                    <fieldset>

                        <div class="control-group">
                            <label class="control-label" for="itemId">itemId:</label>
                            <div class="controls">
                                <input type="text" id="itemId" name="itemId" required="required" autofocus="autofocus" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="parentId">parentId:</label>
                            <div class="controls">
                                <input type="text" id="parentId" name="parentId" required="required" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="label">label:</label>
                            <div class="controls">
                                <input type="text" id="label" name="label" required="required" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="description">description:</label>
                            <div class="controls">
                                <input type="text" id="description" name="description" required="required" />
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label" for="group">group:</label>
                            <div class="controls">
                                <input type="text" id="group" name="group" required="required" />
                            </div>
                        </div>

                        <div class="form-actions">
                            <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Create</button>
                            <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                        </div>

                    </fieldset>

                </form>

            </div>
        </div>
    </div>
</div>
