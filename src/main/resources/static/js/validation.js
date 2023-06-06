function validatePerson() {

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

function validateFormation() {
    let validate = true;

    let name = document.getElementById("name").value;
    let date = document.getElementById("date").value;
    let nbDays = document.getElementById("nbDays").value;
    let price = document.getElementById("price").value;
    let program = document.getElementById("program").value;

    if (name === "" || name.length > 255) {
        document.getElementById("nameError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("nameError").style.visibility = "hidden";
    }

    if (date === "") {
        document.getElementById("dateError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("dateError").style.visibility = "hidden";
    }

    if (nbDays === "" || nbDays <= 0) {
        document.getElementById("nbDaysError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("nbDaysError").style.visibility = "hidden";
    }

    if (price === "" || price < 0) {
        document.getElementById("priceError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("priceError").style.visibility = "hidden";
    }

    if (program === "" || program.length > 1000) {
        document.getElementById("programError").style.visibility = "visible";
        validate = false;
    } else {
        document.getElementById("programError").style.visibility = "hidden";
    }

    return validate;
}