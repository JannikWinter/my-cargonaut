@import my_cargonaut.Page
@import gg.jte.Content
@import my_cargonaut.profile.cars.CarsPage;import my_cargonaut.utility.FormManUtils
@import my_cargonaut.offer.creation.OfferCreationPage
@import my_cargonaut.landing.LandingPage
@import my_cargonaut.profile.edit.EditPage
@import my_cargonaut.registration.RegistrationPage;import my_cargonaut.utility.data_classes.user.User

@param Page page
@param Content content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MyCargonaut</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"><script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles/bootstrap.css"> <!-- This is the MINTY stylesheet created at bootstrap.build-->
    <link rel="icon" href="/img/semi_androidMyCargonaut.svg">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <style type="text/css">
                    body { background: #caf3e8 !important; } /* Adding !important forces the browser to overwrite the default style applied by Bootstrap */
                </style>
                <a class="navbar-brand" href="${LandingPage.PATH}">
                    <img src="/img/semi_androidMyCargonaut.svg" style="height: 50px" class="d-inline-block align-top" alt="">
                    </a>

                @if(!(page.hideNavBarNavigation()))
                <div class="collapse navbar-collapse" id="mainNavbar">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item px-2">
                            <a href="${OfferCreationPage.PATH}" role="button" class="btn btn-primary">Eintrag erstellen</a>
                        </li>
                    </ul>
                    @if(!(page.isUserLoggedIn()))
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item px-2">
                            <a href="${RegistrationPage.PATH}" role="button" class="btn btn-danger">Registrieren</a>
                        </li>
                        <!-- Excempt from https://www.codeply.com/go/XefCTinzkY/bootstrap-4-navbar-with-login-form -->
                        <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                            <li class="dropdown order-1">
                                <button type="button" id="dropdownMenu1" data-toggle="dropdown" class="btn btn-outline-secondary dropdown-toggle">Anmelden <span class="caret"></span></button>
                                <ul class="dropdown-menu dropdown-menu-right mt-2">
                                    <li class="px-3 py-2">
                                        <form class="form" name="${FormManUtils.loginForm}" role="form" method="post" action="/">
                                            <div class="form-group">
                                                <input id="emailInput" name="${FormManUtils.loginFormName}" placeholder="Benutzername" class="form-control form-control-sm" type="text" required="">
                                            </div>
                                            <div class="form-group">
                                                <input id="passwordInput" name="${FormManUtils.loginFormPassword}" placeholder="Passwort" class="form-control form-control-sm" type="password" required="">
                                            </div>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                                            </div>
                                        </form>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </ul>
                    @else
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item px-2">
                            <!--- the get() is intended without check! -->
                            <a href="${EditPage.getDynamicPath(page.getCurrentUser().get().getUsername())}" class="btn btn-info text-white" role="button">
                                <i class="fa fa-user"></i> Mein Profil</a>
                        </li>
                         <li class="nav-item px-2">
                              <a href="/logout" class="btn btn-danger" role="button">Ausloggen</a>
                         </li>
                    </ul>
                    @endif
                </div>
                @endif
            </nav>

            @if(page.wasAuthorizationAttempted())
            @if(page.hasAuthorizationSucceeded())
            <div class="container-fluid">
                <div class="alert alert-success">
                    <strong>Login erfolgreich:</strong> ${"" + page.getCurrentUserName().orElse("Sollte nie passieren!")} ist angemeldet
                </div>
            </div>
            @else
            <div class="container-fluid">
                <div class="alert alert-danger">
                    <strong>Login fehlgeschlagen:</strong> ${"" + page.getLoginErrorMsg().orElse("Unbekannte Fehlermeldung")}
                </div>
            </div>
            @endif
            @endif

            @if(page.hasAccess())
            <div class="container-fluid text-white" id="content">
                ${content}
            </div>
            @else
            <div class="container-fluid">
                <div class="alert alert-danger">
                    <strong>Anmeldung erforderlich:</strong> Um diese Funktion zu nutzen muss man angemeldet sein
                </div>
            </div>
            @endif

            <!-- Footer -->
            <footer class="bg-light text-center text-lg-start fixed-bottom">
                <!-- Grid container -->
                <div class="container p-4">
                    <!--Grid row-->
                    <div class="row">
                        <!--Grid column-->
                        <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                            <p>MyCargonaut GmBH<br />
                                Musterstra&szlig;e 111<br />
                                Geb&auml;ude 44<br />
                                90210 Musterstadt</p>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                            <p><strong>Vertreten durch:</strong>
                                Iason C. Argonaut</p>
                            <p>Telefon: +49 (0) 123 44 55 66<br />
                                E-Mail: contact@mycargonaut.de</p>

                        </div>
                    </div>
                    <!--Grid row-->
                </div>
            </footer>
            <!-- Footer -->
        </div>
    </div>
</div>
<!-- Bootstrap stuff -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!-- javascript-file -->
<script src="scripts/script.js"></script>
</body>
</html>
