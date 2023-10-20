let player = "X";


document.getElementById("textMessages").addEventListener("click", createGrid);

function createGrid() {
    let vgrid = document.getElementById("divBoard");
    for (let i = 0; i < 9; i++) {
        let newButton = document.createElement("button");
        newButton.className = "bBoard";
        newButton.id = i;
        newButton.addEventListener("click", check);
        vgrid.appendChild(newButton);
    }
}
function check(event) {
    let selectedButton = event.target;
    if (selectedButton.innerText == "") {
        selectedButton.innerText = player;
        if (!checkForWinner()) {
            changePlayer();
        }
        else {
            disableButtons();
            let message = document.getElementById("textMessages");
            message.innerText = "Player " + player + " wins, congratulations!";
        }

    }
}

function changePlayer() {
    if (player === "X") {
        player = "O";

    }
    else {
        player = "X";
    }
    let message = document.getElementById("textMessages");
    message.innerText = "Turn for player " + player;
}

function checkForWinner() {
    let buttonGrid = Array.from(document.getElementsByClassName("bBoard"));
    //Check rows
    for (let i = 0; i < 9; i = i + 3) {
        if (buttonGrid[0 + i].innerHTML === player && buttonGrid[1 + i].innerHTML === player && buttonGrid[2 + i].innerHTML === player) {
            return true
        }
    }
    //Check columns
    for (let j = 0; j < 3; j++) {
        if (buttonGrid[0 + j].innerHTML === player && buttonGrid[3 + j].innerHTML === player && buttonGrid[6 + j].innerHTML === player) {
            return true
        }
    }
    //Check diagonals
    if ((buttonGrid[0].innerHTML === player && buttonGrid[4].innerHTML === player && buttonGrid[8].innerHTML === player) ||
        (buttonGrid[2].innerHTML === player && buttonGrid[4].innerHTML === player && buttonGrid[6].innerHTML === player)) {
        return true
    }

    //No winner
    return false;
}
function disableButtons() {
    let buttonGrid = Array.from(document.getElementsByClassName("bBoard"));
    buttonGrid.forEach(x => x.disabled = true)
}
