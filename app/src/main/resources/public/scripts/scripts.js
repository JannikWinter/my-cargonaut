// TODO: Only loaded if a user is logged in.

function logout() {
    const path = "/"
    const param= {
        headers: {
            "content-type":"application/x-www-form-urlencoded"
        },
        body: {
            status:"logoutRequested"
        },
        method:"GET"
    };

    fetch(path, param)
        .then(res => res.json());
}