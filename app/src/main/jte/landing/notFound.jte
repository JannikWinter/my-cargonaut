@import my_cargonaut.landing.NotFoundPage

@param NotFoundPage page

@layout.page(page = page, content = @`
    <div class="container d-flex justify-content-center">
        <h1>Error 404: Not found</h1>
    </div>
`)