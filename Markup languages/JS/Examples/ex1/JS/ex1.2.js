
document.getElementById("tbFirst").addEventListener("keyup", changefunction)

function changefunction() {
    let name = document.getElementById("tbFirst").value;
    document.getElementById("tbSecond").value = name;
}