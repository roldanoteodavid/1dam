document.getElementById("create").addEventListener("click", startGame);

let sequence = [];
let roundNr;
let guess;
let score;
let difficulty;

function startGame() {
    guess = 0;
    roundNr = 1;
    score = 0;
    let timer = 0;
    let repeatCheck = document.getElementById("repeatCheck");
    if (repeatCheck.checked) {
        showRepeat();
    }
    repeatCheck.disabled = true;
    document.getElementById("rows").disabled = true;
    document.getElementById("columns").disabled = true;
    let rows = document.getElementById("rows").value;
    let columns = document.getElementById("columns").value;
    let level = document.getElementById("level").value;
    assignDifficulty(level);
    document.getElementById("level").disabled = true;
    document.getElementById("create").disabled = true;
    document.getElementById("message").innerText = ("PLAYING...");
    document.getElementById("score").innerText = ("Score: " + score);
    document.getElementById("crono").innerText = ("Seconds: " + timer);
    timeInterval = setInterval(seconds, 1000)
    function seconds() {
        timer++;
        document.getElementById("crono").innerText = ("Seconds: " + timer);
    }
    drawField(rows, columns);
    generateSequence(rows, columns, level);
    playSequence();
}

function assignDifficulty(level) {
    if (level == 1) {
        difficulty = 1000;
    } else if (level == 2) {
        difficulty = 800;
    } else if (level == 3) {
        difficulty = 500;
    }
}

function drawField(rows, columns) {
    let field = document.getElementById("field");
    let colors = ["turquoise", "blue", "green", "saddlebrown", "orange", "purple", "pink", "gray", "brown", "black", "cyan", "magenta", "gold", "silver", "teal", "navy", "olive", "maroon", "lime", "aqua", "fuchsia", "white", "indigo", "crimson", "salmon"];
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
    let myinterval = setInterval(showElement, difficulty);
    function showElement() {
        let [x, y] = sequence[i];
        let buttonId = x + "_" + y;
        let button = document.getElementById(buttonId);
        let color = button.style.backgroundColor;
        setTimeout(restoreColor, difficulty - 100, button, color);
        button.style.backgroundColor = "red";
        i = i + 1;
        if (i == roundNr) {
            clearInterval(myinterval);
        }
    }
    enableEventsField();
}

function restoreColor(button, color) {
    button.style.backgroundColor = color;
}

function changeColor(e, color) {
    e.target.style.backgroundColor = "yellow";
    setTimeout(function () {
        e.target.style.backgroundColor = color;
    }, 100);
}

function check(e) {
    changeColor(e, e.target.style.backgroundColor);
    let point = e.target.id.split('_');
    let x = point[0];
    let y = point[1];
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

function showRepeat() {
    let repeat = document.getElementById("drepeat");
    let newButton = document.createElement("button");
    newButton.id = "repeat";
    newButton.addEventListener("click", repeatLast);
    newButton.innerText = "Repeat last uses=1";
    repeat.appendChild(newButton);
}

function repeatLast() {
    playSequence();
    document.getElementById("repeat").disabled = true;
    document.getElementById("repeat").innerText = "Repeat last uses=0";
}