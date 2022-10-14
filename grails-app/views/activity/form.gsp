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
        <h2>
              ${g.message([code: activityCommand.id ? "label.updateActivity" : "label.addActivity"])}
        </h2>
    </div>
%{--    <g:renderErrors bean="${activity}"/>--}%
    <div class="container pt-3 col-md-4">
        <g:form action="save" method="POST">
            <div class="mb-4">
                <g:hiddenField name="id" typeof="text" id="activity-id" class="form-control"
                               value="${activityCommand.id}">
                </g:hiddenField>
                <div class="mb-4 col-md-12 col-sm-2 dropdown">
                    <label htmlFor="activity" class=" form-label">
                        <g:message code="label.chooseActivity" />:
                    </label>
                    <g:select
                            name="activity"
                            id="activity"
                            class="form-select "
                            value="${activityCommand.activity}" from="${["Run", "Ride"]}"
                            noSelection="['':g.message(code: 'label.chooseYourActivity')]">
                        <option>-- select an option --</option>
                        <option value="Ride">Ride</option>
                        <option value="Run">Run</option>
                    </g:select>
                </div>

                <div class="mb-4">
                    <label for="startDate" class="form-label">
                        <g:message code="label.startDate" />
                    </label>
                    <g:textField name="startDate" id="startDate"
                                 class="form-control ${hasErrors(bean: activityCommand, field: "startDate", "is-invalid")}"
                                 value="${formatDate(format: 'dd/MM/yyyy HH:mm', date: activityCommand.startDate)}">
                    </g:textField>
                    <g:hasErrors bean="${activityCommand}" field="startDate">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${activityCommand}" field="startDate" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>

                <div class="mb-4">
                    <label for="endDate" class="form-label">
                        <g:message code="label.endDate"/>
                    </label>
                    <g:textField value="${formatDate(format: 'dd/MM/yyyy HH:mm', date: activityCommand.startDate)}"
                                 name="endDate" type="date/time"
                                 id="endDate"
                                 class="form-control ${hasErrors(bean: activityCommand, field: "endDate", "is-invalid")}">
                    </g:textField>
                    <g:hasErrors bean="${activityCommand}" field="endDate">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${activityCommand}" field="endDate" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>
            </div>

            <div class="mb-4">
                <label for="pace" class="form-label">
                    <g:message code="label.pace"/>
                </label>
                <g:textField value="${activityCommand.pace}"
                             name="pace" typeof="text"
                             id="pace"
                             class="form-control ${hasErrors(bean: activityCommand, field: "pace", "is-invalid")}">
                </g:textField>
                <g:hasErrors bean="${activityCommand}" field="pace">
                    <div id="val_feedback_name" class="invalid-feedback">
                        <g:eachError bean="${activityCommand}" field="pace" var="error">
                            <g:message error="${error}"/>
                        </g:eachError>
                    </div>
                </g:hasErrors>
            </div>
            <div class="row">
                <div class="col">
                    <button type="submit" class="btn btn-primary btn-block w-50">
                        ${g.message([code: activityCommand.id ? "label.updateActivity" : "label.addActivity"])}
                    </button>
                </div>


                <div class="col">
                    <g:link controller="athlete" action="index" class="btn btn-primary btn-block w-50 bg-danger float-end">
                        <g:message code="label.cancel"/>
                    </g:link>
                </div>
            </div>
        </g:form>

    </div>

</div>

</body>
</html>
