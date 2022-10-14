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
    <meta name="nav" content="home">
</head>

<body>
<div class="container mt-2 mb-2">
%{--    <div>--}%
%{--        <g:message code="default.message" />--}%
%{--    </div>--}%
    <div>
        <h2>
            <g:message code="label.athlete" />
        </h2>
    </div>
    <table class="table" mt-2>
        <thead class="table-dark">
        <tr>
            <th><g:message code="label.firstName"/></th>
            <th><g:message code="label.lastName"/></th>
            <th><g:message code="label.email"/></th>
            <th><g:message code="label.phoneNumber"/></th>
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
            <h2>
                <g:message code="label.activities" />
            </h2>
        </div>
        <div>
            <div class="row">
                <div class="col">
                    <g:link controller="activity" class="btn btn-primary btn-block w-70" action="edit">
                            <g:message code="label.addActivity"/>
                    </g:link>
                </div>
            </div>
        </div>
    </div>
    <div class="table-responsive mt-3">
        <table class="table table-hover mt-1 table-bordered table-sm">
            <thead class="table-dark">
            <tr>
                <th><g:message code="label.activityId" /></th>
                <th><g:message code="label.activity" /></th>
                <th><g:message code="label.startDate" /></th>
                <th><g:message code="label.endDate" /></th>
                <th><g:message code="label.pace" /></th>
                <th><g:message code="label.actions" /></th>
            </tr>
            </thead>
            <tbody>
            <g:render
                    template="/shared/activityList"
                    model="[activities: activities]"
            />
            </tbody>
        </table>
    </div>
</div>

</body>
</html>