@import gg.jte.Content
@import gg.jte.support.ForSupport
@import my_cargonaut.profile.deals.DealsPage;import my_cargonaut.profile.edit.EditPage
@import my_cargonaut.profile.cars.CarsPage;import my_cargonaut.utility.data_classes.Measurements;import my_cargonaut.utility.data_classes.user.User;import java.text.SimpleDateFormat

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
                    <form class="container bg-light table-responsive pt-2" role="form" name="${page.dealsPageForm}" method="post" action="${DealsPage.getDynamicPath(page.getCurrentUser().get().getUsername())}">
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

                            @for(var el : ForSupport.of(page.getOfferList()))
                            <tr>
                                <th scope="row">${el.getIndex()}</th>
                                <td>
                                    <a href="#">${"" + el.get().getUser().getUsername() + "'s Tour von "
                                        + el.get().getRoute().getStartLoc().getLocationName() + " nach "
                                        + el.get().getRoute().getEndLoc().getLocationName()}
                                    </a>
                                </td>
                                <td>${el.get().getRoute().getStartLoc().getLocationName()}</td>
                                <td>${el.get().getRoute().getEndLoc().getLocationName()}</td>
                                <td>${new SimpleDateFormat("dd. MM. yyyy").format(el.get().getRoute().getStartTime())}</td>
                                <td>${el.get().getVehicle().map(vic -> "" + vic.getBrand().toString() + " " + vic.getModel()).orElseThrow(IllegalStateException::new)}</td>
                                @if(el.get().hasOfferAcceptor())
                                <td>
                                    <input disabled type="text" name="${page.dealsPageFormAcceptionUser}" class="form-control"
                                        value="${el.get().getOfferAcceptor().map(User::getUsername).orElseThrow(IllegalStateException::new)}">
                                    <input hidden type="text" name="${page.dealsPageFormOfferID}" value="${"" + el.get().getOfferID()}">
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-success">
                                        <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                                    </button>
                                </td>
                                @else
                                <td>
                                    <input type="text" name="${page.dealsPageFormAcceptionUser}" class="form-control"
                                        placeholder="Angebotspartner" value="${el.get().getOfferAcceptor().map(User::getUsername).orElse("")}">
                                    <input hidden type="text" name="${page.dealsPageFormOfferID}" value="${"" + el.get().getOfferID()}">
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-failure">
                                        <i class="fa fa-lock-alt" aria-hidden="true"></i>
                                    </button>
                                </td>
                                @endif
                            </tr>
                            @endfor

                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

`)

