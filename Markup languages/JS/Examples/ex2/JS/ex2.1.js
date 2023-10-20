document.getElementById("itext").addEventListener("keyup", toUpper);
document.getElementById("itext").addEventListener("focusout", validateLenght);
document.getElementById("imail").addEventListener("focusout", validateMail);
document.getElementById("iage").addEventListener("focusout", validateAge);
document.getElementById("button-cancel").addEventListener("click", resetForm);

function toUpper() {
    var input = document.getElementById("itext").value;
    document.getElementById("itext").value = input.toUpperCase();
}

function validateLenght() {
    var input = document.getElementById("itext");
    if (input.value.length < 2 || input.value.length > 25) {
        input.style.backgroundColor = 'red';
        document.getElementById("derror").textContent = "invalid name lenght";
    } else {
        input.style.backgroundColor = 'white';
        document.getElementById("derror").textContent = "";
    }
}

function validateMail() {
    var mail = document.getElementById("imail");
    if (mail.checkValidity() == false) {
        mail.style.backgroundColor = 'red';
    } else {
        input.style.backgroundColor = 'white';
    }
}
function validateAge() {
    var input = document.getElementById("iage");
    if (input.value < 0 || input.value > 120) {
        input.style.backgroundColor = 'red';
    } else {
        input.style.backgroundColor = 'white';
    }
}
function resetForm(ev) {
    ev.preventDefault();
    let answer = confirm("Are you sure that you want to reset all the data?")
    if (answer) {
        document.getElementById("form-user").reset();
    }
}