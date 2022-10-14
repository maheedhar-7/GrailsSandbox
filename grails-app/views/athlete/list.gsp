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
    <meta name="nav" content="athletes">

</head>

<body class="container-fluid">



<div class="container mt-3 mb-2">
    <div class="d-flex justify-content-between mt-2">
        <div>
            <h2>
                <g:message code="label.athletes" />
            </h2>
        </div>
        <div id="myDiv">
            <p class="danger">${msg}</p>
        </div>
        <div>
            <div class="row">
                <div class="col">
                    <g:link class="btn btn-primary btn-block w-70" controller="athlete" action="edit">
                        <g:message code="label.addAthlete" />
                    </g:link>
                </div>
            </div>
        </div>
    </div>

    <div class="table-responsive mt-2 mb-2">
        <table class="table table-hover mt-1 table-bordered table-sm">
            <thead class="table-dark">
            <tr>
                <th><g:message code="label.athleteId" /></th>
                <th><g:message code="label.firstName"/></th>
                <th><g:message code="label.lastName"/></th>
                <th><g:message code="label.phoneNumber"/></th>
                <th><g:message code="label.email"/></th>
                <th><g:message code="label.actions" /></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${athletes}" var="athlete">
                <tr>
                    <td>${athlete.id}</td>
                    <td>${athlete.firstName}</td>
                    <td>${athlete.lastName}</td>
                    <td>${athlete.phoneNumber}</td>
                    <td>${athlete.email}</td>
                    <td>
                        <g:link controller="athlete" class="text-decoration-none" params="${[id: athlete.id]}" action="edit">
                            <g:message code="label.updateAction" />
                        </g:link>

                        <g:link controller="athlete" class="text-decoration-none" onclick="return getConfirmationAthleteDelete()" params="${[id: athlete.id]}" action="delete">
                            <g:message code="label.deleteAction"/>
                        </g:link>

                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>