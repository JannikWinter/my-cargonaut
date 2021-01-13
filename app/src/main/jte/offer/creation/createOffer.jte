@import my_cargonaut.offer.creation.OfferCreationPage;

@param my_cargonaut.offer.creation.OfferCreationPage page

@layout.page(page = page, content = @`

@if(page.wasOfferCreationAttempted())
@if(page.hasOfferCreationSucceeded())
<div class="container-fluid mx-auto">
    <div class="alert alert-success">
        <strong>Ihr Angebot wurde erstellt!</strong>
    </div>
</div>
@else
<div class="container-fluid mx-auto">
    <div class="alert alert-danger">
        <strong>Angebotserstellung fehlgeschlagen:</strong> ${"" + page.getCreationErrorMsg()}
    </div>
</div>
@endif
@endif

<div class="container bg-light mt-5">
    <div class="row justify-content-center" style="align-self: center">
        <div class="col-6">
            <div class="bg-light">
                <nav class="flex-column" style="text-align: center">
                    <h4 class="mt-2">Erstellen</h4>
                    <br>
                    <form class="form" role="form" name="${OfferCreationPage.offerCForm}" method="post" action="${OfferCreationPage.PATH}">
                    <div class="col form-group">
                        <select class="form-control" id="createDropdown">
                            <option>Angebot</option>
                            <option>Gesuch</option>
                        </select>
                    </div>
                    <br>
                    <div class="col form-group">
                        <input name="${OfferCreationPage.offerCFormStart}" type="text" class="form-control" id="${OfferCreationPage.offerCFormStart}" placeholder="Von" required>
                    </div>
                    <div class="col form-group">
                        <input name="${OfferCreationPage.offerCFormDest}" type="text" class="form-control" id="${OfferCreationPage.offerCFormDest}" placeholder="Nach" required>
                    </div>
                    <div class="col form-group">
                        <input name="${OfferCreationPage.offerCFormStartTime}" type="datetime-local" class="form-control" id="${OfferCreationPage.offerCFormStartTime}" required>
                    </div>

                    <div class="col form-group">
                        <div class="row">
                            <div class="col form-group">
                                <input name="${OfferCreationPage.offerCFormHeight}" type="text" class="form-control" id="${OfferCreationPage.offerCFormHeight}" placeholder="Hoehe" required>
                            </div>
                            <div class="col form-group">
                                <input name="${OfferCreationPage.offerCFormLength}" type="text" class="form-control" id="${OfferCreationPage.offerCFormLength}" placeholder="Breite" required>
                            </div>
                            <div class="col form-group">
                                <input name="${OfferCreationPage.offerCFormDepth}" type="text" class="form-control" id="${OfferCreationPage.offerCFormDepth}" placeholder="Tiefe" required>
                            </div>
                            <div class="col form-group">
                                <input name="${OfferCreationPage.offerCFormWeight}" type="text" class="form-control" id="${OfferCreationPage.offerCFormWeight}" placeholder="Gewicht" required>
                            </div>
                        </div>
                    </div>

                    <div class="col form-group">
                        <textarea name="${OfferCreationPage.offerCFormDesc}" class="form-control" id="${OfferCreationPage.offerCFormDesc}" rows="3" placeholder="Beschreibung"></textarea>
                    </div>
                    <br>
                    <br>
                    <div class="col form-group">
                        <button class="btn btn-primary" name="apply" type="submit"><i class="fa fa-plus"></i></button>
                    </div>
                    </form>
                </nav>
            </div>
        </div>
    </div>
</div>

`)