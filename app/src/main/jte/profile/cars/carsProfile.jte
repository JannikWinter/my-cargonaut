@import my_cargonaut.Page
@import my_cargonaut.profile.deals.DealsPage;
@import my_cargonaut.profile.edit.EditPage;
@import my_cargonaut.profile.cars.CarsPage;
@param my_cargonaut.profile.cars.CarsPage page
    @layout.page(page = page, content = @`
            <br>
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-md-12">
                        <div class="bg-light">
                            <nav class="nav nav-tabs flex-column">
                                <a class="nav-link" href="${EditPage.PATH}">Profil</a>
                                <a class="nav-link" href="${DealsPage.PATH}">Deals</a>
                                <a class="nav-link active" href="#">Fuhrpark</a>
                            </nav>
                        </div>
                    </div>
                    <!-- Right-sided content -> Edit-Profile -->
                    <form class="form" role="form" name="${CarsPage.ProfileCForm}" id="${CarsPage.ProfileCForm}" method="post" action="${CarsPage.PATH}">
                    <div class="col-lg-10 col-md-12">
                        <div class="bg-light">
                            <div class="container">
                                <h2 class="pt-2">Mein Fahrzeug</h2>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-group">
                                            <label for="brandDropdown"><h6>Marke</h6></label>
                                            <select class="form-control" name="${CarsPage.ProfileCBrand}" id="${CarsPage.ProfileCBrand}">
                                                <option>Alfa-Romeo</option>
                                                <option>AMG</option>
                                                <option>Aston-Martin</option>
                                                <option>Audi</option>
                                                <option>Bentley</option>
                                                <option>Bugatti</option>
                                                <option>BMW</option>
                                                <option>Buick</option>
                                                <option>Cadillac</option>
                                                <option>Chevrolet</option>
                                                <option>Citroen</option>
                                                <option>Chrysler</option>
                                                <option>Daihatsu</option>
                                                <option>Dacia</option>
                                                <option>Dodge</option>
                                                <option>Ferrari</option>
                                                <option>Fiat</option>
                                                <option>Ford</option>
                                                <option>General Motors</option>
                                                <option>GMC</option>
                                                <option>Honda</option>
                                                <option>Hummer</option>
                                                <option>Hyundai</option>
                                                <option>Infiniti</option>
                                                <option>Jaguar</option>
                                                <option>Jeep</option>
                                                <option>Kia</option>
                                                <option>Lada</option>
                                                <option>Lamborghini</option>
                                                <option>Lancia</option>
                                                <option>Land Rover</option>
                                                <option>Lexus</option>
                                                <option>Lincoln</option>
                                                <option>Lotus</option>
                                                <option>Maybach</option>
                                                <option>Maserati</option>
                                                <option>Mazda</option>
                                                <option>McLaren</option>
                                                <option>Mercedes-Benz</option>
                                                <option>Mini</option>
                                                <option>Mitsubishi</option>
                                                <option>Nissan</option>
                                                <option>Oldsmobile</option>
                                                <option>Opel/Vauxhall</option>
                                                <option>Peugeot</option>
                                                <option>Plymouth</option>
                                                <option>Porsche</option>
                                                <option>Renault</option>
                                                <option>Rolls-Royce</option>
                                                <option>Saab</option>
                                                <option>Seat</option>
                                                <option>Skoda</option>
                                                <option>Subaru</option>
                                                <option>Suzuki</option>
                                                <option>Tesla</option>
                                                <option>Toyota</option>
                                                <option>Volkswagen</option>
                                                <option>Volvo</option>
                                            </select>
                                        </div>
                                        <br>
                                        <div class="form-group">
                                            <label><h6>Freier Platz (aktuell)</h6></label>
                                                <div class="col">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label for="freeHeight">Höhe (cm)</label>
                                                                <input class="form-control" name="${CarsPage.ProfileCFreeHeight}" id="${CarsPage.ProfileCFreeHeight}">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label for="freeWidth">Breite (cm)</label>
                                                                <input class="form-control" name="${CarsPage.ProfileCFreeWidth}" id="${CarsPage.ProfileCFreeWidth}">
                                                            </div>
                                                        </div>
                                                        <div class="col">
                                                            <div class="form-group">
                                                                <label for="freeDepth">Tiefe (cm)</label>
                                                                <input class="form-control" id="${CarsPage.ProfileCFreeDepth}" name="${CarsPage.ProfileCFreeDepth}">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="freeWeight">Gewicht (kg)</label>
                                                        <input class="form-control" name="${CarsPage.ProfileCFreeWeight}" id="${CarsPage.ProfileCFreeWeight}">
                                                    </div>
                                                </div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group">
                                            <label for="modelInput"><h6>Model</h6></label>
                                            <input type="text" class="form-control"name="${CarsPage.ProfileCModel}" id="${CarsPage.ProfileCModel}">
                                        </div>
                                        <br>
                                        <div class="form-group">
                                            <label><h6>Freier Platz (maximum)</h6></label>
                                            <div class="col">
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="maxHeight">Höhe (cm)</label>
                                                            <input class="form-control" id="${CarsPage.ProfileCMaxHeight}">
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="maxWidth">Breite (cm)</label>
                                                            <input class="form-control" id="maxWidth">
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="maxDepth">Tiefe (cm)</label>
                                                            <input class="form-control" id="maxDepth">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="maxWeight">Gewicht (kg)</label>
                                                    <input class="form-control" id="maxWeight">
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <button type="submit" class="btn btn-primary mb-2">Änderungen bestätigen</button>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>

    `)
