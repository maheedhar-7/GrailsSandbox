<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
   <meta name="layout" content="main">
</head>

<body>
    <div class="col-md-12 col-sm-2">
        <div class="text-center">
            <h2>
                ${g.message([code: athleteCommand.id ? "label.updateActivity" : "label.addActivity"])}
            </h2>
        </div>


        <div class="container pt-3 col-md-4">
            <g:form action="save" method="POST">
%{--                <div class="mb-4">--}%
%{--                    <g:hiddenField name="id" typeof="text" id="activity-id" class="form-control"--}%
%{--                                   value="${athleteCommand.id}">--}%
%{--                    </g:hiddenField>--}%
%{--                </div>--}%

                <div class="row mb-4">
                    <div class="col-md-6 col-sm-12 mb-4">
                        <label htmlFor="firstName" class="form-label">
                            <g:message code="label.firstName" />:
                        </label>
                        <g:textField value="${athleteCommand?.firstName}"
                                     name="firstName" id="firstName"
                                     class="form-control ${hasErrors(bean: athleteCommand, field: "firstName", "is-invalid")}">
                        </g:textField>
                        <g:hasErrors bean="${athleteCommand}" field="firstName">
                            <div id="val_feedback_name" class="invalid-feedback">
                                <g:eachError bean="${athleteCommand}" field="firstName" var="error">
                                    <g:message error="${error}"/>
                                </g:eachError>
                            </div>
                        </g:hasErrors>
                    </div>

                    <div class="col-md-6 col-sm-12 mb-4">
                        <label htmlFor="lastName" class="form-label">
                            <g:message code="label.lastName" />:
                        </label>
                        <g:textField value="${athleteCommand.lastName}"
                                     name="lastName" id="lastName"
                                     class="form-control ${hasErrors(bean: athleteCommand, field: "lastName", "is-invalid")}">
                        </g:textField>
                        <g:hasErrors bean="${athleteCommand}" field="lastName">
                            <div id="val_feedback_name" class="invalid-feedback">
                                <g:eachError bean="${athleteCommand}" field="lastName" var="error">
                                    <g:message error="${error}"/>
                                </g:eachError>
                            </div>
                        </g:hasErrors>
                    </div>
                </div>



                <div class="mb-4">
                    <label htmlFor="phoneNumber" class="form-label">
                        <g:message code="label.phoneNumber" />:
                    </label>
                    <g:textField value="${athleteCommand.phoneNumber}"
                                 name="phoneNumber" id="phoneNumber"
                                 class="form-control ${hasErrors(bean: athleteCommand, field: "phoneNumber", "is-invalid")}">
                    </g:textField>
                    <g:hasErrors bean="${athleteCommand}" field="phoneNumber">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${athleteCommand}" field="phoneNumber" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>


                <div class="mb-4">
                    <label htmlFor="email" class="form-label">
                        <g:message code="label.email" />:
                    </label>
                    <g:textField value="${athleteCommand.email}"
                                 name="email" id="email"
                                 class="form-control ${hasErrors(bean: athleteCommand, field: "email", "is-invalid")}">
                    </g:textField>
                    <g:hasErrors bean="${athleteCommand}" field="email">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${athleteCommand}" field="email" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>

                <div class="mb-4">
                    <label htmlFor="password" class="form-label">
                        <g:message code="label.password" />:
                    </label>
                    <g:textField value="${athleteCommand.password}"
                                 name="password" id="password"
                                 class="form-control ${hasErrors(bean: athleteCommand, field: "password", "is-invalid")}">

                    </g:textField>
                    <g:hasErrors bean="${athleteCommand}" field="password">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${athleteCommand}" field="password" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>

                <div class="mb-4">
                    <label htmlFor="confirm-password" class="form-label">
                        <g:message code="label.confirmPassword" />:
                    </label>
                    <g:textField value="${athleteCommand?.passwordConfirm}"
                                 name="passwordConfirm" id="passwordConfirm"
                                 class="form-control ${hasErrors(bean: athleteCommand, field: "passwordConfirm", "is-invalid")}">
                    </g:textField>
                    <g:hasErrors bean="${athleteCommand}" field="passwordConfirm">
                        <div id="val_feedback_name" class="invalid-feedback">
                            <g:eachError bean="${athleteCommand}" field="passwordConfirm" var="error">
                                <g:message error="${error}"/>
                            </g:eachError>
                        </div>
                    </g:hasErrors>
                </div>

                <div class="mb-4">
                    <g:hiddenField name="id" typeof="text" id="activity-id" class="form-control"
                                   value="${athleteCommand.id}">
                    </g:hiddenField>
                </div>

                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-primary btn-block">
                            ${g.message([code: athleteCommand.id ? "label.updateActivity" : "label.addActivity"])}
                        </button>
                    </div>

                    <div class="col">
                        <g:link controller="athlete" action="list" class="btn btn-primary btn-block w-50 bg-danger float-end">
                            <g:message code="label.cancel" />
                        </g:link>
                    </div>
                </div>
            </g:form>
        </div>
    </div>
</body>
</html>