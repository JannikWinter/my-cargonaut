function validateRegistrationForm() {
    let registerForm = document.forms["registration"];

    if(registerForm["registerPw"].value !== registerForm["registerPw2"].value) {
        let elem = document.getElementById("registerPw2Fb");
        elem.innerText = "Die beiden Passwörter stimmten nicht überein";
        registerForm["registerPw2"].value = "";
        return false;
    }
}