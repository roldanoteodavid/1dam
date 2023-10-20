const CODIGO = 25;

function misterio1(edad) {
    if (typeof (edad) === "number" && edad >= 18 && edad <= 120) {
        return "Puedes conducir";
    } else {
        return "Introduce un numero válido";
    }
}

function misterio2(numbermonth) {
    if (numbermonth == 1) {
        return "Enero"
    } else if (numbermonth == 2) {
        return "Febrero"
    } else if (numbermonth == 3) {
        return "Marzo"
    } else if (numbermonth == 4) {
        return "Abril"
    } else if (numbermonth == 5) {
        return "Mayo"
    } else if (numbermonth == 6) {
        return "Junio"
    } else if (numbermonth == 7) {
        return "Julio"
    } else if (numbermonth == 8) {
        return "Agosto"
    } else if (numbermonth == 9) {
        return "Septiembre"
    } else if (numbermonth == 10) {
        return "Octubre"
    } else if (numbermonth == 11) {
        return "Noviembre"
    } else if (numbermonth == 12) {
        return "Diciembre"
    } else {
        return "No es un mes"
    }
}
function misterio3(operation, number1, number2) {
    if (typeof (number1) === "number" && typeof (number2) === "number") {
        return "Los valores no son números"
    }else if(operation !== "suma" && operation !== "resta" && operation !== "multiplicación" && operation !== "división"){
        return "Introduce operación válida"
    }else if(operation===division){

    }
}
function misterio4() {
    return true;
}
function misterio5() {
    return true;
}
function misterio6() {
    return true;
}
function misterio7() {
    return true;
}
function misterio8() {
    return true;
}
function misterio9() {
    return true;
}
function misterio10() {
    return true;
}
function misterio11() {
    return true;
}
function misterio12() {
    return true;
}
function misterio13() {
    return true;
}
function misterio14() {
    return true;
}
function misterio15() {
    return true;
}
function misterio16() {
    return true;
}
function misterio17() {
    return true;
}
function misterio18() {
    return true;
}
function misterio19() {
    return true;
}
function misterio20() {
    return true;
}



module.exports = {
    misterio1,
    misterio2,
    misterio3,
    misterio4,
    misterio5,
    misterio6,
    misterio7,
    misterio8,
    misterio9,
    misterio10,
    misterio11,
    misterio12,
    misterio13,
    misterio14,
    misterio15,
    misterio16,
    misterio17,
    misterio18,
    misterio19,
    misterio20,
    CODIGO
}