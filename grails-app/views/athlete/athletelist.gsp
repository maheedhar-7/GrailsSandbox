<%--
  Created by IntelliJ IDEA.
  User: veges
  Date: 27-09-2022
  Time: 14:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body class="container-fluid">



<div class="container mt-3 mb-2">
    <div class="d-flex justify-content-between mt-2">
        <div>
            <h2 class="text-center">Athletes List</h2>
        </div>
        <div id="myDiv">${msg}</div>
        <div>
            <div class="row">
                <div class="col">
                    <g:link controller="athlete" action="edit">
                        Add Athlete
                    </g:link>
                </div>
            </div>
        </div>
    </div>

    <div class="table-responsive mt-2 mb-2">
        <table class="table table-hover mt-1 table-bordered table-sm">
            <thead class="table-dark">
            <tr>
                <th>Activity Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:render template="athleteListTemplate" model="[athletes: athletes]" />
            </tbody>
        </table>
    </div>
</div>


</body>
</html>