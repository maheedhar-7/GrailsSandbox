
%{--<header class="p-2 text-bg-dark">--}%
%{--    <div class="container">--}%
%{--        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">--}%
%{--            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 p-1 justify-content-center mb-md-0">--}%
%{--                <li>--}%
%{--                    <g:link controller="athlete" class="text-decoration-none" action="getAthletes">--}%
%{--                        <p class="px-2 text-white">Athletes</p>--}%
%{--                    </g:link>--}%
%{--                <li>--}%
%{--                    <g:link controller="athlete" class="text-decoration-none" action="index">--}%
%{--                        <p class="px-2 text-white">Activities</p>--}%
%{--                    </g:link>--}%
%{--                </li>--}%
%{--            </ul>--}%

%{--            <div class="text-end">--}%
%{--                <g:link controller="login" action="logout">--}%
%{--                    <button type="button" class="btn btn-danger me-2">Logout</button>--}%
%{--                </g:link>--}%
%{--            </div>--}%
%{--        </div>--}%
%{--    </div>--}%
%{--</header>--}%



<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-brand collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
%{--                    <a class="nav-link active" aria-current="page" href="#">Home</a>--}%
                    <g:link controller="athlete" class="nav-link" action="getAthletes">
                        Athletes
                    </g:link>
                </li>
                <li class="nav-item">
%{--                    <a class="nav-link" href="#">Link</a>--}%
                    <g:link controller="athlete" class="nav-link" action="index">
                        Activities
                    </g:link>
                </li>
            </ul>
        </div>
        <g:link controller="login" class="navbar-brand ms-auto" action="logout">
            <button type="button" class="btn btn-danger me-2">Logout</button>
        </g:link>
%{--        <a class="navbar-brand ms-auto" href="#">--}%
%{--            <img src="https://placeholder.pics/svg/150x50/888888/EEE/Logo" alt="..." height="36"/>--}%
%{--        </a>--}%
    </div>
</nav></nav>


