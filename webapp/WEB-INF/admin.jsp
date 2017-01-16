<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 14/12/16
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadet Helper - Admin Panel</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
    <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="col-md-10 col-md-offset-0">
    <button type="button" class="btn btn-sm btn-primary btn-create" style="margin-top: 3%; margin-left: 90%;background-color:red;border-color:darkred;">
    <a href="admin/logout">Logout</a></button>
    </div>
    <div class="row">

        <p>
        <h1 style="margin-left: 3%">Cadet Helper Admin Panel</h1><br>
        <h3>Welcome, ${userlogged.name}</h3>

        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Users</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <button type="button" class="btn btn-sm btn-primary btn-create">Create New</button>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>
                            <th><em class="fa fa-cog"></em></th>
                            <th class="hidden-xs">Role</th>
                            <th>Name</th>
                            <th>Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${users}">
                        <tr>
                            <td align="center">
                                <a class="btn btn-default" ><em class="fa fa-pencil"></em></a>
                                <a class="btn btn-danger" href="admin/${user.email}/remove"><em class="fa fa-trash"></em></a>
                            </td>
                            <td class="hidden-xs">${user.role}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="panel-footer">
                    <div class="row">
                        <!--  <div class="col col-xs-4">Page 1 of 5
                        </div>
                        <div class="col col-xs-8">
                            <ul class="pagination hidden-xs pull-right">
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                            </ul>
                            <ul class="pagination visible-xs pull-right">
                                <li><a href="#">«</a></li>
                                <li><a href="#">»</a></li>
                            </ul>
                        </div>-->
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
