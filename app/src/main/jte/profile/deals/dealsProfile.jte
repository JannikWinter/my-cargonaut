@import gg.jte.Content
@import my_cargonaut.profile.edit.EditPage
@import my_cargonaut.profile.cars.CarsPage

@param my_cargonaut.profile.deals.DealsPage page

@layout.page(page = page, content = @`

<div class="container">
    <div class="row">
        <div class="col-lg-2 col-md-12">
            <div class="bg-light">
                <nav class="nav nav-tabs flex-column">
                    <a class="nav-link" href="${EditPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Profil</a>
                    <a class="nav-link active" href="#">Deals</a>
                    <a class="nav-link" href="${CarsPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">Fuhrpark</a>
                </nav>
            </div>
        </div>
        <!-- Right-sided content -> Edit-Profile -->
        <div class="col-lg-10 col-md-12">
            <div class="bg-light">
                <div class="container">
                    <h2>Meine Deals</h2>
                    <div class="container bg-light table-responsive pt-2">
                        <table class="table table-striped table-hover">
                            <thead class="table-border">
                            <tr class="table-primary">
                                <th scope="col">#</th>
                                <th scope="col">Angebotstitel</th>
                                <th scope="col">Von</th>
                                <th scope="col">Nach</th>
                                <th scope="col">Abfahrtdatum</th>
                                <th scope="col">Fahrzeug</th>
                                <th scope="col">Angenommen von:</th>
                                <th scope="col">Status</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td><a href="#">USERS's Tour von START nach ENDE</a></td>
                                <td>START</td>
                                <td>ENDE</td>
                                <td>01.01.1970</td>
                                <td>Fahrzeug Name</td>
                                <td><input type="text" name="cargonautee" class="form-control"></td>
                                <td>
                                    <button type="button" class="btn btn-success">
                                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td><a href="#">USERS's Tour von START nach ENDE</a></td>
                                <td>START</td>
                                <td>ENDE</td>
                                <td>01.01.1970</td>
                                <td>Fahrzeug Name</td>
                                <td style="vertical-align:middle;text-align:center;">Locked</td>
                                <td>
                                    <button type="button" class="btn btn-danger">
                                        <i class="fa fa-lock" aria-hidden="true"></i>
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

`)

