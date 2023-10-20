document.getElementById("bCalculate").addEventListener("click", calculate);

function calculate() {
    let radius = document.getElementById("tbradius").value;
    let volume = (4 / 3 * Math.PI * Math.pow(radius, 3));
    document.getElementById("tbvolume").value = volume;
}