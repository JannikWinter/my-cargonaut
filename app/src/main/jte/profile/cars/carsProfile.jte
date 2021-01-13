@import my_cargonaut.profile.deals.DealsPage
@import my_cargonaut.profile.edit.EditPage
@import my_cargonaut.profile.cars.CarsPage
@import my_cargonaut.utility.data_classes.user.CarManufacturer

@param my_cargonaut.profile.cars.CarsPage page

@layout.page(page = page, content = @`

        <div class="container mt-3">
            <div class="row">
                <div class="col-lg-2 col-md-12">
                    <div class="bg-light">
                        <nav class="nav nav-tabs flex-column">
                            <a class="nav-link" href="${EditPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Profil</a>
                            <a class="nav-link" href="${DealsPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Deals</a>
                            <a class="nav-link active" href="#">Fuhrpark</a>
                        </nav>
                    </div>
                </div>
                <!-- Right-sided content -> Edit-Profile -->

                <div class="col-lg-10 col-md-12">
                    <form class="form text-body" role="form" name="${CarsPage.ProfileCForm}" id="${CarsPage.ProfileCForm}" method="post" action="${CarsPage.getDynamicPath(page.getCurrentUserName().get())}"> <!-- .get() is intentional! -->
                    <div class="bg-light">
                        <div class="container">
                            <h2 class="pt-2">Mein Fahrzeug</h2>
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="${CarsPage.ProfileCBrand}">Marke</label>
                                        <select class="form-control" name="${CarsPage.ProfileCBrand}" id="${CarsPage.ProfileCBrand}" >
                                            <option selected hidden value="${page.getVehicle().map(vehicle -> vehicle.getBrand().toString()).orElseThrow(IllegalStateException::new)}">
                                                ${page.getVehicle().map(vehicle -> vehicle.getBrand().toString()).orElseThrow(IllegalStateException::new)}
                                            </option>
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
                                        <label>Freier Platz (aktuell)</label>
                                            <div class="col">
                                                <div class="row">
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="${CarsPage.ProfileCFreeHeight}">Hoehe (cm)</label>
                                                            <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getCurrentCargoHold().getHeight()).orElse(0.0)}" type="number" class="form-control" name="${CarsPage.ProfileCFreeHeight}" id="${CarsPage.ProfileCFreeHeight}">
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="${CarsPage.ProfileCFreeWidth}">Breite (cm)</label>
                                                            <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getCurrentCargoHold().getWidth()).orElse(0.0)}" type="number" class="form-control" name="${CarsPage.ProfileCFreeWidth}" id="${CarsPage.ProfileCFreeWidth}">
                                                        </div>
                                                    </div>
                                                    <div class="col">
                                                        <div class="form-group">
                                                            <label for="${CarsPage.ProfileCFreeDepth}">Tiefe (cm)</label>
                                                            <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getCurrentCargoHold().getDepth()).orElse(0.0)}" type="number" class="form-control" id="${CarsPage.ProfileCFreeDepth}" name="${CarsPage.ProfileCFreeDepth}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="${CarsPage.ProfileCFreeWeight}">Gewicht (kg)</label>
                                                    <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getCurrentCargoHold().getWeight()).orElse(0.0)}" type="number" class="form-control" name="${CarsPage.ProfileCFreeWeight}" id="${CarsPage.ProfileCFreeWeight}">
                                                </div>
                                            </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-group">
                                        <label for="${CarsPage.ProfileCModel}">Model</label>
                                        <input value="${page.getVehicle().map(vehicle -> vehicle.getModel()).orElse("ERR")}" type="text" class="form-control" name="${CarsPage.ProfileCModel}" id="${CarsPage.ProfileCModel}">
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <label>Freier Platz (maximum)</label>
                                        <div class="col">
                                            <div class="row">
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label for="${CarsPage.ProfileCMaxHeight}">Hoehe (cm)</label>
                                                        <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getMaxCargoHold().getHeight()).orElse(0.0)}" class="form-control" name="${CarsPage.ProfileCMaxHeight}" id="${CarsPage.ProfileCMaxHeight}">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label for="${CarsPage.ProfileCMaxWidth}">Breite (cm)</label>
                                                        <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getMaxCargoHold().getWidth()).orElse(0.0)}" class="form-control" name="${CarsPage.ProfileCMaxWidth}" id="${CarsPage.ProfileCMaxWidth}">
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="form-group">
                                                        <label for="${CarsPage.ProfileCMaxDepth}">Tiefe (cm)</label>
                                                        <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getMaxCargoHold().getDepth()).orElse(0.0)}" class="form-control" name="${CarsPage.ProfileCMaxDepth}" id="${CarsPage.ProfileCMaxDepth}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="${CarsPage.ProfileCMaxWeight}">Gewicht (kg)</label>
                                                <input value="${"" + page.getVehicle().map(vehicle -> vehicle.getMaxCargoHold().getWeight()).orElse(0.0)}" class="form-control" name="${CarsPage.ProfileCMaxWeight}" id="${CarsPage.ProfileCMaxWeight}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <button type="submit" class="btn btn-primary mb-2">Aenderungen bestaetigen</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>

`)
