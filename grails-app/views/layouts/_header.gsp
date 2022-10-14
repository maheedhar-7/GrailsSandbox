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
                    <g:link controller="athlete" class="nav-link ${ pageProperty(name: 'meta.nav').equals('home') ? 'active' : null}" action="index">
                        <g:message code="label.home"/>
                    </g:link>
                </li>
                <li class="nav-item">
                    <g:link controller="athlete" class="nav-link ${ pageProperty(name: 'meta.nav').equals('athletes') ? 'active' : null}" action="list">
                        <g:message code="label.athletes"/>
                    </g:link>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <g:message code="label.language" />
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="?lang=en">English</a></li>
                        <li><a class="dropdown-item" href="?lang=fr">Français</a></li>
                        <li><a class="dropdown-item" href="?lang=de">German</a></li>
                        <li><a class="dropdown-item" href="?lang=ja">日本語</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <g:link controller="login" class="navbar-brand ms-auto btn btn-danger me-2" action="logout">
            <g:message code="label.logout"/>
        </g:link>

    </div>
</nav>


