
@param my_cargonaut.landing.LandingPage page

@layout.page(page = page, content = @`
    <form>
      <div class="container-fluid cargonautColor">
        <div class="row">
          <div class="col">
            <div class="mb-3">
              <label class="form-label" for="startCity">Ausgangsstadt</label>
              <input type="text" class="form-control" id="startCity" placeholder="Von">
            </div>
          </div>
          <div class="col">
            <div class="mb-3">
              <label for="endCity" class="form-label">Zielstadt</label>
              <input type="text" class="form-control" id="endCity" placeholder="Nach">
            </div>
          </div>
          <div class="col"></div>
          <div class="col">
            <div class="mb-3">
              <label for="startDate" class="form-label">Zeitraum von</label>
              <input type="date" class="form-control" id="startDate" placeholder="">
            </div>
          </div>
          <div class="col">
            <div class="mb-3">
              <label for="endDate" class="form-label">bis</label>
              <input type="date" class="form-control" id="endDate" placeholder="">
            </div>
          </div>
        </div>
        <div class="row">
          <label class="col-1 col-form-label">Ladung</label>
          <div class="col">
            <div class="mb-3">
              <label for="length" class="form-label">Laenge (cm)</label>
              <input type="number" class="form-control" id="length" placeholder="0">
            </div>
          </div>
          <div class="col">
            <div class="mb-3">
              <label for="width" class="form-label">Breite (cm)</label>
              <input type="number" class="form-control" id="width" placeholder="0">
            </div>
          </div>
          <div class="col">
            <div class="mb-3">
              <label for="height" class="form-label">Hoehe (cm)</label>
              <input type="number" class="form-control" id="height" placeholder="0">
            </div>
          </div>
          <div class="col"></div>
          <div class="col">
            <label for="searchType" class="form-label">Suche...</label>
            <select class="form-select" id="searchType" aria-label="choose between offer and request">
              <option selected value="0">Angebote</option>
              <option value="1">Gesuche</option>
            </select>
          </div>
        </div>
      </div>
    </form>
`)

