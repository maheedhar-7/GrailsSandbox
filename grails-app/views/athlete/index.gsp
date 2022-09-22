%{--<%----}%
%{--  Created by IntelliJ IDEA.--}%
%{--  User: veges--}%
%{--  Date: 22-09-2022--}%
%{--  Time: 09:04--}%
%{----%>--}%

%{--<%@ page contentType="text/html;charset=UTF-8" %>--}%
%{--<html>--}%
%{--<head>--}%
%{--    <!-- Latest compiled and minified CSS -->--}%
%{--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">--}%

%{--    <!-- Latest compiled and minified JavaScript -->--}%
%{--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>--}%

%{--    <title></title>--}%
%{--</head>--}%

%{--<body>--}%
%{--<div class="container">--}%
%{--    <div class="row w-100 mt-5">--}%
%{--        <table class="table">--}%
%{--            <thead class="table-dark">--}%
%{--            <tr>--}%
%{--                <th>First Name</th>--}%
%{--                <th>Last Name</th>--}%
%{--                <th> E mail</th>--}%
%{--                <th>Phone Number</th>--}%
%{--            </tr>--}%
%{--            </thead>--}%
%{--            <tbody>--}%
%{--            <tr>--}%
%{--                <td>${loginObj.athlete.firstName}</td>--}%
%{--                <td>${loginObj.athlete.getLastName()}</td>--}%
%{--                <td>${loginObj.athlete.getEmail()}</td>--}%
%{--                <td>${loginObj.athlete.getPhoneNumber()}</td>--}%
%{--            </tr>--}%
%{--            </tbody>--}%
%{--        </table>--}%
%{--        <div class="row">--}%
%{--            <div class="col">--}%
%{--                <Link to={"/activityform/" + params.athleteId}>--}%
%{--                <button type="submit" class="btn btn-primary btn-block">--}%
%{--                    Add Activity--}%
%{--                </button>--}%
%{--            </Link>--}%
%{--            </div>--}%

%{--            <div class="col">--}%
%{--                <Link to="/">--}%
%{--                <button--}%
%{--                        type="submit"--}%
%{--                        class="btn btn-primary btn-block mb-4 bg-danger float-end"--}%
%{--                >--}%
%{--                    Main--}%
%{--                </button>--}%
%{--            </Link>--}%
%{--            </div>--}%
%{--        </div>--}%
%{--    </div>--}%



%{--    <div>--}%
%{--        <h2 class="text-center">Activities List</h2>--}%
%{--        <table class="table table-hover mt-4 table-bordered table-sm">--}%
%{--            <thead class="table-dark">--}%
%{--            <tr >--}%
%{--                <th>Activity Id</th>--}%
%{--                <th>Activity</th>--}%
%{--                <th>Start Date</th>--}%
%{--                <th>Start Time</th>--}%
%{--                <th>End Date</th>--}%
%{--                <th>End Time</th>--}%
%{--                <th>Pace</th>--}%
%{--                <th>Actions</th>--}%
%{--            </tr>--}%
%{--            </thead>--}%
%{--            <tbody>--}%
%{--            {activities.length > 0 ? (--}%
%{--            renderAvtivities--}%
%{--            ) : (--}%
%{--            <div>No Activities </div>--}%
%{--            )}--}%

%{--            </tbody>--}%
%{--        </table>--}%
%{--    </div>--}%
%{--</div>--}%
%{--</body>--}%
%{--</html>--}%