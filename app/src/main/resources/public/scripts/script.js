function validateRegistrationForm() {
    let registerForm = document.forms["registration"];

    if(registerForm["registerPw"].value !== registerForm["registerPw2"].value) {
        let elem = document.getElementById("registerPw2Fb");
        elem.innerText = "Die beiden Passwörter stimmten nicht überein";
        registerForm["registerPw2"].value = "";
        return false;
    }
}

// argument of function is id of the input field
function validateLocationInput(id) {

    let httpRequest = new XMLHttpRequest();
    let inputElement = document.getElementById(id);
    let address =  "https://nominatim.openstreetmap.org/search?"

    console.log(id);

    let query = inputElement.value;
    console.log(query);
    address = address + "q=" + query;
    console.log(address);

    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === 4) {
            if(httpRequest.status === 404) {
                console.log("shiet!");
            }
            let resBod = httpRequest.responseText;
            let jsonObj = JSON.parse(resBod);
        }
    };

    httpRequest.open("GET", address, true);
    httpRequest.send();
}

function test() {
    let httpRequest = new XMLHttpRequest();
    let inputElement = document.getElementById(id);
    let address =  "https://nominatim.openstreetmap.org/search?"

    console.log(id);

    let query = inputElement.value;
    console.log(query);
    address = address + "q=" + query;
    console.log(address);

    httpRequest.onreadystatechange = () => {
        if(httpRequest.readyState === 4) {
            if(httpRequest.status === 404) {
                console.log("shiet!");
            }
            let resBod = httpRequest.responseText;
            let jsonObj = JSON.parse(resBod);
        }
    };

    httpRequest.open("GET", address, true);
    httpRequest.send();
}