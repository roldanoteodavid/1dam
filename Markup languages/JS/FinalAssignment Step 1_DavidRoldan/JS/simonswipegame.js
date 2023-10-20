document.getElementById("create").addEventListener("click", startGame);

function startGame() {
    document.getElementById("rows").disabled = true;
    document.getElementById("columns").disabled = true;
    let rows = document.getElementById("rows").value;
    let columns = document.getElementById("columns").value;
    document.getElementById("level").disabled = true;
    document.getElementById("create").disabled = true;
    document.getElementById("message").innerText = ("PLAYING...");
    document.getElementById("crono").innerText = ("Seconds: ")
    document.getElementById("score").innerText = ("Score: ")
    drawField(rows, columns);
    playSequence(rows, columns);
}

function drawField(rows, columns) {
    let field = document.getElementById("field");
    let colors = ["red", "blue", "green", "yellow", "orange", "purple", "pink", "gray", "brown", "black", "cyan", "magenta", "gold", "silver", "teal", "navy", "olive", "maroon", "lime", "aqua", "fuchsia", "white", "indigo", "crimson", "salmon"];
    let k = 0
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
            let newButton = document.createElement("button");
            newButton.className = "buttonGrid";
            newButton.id = i + "_" + j;
            newButton.style.backgroundColor = colors[k];
            newButton.style.width = "50px";
            newButton.style.height = "50px";
            k++;
            //newButton.addEventListener("click", check);
            field.appendChild(newButton);
        }
        let lineBreak = document.createElement("br");
        field.appendChild(lineBreak);
    }
}

function playSequence(rows, columns) {
    let buttons = document.getElementsByClassName('buttonGrid');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener("click", check);
    }
    //disableEventsField();
}

function check(e) {
    let point = e.target.id.split('_');
    let x = point[0];
    let y = point[1];
    console.log("The button " + x + ", " + y + " has been clicked");
}

function disableEventsField() {
    let buttons = document.getElementsByClassName('buttonGrid');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].removeEventListener('click', check);
    }
}