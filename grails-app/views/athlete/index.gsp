<%--
  Created by IntelliJ IDEA.
  User: veges
  Date: 22-09-2022
  Time: 09:04
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<div class="container mt-2 mb-2">
    <div>
        <h2 class="text-center">Athlete</h2>
    </div>
    <table class="table" mt-2>
        <thead class="table-dark">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E mail</th>
            <th>Phone Number</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${login.athlete.firstName}</td>
            <td>${login.athlete.lastName}</td>
            <td>${login.athlete.email}</td>
            <td>${login.athlete.phoneNumber}</td>
        </tr>
        </tbody>
    </table>
    <!-- </div> -->
</div>

<div class="container mt-2">
    <div class="d-flex justify-content-between mb-2">
        <div>
            <h2 class="text-center">Activities</h2>
        </div>
        <div>
            <div class="row">
                <div class="col">
                    <g:link controller="activity" action="pageView">
                            Add Activity
                    </g:link>
                </div>
            </div>
        </div>
    </div>
    <div class="table-responsive mt-3">
        <table class="table table-hover mt-1 table-bordered table-sm">
            <thead class="table-dark">
            <tr>
                <th>Activity Id</th>
                <th>Activity</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Pace</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:render
                    template="/shared/activityListTemplate"
                    model="[activities: activities]"
            />
            </tbody>
        </table>
    </div>
</div>

</body>
</html>