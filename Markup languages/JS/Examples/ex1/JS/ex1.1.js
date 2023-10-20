document.getElementById("bClickMe").addEventListener("click", showMessage);

function showMessage() {
    let name = document.getElementById("tbNameofuser").value;
    document.getElementById("lmessage").innerHTML = "Helloooo " + name;
}