@import my_cargonaut.Page
@import gg.jte.Content

@param Page page
@param Content content

<html lang="de">
<head>
    <title>My Cargonaut</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <link href="/styles/myCargoStyles.css" rel="stylesheet">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand navbar-light bg-light sticky-top p-2 border-cargo">
          <a class="navbar-brand" href="#">
            <img src="/img/logo.png" height="379" width="901" class="cargoNautLogo" alt="logo of MyCargonaut">
          </a>

          @if(!(page instanceof my_cargonaut.landing.NotFoundPage))
          <div class="container">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="#">Angebot erstellen</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Gesuch erstellen</a>
              </li>
            </ul>
            @if(page.isUserLoggedIn())
            <div class="card mr-auto" style="width: 10rem;">
              <div class="card-body">
                <div class="container d-flex justify-content-center justify-content-middle">
                  <img src="/img/profile2.png" class="car-img-top pt-1 profilePic" alt="profile picture">
                </div>
                <div class="dropstart mt-1 d-flex justify-content-center">
                  <button type="button" class="btn btn-sm dropdown-toggle text-light cargonautColor" style="white-space: normal"
                          id="ddMenuBtn" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Optionen
                  </button>
                  <div class="dropdown-menu" aria-labelledby="ddMenuBtn">
                    <a class="dropdown-item" href="#">Profil bearbeiten</a>
                    <a class="dropdown-item" href="#">Abmelden</a>
                  </div>
                </div>
              </div>
            </div>
            @else
            <div class="row mr-auto">
              <div class="col">
                <a class="btn btn-sm text-light cargonautColor mt-1" href="#" style="width: 100%">Anmelden</a>
              </div>
              <div class="col">
                <a class="btn btn-sm text-light cargonautColor mt-1" href="#" style="width: 100%">Registrieren</a>
              </div>
            </div>
            @endif
          </div>
          @endif
        </nav>
    </header>
    <main>
        <div id="content">
            ${content}
        </div>
    </main>
    <footer>

    </footer>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
            integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
            integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
            crossorigin="anonymous"></script>
</body>
</html>
