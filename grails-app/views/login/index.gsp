<%--
  Created by IntelliJ IDEA.
  User: veges
  Date: 21-09-2022
  Time: 09:36
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
`    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
`    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"
    ></script>
</head>

<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem">
                    <div class="card-body p-5 text-center">
                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Login</h2>

                            <p class="text-white-50 mb-5">
                                Please enter your login and password!
                            </p>
                            <g:if test="${message}">
                                ${message}
                            </g:if>

                            <g:form action="loginValidate" method="POST" class="mt-2">
                                <div class="form-outline form-white mb-4">
                                    <label class="form-label" for="email">Email</label>
                                    <g:textField type="email" class="form-control form-control-lg" name="email" value="${email}"/>
                                </div>

                                <div class="form-outline form-white mb-4">
                                    <label class="form-label" for="password">Password</label>
                                    <g:passwordField type="password" name="password" class="form-control form-control-lg" value="${password}"/>
                                </div>

                                <button class="btn btn-outline-light btn-lg px-5" value="login" type="submit">Login</button>
                            </g:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>