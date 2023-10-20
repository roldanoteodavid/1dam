//document.getElementById("b1").addEventListener("click", check)
let player = "X";
let buttonGrid = Array.from(document.getElementsByClassName("bGrid"))
buttonGrid.forEach(x => x.addEventListener("click", check))

function check(event) {
    let selectedButton = event.target;
    if (selectedButton.innerText == "") {
        selectedButton.innerText = player;
        if (!checkForWinner()) {
            changePlayer();
        } else {
            disableButtons();
            let message = document.getElementById("textMessages");
            message.innerText("Congratulations, player " + player + " wins!")
        }
    }
}

function changePlayer() {
    let message = document.getElementById("textMessages");
    if (player === "X") {
        player = "O"
    } else {
        player = "X"
    }
    message.innerText = "Turn for player " + player;

}

function checkForWinner() {
    for(let i = 0; i<3;i++){

    }
    return false;
}

function disableButtons(){
    buttonGrid.forEach(x=>x.disable=true);
}