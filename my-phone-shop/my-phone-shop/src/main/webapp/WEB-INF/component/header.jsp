
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">SDA Shop</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/show-cart">Koszyk</a></li>
            <c:if test="${sessionScope.isAuthorize}"><li><a href="/logout">Wyloguj</a></li></c:if>
            <c:if test="${!sessionScope.isAuthorize}"><li><a href="/login">Zaloguj</a></li></c:if>
        </ul>
    </div>
</nav>

