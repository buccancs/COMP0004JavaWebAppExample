<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
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
        <div>
            <ul class="nav">
                <li><a href="dataframes">Home</a></li>
                <li><a href="dataframe/new">Create New Dataframe</a></li>
            </ul>
        </div>
        <div class="main">
            <form id="updateDataframeForm" action="dataframe/update" method="post">
                <label for="newDataframeId">newDataframeId:</label><br>
                <input type="text" id="newDataframeId" name="newDataframeId" required="required"/><br>
                <label for="label">label:</label><br>
                <input type="text" id="label" name="label" required="required" /><br>
                <label for="description">description:</label><br>
                <input type="text" id="description" name="description" required="required" /><br>
                <div class="form-actions"><br>
                    <button type="submit" class="btn btn-primary"> <i class="icon-ok icon-white"></i> Create</button>
                    <button type="button" class="btn" onclick="history.go(-1)"><i class="icon-remove"></i> Cancel</button>
                </div>
            </form>
        </div>
    </body>
</html>
