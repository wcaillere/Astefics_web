function validateTeacher() {

    let validate = true;

    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;

    if (firstname === "" || firstname.length > 40) {
        document.getElementById("firstnameError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("firstnameError").style.visibility = "hidden";
    }

    if (lastname === "" || lastname.length > 40) {
        document.getElementById("lastnameError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("lastnameError").style.visibility = "hidden";
    }

    return validate;
}