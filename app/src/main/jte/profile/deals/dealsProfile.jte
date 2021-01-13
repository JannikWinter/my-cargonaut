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
                <div class="container text-body">
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

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

`)

