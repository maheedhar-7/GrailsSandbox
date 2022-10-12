<%--
  Created by IntelliJ IDEA.
  User: veges
  Date: 23-09-2022
  Time: 15:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>

<div class="col-md-12 col-sm-2">
    <div class="text-center">
        <h2>${formTitle}</h2>
    </div>
%{--    <g:renderErrors bean="${activity}"/>--}%
    <div class="container pt-3 col-md-4">
        <g:form action="save" method="POST">
            <div class="mb-4">
                <g:hiddenField name="activity-id" typeof="text" id="activity-id" class="form-control"
                               value="${activity?.id}">
                </g:hiddenField>
                <div class="mb-4 col-md-12 col-sm-2 dropdown">
                    <label htmlFor="activity" class=" form-label">
                        Choose activity:
                    </label>
                    <g:select
                            name="activity"
                            id="activity"
                            class="form-select "
                            value="${activity?.activity}" from="${["Run", "Ride"]}"
                            noSelection="['':'-Choose your activity-']">
                        <option>-- select an option --</option>
                        <option value="Ride">Ride</option>
                        <option value="Run">Run</option>
                    </g:select>
                </div>

                <div class="mb-4">
                    <label for="startDate" class="form-label">
                        Start date:
                    </label>
                    <g:textField name="startDate" id="startDate"
                                 class="form-control ${hasErrors(bean: activity, field: "startDate", "is-invalid")}"
                                 value="${formatDate(format: 'dd/MM/yyyy HH:mm', date: activity?.startDate)}">
                    </g:textField>
                    <g:hasErrors bean="${activity}" field="startDate">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${activity}" field="startDate" var="error">
                                <g:set var="error" value="Start Date can not be null" />
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>

                <div class="mb-4">
                    <label for="endDate" class="form-label">
                        End date:
                    </label>
                    <g:textField value="${formatDate(format: 'dd/MM/yyyy HH:mm', date: activity?.startDate)}"
                                 name="endDate" type="date/time"
                                 id="endDate"
                                 class="form-control ${hasErrors(bean: activity, field: "endDate", "is-invalid")}">
                    </g:textField>
                    <g:hasErrors bean="${activity}" field="endDate">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${activity}" field="endDate" var="error">
                                <g:set var="error" value="EndDate can not be null" />
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>
            </div>

            <div class="mb-4">
                <label for="pace" class="form-label">
                    Pace:
                </label>
                <g:textField value="${activity?.pace}"
                             name="pace" typeof="text"
                             id="pace"
                             class="form-control ${hasErrors(bean: activity, field: "pace", "is-invalid")}">
                </g:textField>
                <g:hasErrors bean="${activity}" field="pace">
                    <div id="val_feedback_name" class="invalid-feedback">
                        <g:eachError bean="${activity}" field="pace" var="error">
                            <g:set var="error" value="pace can not be null" />
                            <g:message error="${error}"/>
                        </g:eachError>
                    </div>
                </g:hasErrors>
            </div>
            <div class="row">
                <div class="col">
                    <button type="submit" class="btn btn-primary btn-block w-70">
                        ${formTitle}
                    </button>
                </div>


                <div class="col">
                    <g:link controller="athlete" action="index" class="btn btn-primary btn-block w-50 bg-danger float-end">

                        Cancel
                    </g:link>
                </div>
            </div>
        </g:form>

    </div>

</div>

</body>
</html>
