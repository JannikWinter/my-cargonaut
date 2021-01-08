
@param my_cargonaut.landing.LandingPage page

@layout.page(page = page, content = @`
               <!-- Left-sided navbar-->
               <div class="container">
                  <div class="row">
                      <div class="col-lg-2 col-md-12">
                          <div class="bg-light">
                              <nav class="nav nav-tabs flex-column">
                                  <a class="nav-link active" href="#">Profil</a>
                                  <a class="nav-link" href="Profile_Deals.html">Deals</a>
                                  <a class="nav-link" href="#">Fuhrpark</a>
                              </nav>
                          </div>
                      </div>
                      <!-- Right-sided content -> Edit-Profile -->
                      <div class="col-lg-10 col-md-12">
                          <div class="bg-light">
                              <div class="container">
                                  <h2>Mein Profil</h2>
                                  <!-- Left-sided personal details -->
                                  <div class="row">
                                      <div class="col-lg-7 col-md-12 box">
                                          <!-- Row 1 -->
                                          <div class="row">
                                              <div class="col form-group">
                                                  <label for="titleDropdown"><h6>Anrede</h6></label>
                                                  <select class="form-control" id="titleDropdown">
                                                      <option>Herr</option>
                                                      <option>Frau</option>
                                                      <option>Divers</option>
                                                  </select>
                                              </div>
                                              <div class="col form-group">
                                                   <label for="surnameInput"><h6>Vorname</h6></label>
                                                   <input type="text" class="form-control" id="surnameInput">
                                              </div>
                                          </div>
                                          <!-- Row 2 -->
                                          <div class="form-group">
                                              <label for="nameInput"><h6>Nachname</h6></label>
                                              <input type="text" class="form-control" id="nameInput">
                                          </div>
                                          <!-- Row 3 -->
                                          <div class="form-group">
                                              <label for="birthdayinput"><h6>Geburtsdatum</h6></label>
                                              <input class="form-control" type="date" id="birthdayinput">
                                          </div>
                                          <!-- Row 4 -->
                                          <div class="row">
                                              <div class="col-md-5 form-group">
                                                  <label for="postalInput"><h6>PLZ</h6></label>
                                                  <input type="text" class="form-control" id="postalInput">
                                              </div>
                                              <div class="col-md-7 form-group">
                                                  <label for="cityInput"><h6>Stadt</h6></label>
                                                  <input type="text" class="form-control" id="cityInput">
                                              </div>
                                          </div>
                                          <!-- Row 5 -->
                                          <div class="form-group">
                                              <label for="phoneInput"><h6>Handynummer</h6></label>
                                              <input class="form-control" type="tel" id="phoneInput">
                                          </div>
                                      </div>
                                      <!-- right-sided login details PLUS picture -->
                                      <div class="col-lg-5 col-md-12 box">
                                          <!-- Row 1&2 -->
                                          <div class="form-group">
                                               <label for="avatarInput"><h5>Profilbild</h5></label>
                                                   <form class="md-form">
                                                       <div class="file-field">
                                                           <div class="mb-4">
                                                               <img src="https://mdbootstrap.com/img/Photos/Others/placeholder-avatar.jpg"
                                                                    class="rounded-circle z-depth-1-half avatar-pic"
                                                                    width="150px" alt="example placeholder avatar">
                                                           </div>
                                                       <div class="d-flex">
                                                            <div class="btn btn-primary">
                                                               <input type="file" name="file" id="avatarInput">
                                                            </div>
                                                       </div>
                                                       </div>
                                                   </form>
                                          </div>
                                          <div class="d-flex justify-content-center">
                                              <button class="btn btn-info"><i class="fa fa-paypal"></i> PayPal verlinken</button>
                                          </div>
                                          <div class="col form-group">
                                              <label for="emailInput"><h6>E-Mail</h6></label>
                                              <input type="email" class="form-control" id="emailInput">
                                          </div>
                                          <div class="col form-group">
                                              <label for="passwordInput"><h6>Passwort</h6></label>
                                              <input type="password" class="form-control" id="passwordInput">
                                          </div>

                                      </div>
                                  </div>
                                  <button type="button" class="btn btn-primary mb-2 ml-2">Änderungen speichern</button>
                              </div>
                          </div>
                      </div>
                  </div>
               </div>
`)

