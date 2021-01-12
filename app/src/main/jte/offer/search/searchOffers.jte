@import my_cargonaut.offer.search.OffersSearchPage

@param OffersSearchPage page

@layout.page(page = page, content = @`

<div class="container-fluid mt-1 p-2 text-body bg-light">
    <div class="row mb-3">
        <div class="col">
            <button type="button" class="btn btn-sm btn-outline-info" data-toggle="collapse" data-target="#offerSearchFilter">Filter anzeigen/ausblenden</button>
        </div>
    </div>
    <div id="offerSearchFilter" class="collapse">
        <form class="form" role="form" name="${page.offerSearchForm}" method="get" action="${OffersSearchPage.PATH}">
            <div class="row">
                <div class="col">
                    <div class="mb-3">
                        <div class="form-group">
                            <label class="form-label" for="${page.offerSearchFormOrig}">Ausgangsstadt</label>
                            <input name="${page.offerSearchFormOrig}" type="text" class="form-control"
                                id="${page.offerSearchFormOrig}" placeholder="Von"
                                value="${page.getEnteredValue(page.offerSearchFormOrig)}">
                        </div>
                    </div>
                </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormDest}" class="form-label">Zielstadt</label>
                        <input name="${page.offerSearchFormDest}" type="text" class="form-control"
                            id="${page.offerSearchFormDest}" placeholder="Nach"
                            value="${page.getEnteredValue(page.offerSearchFormDest)}">
                    </div>
                </div>
              </div>
              <div class="col"></div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormStartT}" class="form-label">Zeitraum von</label>
                        <input name="${page.offerSearchFormStartT}" type="date" class="form-control"
                            id="${page.offerSearchFormStartT}" placeholder=""
                            value="${page.getEnteredValue(page.offerSearchFormStartT)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormEndT}" class="form-label">bis</label>
                        <input name="${page.offerSearchFormEndT}" type="date" class="form-control"
                            id="${page.offerSearchFormEndT}" placeholder=""
                            value="${page.getEnteredValue(page.offerSearchFormEndT)}">
                    </div>
                </div>
              </div>
              <div class="col-1"></div>
            </div>
            <div class="row">
              <label class="col-1 col-form-label">Ladung</label>
            </div>
            <div class="row">
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormCargoHeight}" class="form-label">Hoehe (cm)</label>
                        <input name="${page.offerSearchFormCargoHeight}" type="number" class="form-control"
                            id="${page.offerSearchFormCargoHeight}" placeholder="0" min="0"
                            value="${page.getEnteredValue(page.offerSearchFormCargoHeight)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormCargoWidth}" class="form-label">Breite (cm)</label>
                        <input name="${page.offerSearchFormCargoWidth}" type="number" class="form-control"
                            id="${page.offerSearchFormCargoWidth}" placeholder="0" min="0"
                            value="${page.getEnteredValue(page.offerSearchFormCargoWidth)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormCargoDepth}" class="form-label">Tiefe (cm)</label>
                        <input name="${page.offerSearchFormCargoDepth}" type="number" class="form-control"
                            id="${page.offerSearchFormCargoDepth}" placeholder="0" min="0"
                            value="${page.getEnteredValue(page.offerSearchFormCargoDepth)}">
                    </div>
                </div>
              </div>
              <div class="col">
                  <div class="mb-3">
                      <div class="form-group">
                          <label for="${page.offerSearchFormCargoWeight}" class="form-label">Gewicht (kg)</label>
                          <input name="${page.offerSearchFormCargoWeight}" type="number" class="form-control"
                              id="${page.offerSearchFormCargoWeight}" placeholder="0" min="0"
                              value="${page.getEnteredValue(page.offerSearchFormCargoWeight)}">
                      </div>
                  </div>
              </div>
              <div class="col"></div>
              <div class="col">
                <!--
                <div class="form-group">
                  <label for="searchType" class="form-label">Suche...</label>
                      <select class="form-control" id="searchType" aria-label="choose between offer and request">
                        <option selected value="0">Angebote</option>
                        <option value="1">Gesuche</option>
                      </select>
                </div>
                -->
              </div>
              <div class="col-1">
              </div>
            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col-1">
                    <button class="btn btn-primary" name="searchOfferSubmit" type="submit"><i class="fa fa-search"></i></button>
                </div>
            </div>
        </form>
    </div>
</div>
`)

