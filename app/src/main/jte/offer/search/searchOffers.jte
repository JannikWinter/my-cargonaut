@import gg.jte.support.ForSupport;
@import my_cargonaut.offer.search.OffersSearchPage;
@import my_cargonaut.utility.data_classes.Measurements;
@import java.text.SimpleDateFormat;

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
                            <input name="${page.offerSearchFormOrig}" type="text" class="form-control" id="${page.offerSearchFormOrig}"
                                placeholder="Von" value="${page.getEnteredValue(page.offerSearchFormOrig)}">
                        </div>
                    </div>
                </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormDest}" class="form-label">Zielstadt</label>
                        <input name="${page.offerSearchFormDest}" type="text" class="form-control" id="${page.offerSearchFormDest}"
                            placeholder="Nach" value="${page.getEnteredValue(page.offerSearchFormDest)}">
                    </div>
                </div>
              </div>
              <div class="col"></div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormStartT}" class="form-label">Zeitraum von</label>
                        <input name="${page.offerSearchFormStartT}" type="datetime-local" class="form-control" id="${page.offerSearchFormStartT}"
                            placeholder="" value="${page.getEnteredValue(page.offerSearchFormStartT)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormEndT}" class="form-label">bis</label>
                        <input name="${page.offerSearchFormEndT}" type="datetime-local" class="form-control" id="${page.offerSearchFormEndT}"
                            placeholder="" value="${page.getEnteredValue(page.offerSearchFormEndT)}">
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
                        <input name="${page.offerSearchFormCargoHeight}" type="number" class="form-control" id="${page.offerSearchFormCargoHeight}"
                            placeholder="0" value="${page.getEnteredValue(page.offerSearchFormCargoHeight)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormCargoWidth}" class="form-label">Breite (cm)</label>
                        <input name="${page.offerSearchFormCargoWidth}" type="number" class="form-control" id="${page.offerSearchFormCargoWidth}"
                            placeholder="0" value="${page.getEnteredValue(page.offerSearchFormCargoWidth)}">
                    </div>
                </div>
              </div>
              <div class="col">
                <div class="mb-3">
                    <div class="form-group">
                        <label for="${page.offerSearchFormCargoDepth}" class="form-label">Tiefe (cm)</label>
                        <input name="${page.offerSearchFormCargoDepth}" type="number" class="form-control" id="${page.offerSearchFormCargoDepth}"
                            placeholder="0" value="${page.getEnteredValue(page.offerSearchFormCargoDepth)}">
                    </div>
                </div>
              </div>
              <div class="col">
                  <div class="mb-3">
                      <div class="form-group">
                          <label for="${page.offerSearchFormCargoMaxWeight}" class="form-label">Maximalgewicht (kg)</label>
                          <input name="${page.offerSearchFormCargoMaxWeight}" type="number" class="form-control" id="${page.offerSearchFormCargoMaxWeight}"
                              placeholder="0" value="${page.getEnteredValue(page.offerSearchFormCargoMaxWeight)}">
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

<!-- now...the results -->
<div class="container bg-light table-responsive pt-2">
    <table class="table table-striped table-hover">
        <thead class="table-border">
            <tr class="table-primary">
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">#</th>
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">Angebotstitel</th>
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">Von</th>
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">Nach</th>
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">Abfahrtdatum</th>
                <th scope="col" rowspan="2" style="vertical-align:middle;text-align:center;">Abfahrtzeit</th>
                <th scope="col" colspan="4" class="text-center">Stauraum</th>
            </tr>
            <tr class="table-primary">
                <th scope="col">Hoehe(cm)</th>
                <th scope="col">Breite(cm)</th>
                <th scope="col">Tiefe(cm)</th>
                <th scope="col">Maximalgewicht(kg)</th>
            </tr>
        </thead>

        @if(page.displaysQueryResult())
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
                <td>${new SimpleDateFormat("HH:mm").format(el.get().getRoute().getStartTime())}</td>
                <td>${"" + el.get().getFreeSpace().map(Measurements::getHeight).orElse(0.0)}</td>
                <td>${"" + el.get().getFreeSpace().map(Measurements::getWidth).orElse(0.0)}</td>
                <td>${"" + el.get().getFreeSpace().map(Measurements::getDepth).orElse(0.0)}</td>
                <td>${"" + el.get().getFreeSpace().map(Measurements::getWeight).orElse(0.0)}</td>
            </tr>
            @endfor
        </tbody>
        @endif
    </table>

</div>

`)

