@import my_cargonaut.registration.RegistrationPage
@import my_cargonaut.utility.FormManUtils

@param RegistrationPage page

@layout.page(page = page, content = @`

@if(page.wasRegistrationAttempted())
@if(page.hasRegistrationSucceeded())
<div class="container-fluid mx-auto">
    <div class="alert alert-success">
        <strong>Registrierung des Nutzers erfolgreich:</strong> ${"" + page.getEnteredUsername()}
    </div>
</div>
@else
<div class="container-fluid mx-auto">
    <div class="alert alert-danger">
        <strong>Registrierung fehlgeschlagen:</strong> ${"" + page.getLoginErrorMsg()}
    </div>
</div>
@endif
@endif

<div class="container mt-3 mb-1 mx-auto py-3 px-5 bg-light">
    <div class="container d-flex justify-content-center">
      <h1>Registrieren</h1>
    </div>
    <form class="form p-3 was-validated" role="form" name="${FormManUtils.regForm}" method="post" target="${RegistrationPage.PATH}" onsubmit="return validateRegistrationForm()">
      <div class="container px-5">
        <div class="form-group mt-4">
          <label for="registerName">Nutzername</label>
          <input id="registerName" name="${FormManUtils.regFormUsername}" type="text"
                placeholder="Nutzernamen eintragen" class="form-control" value="${page.getEnteredUsername()}" required>
          <div class="invalid-feedback">Bitte geben Sie einen Nutzernamen an</div>
        </div>
        <div class="form-group mt-4">
          <label for="registerMail">E-Mail-Adresse</label>
          <input id="registerMail" name="${FormManUtils.regFormEmail}" type="email"
                placeholder="E-Mail-Adresse eintragen" class="form-control" value="${page.getEnteredMail()}" required>
          <div class="invalid-feedback">Bitte geben Sie eine E-Mail-Adresse an</div>
        </div>
        <div class="form-group mt-4">
          <label for="registerPw">Passwort</label>
          <input id="registerPw" name="${FormManUtils.regFormPassword}" type="password"
                placeholder="Passwort eingeben" class="form-control" value="${page.getEnteredPw()}" required>
          <div class="invalid-feedback">Bitte geben Sie Ihr Passwort an</div>
        </div>
        <div class="form-group mt-4">
          <label for="registerPw2">Passwort wiederholen</label>
          <input id="registerPw2" name="${FormManUtils.regFormPassword2}" type="password"
                placeholder="Passwort wiederholen" class="form-control" value="${page.getEnteredPw2()}" required>
          <div id="registerPw2Fb" class="invalid-feedback">Bitte wiederholen Sie ihr Passwort</div>
        </div>
        <div class="container mt-5 d-flex justify-content-center">
          @if(page.wasRegistrationAttempted() && page.hasRegistrationSucceeded())
          <a href="/" role="button" class="btn btn-lg btn-light">Weiter zur Startseite</a>
          @else
          <button type="submit" class="btn btn-lg btn-success">Registrieren</button>
          @endif
        </div>
      </div>
    </form >
</div>

`)
