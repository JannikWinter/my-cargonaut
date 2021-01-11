@import my_cargonaut.landing.LandingPage
@import my_cargonaut.offer.search.OffersSearchPage

@param LandingPage page

@layout.page(page = page, content = @`

<div class="container bg-light mt-5">
    <div class="row justify-content-center" style="align-self: center">
        <div class="col-6">
            <div class="bg-light">
                <nav class="flex-column" style="text-align: center">
                    <h4 class="mt-2">Suche</h4>
                    <br>
                    <form class="form" role="form" name="${page.offerSearchForm}" method="get" action="${OffersSearchPage.PATH}">
                    <div class="col form-group">
                        <select class="form-control" id="createDropdown">
                            <option>Angebot</option>
                            <option>Gesuch</option>
                        </select>
                    </div>
                    <br>
                    <div class="col form-group">
                        <input name="${page.offerSearchFormOrig}" type="text" class="form-control" id="${page.offerSearchFormOrig}" placeholder="Von" required>
                    </div>
                    <div class="col form-group">
                        <input name="${page.offerSearchFormDest}" type="text" class="form-control" id="${page.offerSearchFormDest}" placeholder="Nach" required>
                    </div>
                    <div class="col form-group">
                        <input name="${page.offerSearchFormStartT}" type="datetime-local" class="form-control" id="${page.offerSearchFormStartT}">
                    </div>
                    <div class="col form-group">
                        <input name="${page.offerSearchFormEndT}" type="datetime-local" class="form-control" id="${page.offerSearchFormEndT}">
                    </div>
                    <br>
                    <br>
                    <div class="col form-group">
                        <button class="btn btn-primary" name="apply" type="submit"><i class="fa fa-search"></i></button>
                    </div>
                    </form>
                </nav>
            </div>
        </div>
    </div>
</div>

`)

