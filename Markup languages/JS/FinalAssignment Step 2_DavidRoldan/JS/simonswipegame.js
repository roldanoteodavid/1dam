document.getElementById("create").addEventListener("click", startGame);
let sequence = [];
let roundNr;
let guess;
let score;

function startGame() {
    guess = 0;
    roundNr = 1;
    score = 0;
    let timer = 0;
    document.getElementById("rows").disabled = true;
    document.getElementById("columns").disabled = true;
    let rows = document.getElementById("rows").value;
    let columns = document.getElementById("columns").value;
    let level = document.getElementById("level").value;
    document.getElementById("level").disabled = true;
    document.getElementById("create").disabled = true;
    document.getElementById("message").innerText = ("PLAYING...");
    document.getElementById("score").innerText = ("Score: " + score);
    document.getElementById("crono").innerText = ("Seconds: " + timer);
    timeInterval = setInterval(seconds, 1000)
    function seconds() {
        document.getElementById("crono").innerText = ("Seconds: " + timer);
        timer++;
    }
    drawField(rows, columns);
    generateSequence(rows, columns, level);
    playSequence();
}

function drawField(rows, columns) {
    let field = document.getElementById("field");
    let colors = ["turquoise", "blue", "green", "yellow", "orange", "purple", "pink", "gray", "brown", "black", "cyan", "magenta", "gold", "silver", "teal", "navy", "olive", "maroon", "lime", "aqua", "fuchsia", "white", "indigo", "crimson", "salmon"];
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

function generateSequence(rows, columns, level) {
    let numElements = 5 * level;
    for (let i = 0; i < numElements; i++) {
        let x = Math.floor(Math.random() * rows);
        let y = Math.floor(Math.random() * columns);
        sequence.push([x, y]);
    }
}

function playSequence() {
    disableEventsField();
    let i = 0;
    let myinterval = setInterval(showElement, 1000);
    function showElement() {
        let [x, y] = sequence[i];
        let buttonId = x + "_" + y;
        let button = document.getElementById(buttonId);
        let color = button.style.backgroundColor;
        setTimeout(restoreColor, 800, button, color);
        button.style.backgroundColor = "red";
        i = i + 1;
        if (i == roundNr) {
            clearInterval(myinterval);
        }
    }
    setTimeout(enableEventsField, 1000 * roundNr);
}

function restoreColor(button, color) {
    button.style.backgroundColor = color;
}

function check(e) {
    let point = e.target.id.split('_');
    let x = point[0];
    let y = point[1];
    //console.log("The button " + x + ", " + y + " has been clicked");
    let [xa, ya] = sequence[guess];
    if (x == xa && y == ya) {
        guess = guess + 1;
    } else {
        disableEventsField();
        document.getElementById("message").innerText = ("You lose :(");
        clearInterval(timeInterval);
    }
    if (guess == roundNr) {
        score++;
        document.getElementById("score").innerText = ("Score: " + score);
        guess = 0;
        roundNr = roundNr + 1;
        if (roundNr > sequence.length) {
            disableEventsField();
            document.getElementById("message").innerText = ("You won!");
            clearInterval(timeInterval);
        } else {
            playSequence();
        }
    }
}

function enableEventsField() {
    let buttons = document.getElementsByClassName('buttonGrid');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].addEventListener("click", check);
    }
}

function disableEventsField() {
    let buttons = document.getElementsByClassName('buttonGrid');
    for (let i = 0; i < buttons.length; i++) {
        buttons[i].removeEventListener('click', check);
    }
}