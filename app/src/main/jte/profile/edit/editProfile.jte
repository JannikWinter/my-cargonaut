@import my_cargonaut.profile.cars.CarsPage
@import my_cargonaut.profile.edit.EditPage
@import my_cargonaut.profile.edit.EditProfileController
@import my_cargonaut.utility.data_classes.user.User
@import my_cargonaut.profile.deals.DealsPage

@param EditPage page

@layout.page(page = page, content = @`

               <br>
                <div class="container">
                   <div class="row">
                       <div class="col-lg-2 col-md-12">
                           <div class="bg-light">
                               <nav class="nav nav-tabs flex-column">
                                   <a class="nav-link active" href="#">Profil</a>
                                   <a class="nav-link" href="${DealsPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Deals</a>
                                   <a class="nav-link" href="${CarsPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Fuhrpark</a>
                               </nav>
                           </div>
                       </div>
                       <!-- Right-sided content -> Edit-Profile -->
                       <div class="col-lg-10 col-md-12">
                            <form class="form text-body" role="form" name="${EditPage.ProfileEForm}" id="${EditPage.ProfileEForm}" method="post" action="${EditPage.getDynamicPath(page.getCurrentUserName().get())}">
                                <div class="bg-light">
                                                               <div class="container">
                                                                   <h2>Mein Profil</h2>
                                                                   <!-- Left-sided personal details -->
                                                                   <div class="row">
                                                                       <div class="col-lg-7 col-md-12 box">
                                                                           <!-- Row 1 -->
                                                                           <div class="row">
                                                                               <div class="col form-group">
                                                                                   <label for="${EditPage.ProfileEPronoun}">Anrede</label>
                                                                                   <select class="form-control" name="${EditPage.ProfileEPronoun}" id="${EditPage.ProfileEPronoun}" >
                                                                                       <option selected hidden value="${page.getCurrentUser().map(user -> user.getPronoun().toString()).orElseThrow(IllegalStateException::new)}">
                                                                                            ${page.getCurrentUser().map(user -> user.getPronoun().toString()).orElseThrow(IllegalStateException::new)}
                                                                                       </option>
                                                                                       <option>Herr</option>
                                                                                       <option>Frau</option>
                                                                                       <option>Divers</option>
                                                                                   </select>
                                                                               </div>
                                                                               <div class="col form-group">
                                                                                    <label for="${EditPage.ProfileEName}">Vorname</label>
                                                                                    <input type="text" class="form-control" id="${EditPage.ProfileEName}" name="${EditPage.ProfileEName}" value="${page.getCurrentUser().map(User::getGivenName).orElseThrow(IllegalStateException::new)}">
                                                                               </div>
                                                                           </div>
                                                                           <!-- Row 2 -->
                                                                           <div class="form-group">
                                                                               <label for="${EditPage.ProfileESurname}">Nachname</label>
                                                                               <input type="text" class="form-control" id="${EditPage.ProfileESurname}" name="${EditPage.ProfileESurname}" value="${page.getCurrentUser().map(User::getSurname).orElseThrow(IllegalStateException::new)}">
                                                                           </div>

                                                                           <!-- Row 4 -->
                                                                           <div class="row">
                                                                               <div class="col-md-5 form-group">
                                                                                   <label for="${EditPage.ProfileEPLZ}">PLZ</label>
                                                                                   <input type="text" class="form-control" id="${EditPage.ProfileEPLZ}" name="${EditPage.ProfileEPLZ}" value="${page.getCurrentUser().map(User::getCityPostal).orElseThrow(IllegalStateException::new)}">
                                                                               </div>
                                                                               <div class="col-md-7 form-group">
                                                                                   <label for="${EditPage.ProfileECity}">Stadt</label>
                                                                                   <input type="text" class="form-control" id="${EditPage.ProfileECity}" name="${EditPage.ProfileECity}" value="${page.getCurrentUser().map(User::getCity).orElseThrow(IllegalStateException::new)}">
                                                                               </div>
                                                                           </div>
                                                                           <!-- Row 5 -->
                                                                           <div class="form-group">
                                                                               <label for="${EditPage.ProfileECellPhone}">Handynummer</label>
                                                                               <input class="form-control" type="tel" id="${EditPage.ProfileECellPhone}" name="${EditPage.ProfileECellPhone}"  value="${page.getCurrentUser().map(User::getCellphoneNumber).orElseThrow(IllegalStateException::new)}">
                                                                           </div>
                                                                       </div>
                                                                       <!-- right-sided login details PLUS picture -->
                                                                       <div class="col-lg-5 col-md-12 box">
                                                                           <!-- Row 1&2 -->
                                                                           <div class="form-group">
                                                                                <label for="avatarInput">Profilbild</label>
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
                                                                               <label for="emailInput">Benutzername</label>
                                                                               <!-- Breaks IMMEDIATELY if you break open the lambdas -->
                                                                               <input type="email" class="form-control" id="emailInput" disabled value="${page.getCurrentUser().map(user -> user.getUsername()).orElseThrow(IllegalStateException::new)}">
                                                                           </div>
                                                                           <div class="col form-group">
                                                                               <label for="passwordInput">Passwort</label>
                                                                               <input type="text" class="form-control" id="passwordInput" disabled value="${page.getCurrentUser().map(user -> user.getPassword().getPw()).orElseThrow(IllegalStateException::new)}">
                                                                           </div>

                                                                       </div>
                                                                   </div>

                                                                   <button type="submit" class="btn btn-primary mb-2 ml-2">Aenderungen speichern</button>
                                                               </div>
                                                           </div>
                            </form>

                       </div>
                   </div>
                </div>





    `)
