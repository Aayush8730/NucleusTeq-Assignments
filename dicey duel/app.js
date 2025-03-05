// Initial scores and flags
let currentScore1 = 0;
let currentScore2 = 0;
let savedScorePlayer1 = 0;
let savedScorePlayer2 = 0;
let turn1 = true; // Player 1 starts
let turn2 = false;

// Function to generate a random number between 1 and 6
function rollTheDice() {
  let num = Math.floor(Math.random() * 6) + 1;
    diceContainer.innerHTML = "";
    diceContainer.appendChild(createDice(num));
    return num;
}

// Function to show temporary messages
function showMessage(message) {
    const messageBox = document.getElementById("messageBox");
    messageBox.textContent = message;
    messageBox.style.display = "block"; // Show message

    setTimeout(() => {
        messageBox.style.display = "none"; // Hide after 1 second
    }, 1000);
}

// Function to update UI
function updateUI() {
    document.getElementById("currentScore1").textContent = currentScore1;
    document.getElementById("currentScore2").textContent = currentScore2;
    document.getElementById("savedScorePlayer1").textContent = savedScorePlayer1;
    document.getElementById("savedScorePlayer2").textContent = savedScorePlayer2;

    const player1Name = getPlayerName(1);
    const player2Name = getPlayerName(2);

    // document.getElementById("turnIndicator").textContent = turn1 ? `${player1Name}'s Turn` : `${player2Name}'s Turn`;
    document.getElementById("player1Name").textContent = player1Name;
    document.getElementById("player2Name").textContent = player2Name;
    changeColorOnTurn();
  
    // Check if we have a winner
    checkWinner();
}


function getPlayerName(playerNumber) {
  const nameInput = document.getElementById(`player${playerNumber}Input`).value.trim().toUpperCase();
  return nameInput === "" ? `PLAYER ${playerNumber}` : nameInput;
}


function updatePlayerName(playerNumber) {
    document.getElementById(`player${playerNumber}Name`).textContent = getPlayerName(playerNumber);
    updateUI();
}


function checkWinner() {
    const player1Name = getPlayerName(1);
    const player2Name = getPlayerName(2);

    if (savedScorePlayer1 >= 100) {
        showMessage(`🎉 ${player1Name} Wins! 🎉`);
        disableGame();
    } else if (savedScorePlayer2 >= 100) {
        showMessage(`🎉 ${player2Name} Wins! 🎉`);
        disableGame();
    }
}


function disableGame() {
    document.querySelectorAll("button").forEach(button => {
        if (!button.classList.contains("reset")) {
            button.disabled = true;
        }
    });
}


function cumulateCurrentScore1() {
    if (!turn1) {
        showMessage(`❌ It's not your turn! Wait for ${getPlayerName(2)}.`);
        return;
    }

    let addPoints = rollTheDice();
    if (addPoints === 1) {
        currentScore1 = 0;
        turn1 = false;
        turn2 = true;
    } else {
        currentScore1 += addPoints;
    }
    updateUI();
}


function cumulateCurrentScore2() {
    if (!turn2) {
        showMessage(`❌ It's not your turn! Wait for ${getPlayerName(1)}.`);
        return;
    }

    let addPoints = rollTheDice();
    if (addPoints === 1) {
        currentScore2 = 0;
        turn2 = false;
        turn1 = true;
    } else {
        currentScore2 += addPoints;
    }
    updateUI();
}


function saveScorePlayer1() {
    if (!turn1) {
        showMessage(`❌ It's not your turn! Wait for ${getPlayerName(2)}.`);
        return;
    }
    if (currentScore1 === 0) {
        return;
    }

    savedScorePlayer1 += currentScore1;
    currentScore1 = 0;
    turn1 = false;
    turn2 = true;
    updateUI();
}


function saveScorePlayer2() {
    if (!turn2) {
        showMessage(`❌ It's not your turn! Wait for ${getPlayerName(1)}.`);
        return;
    }
    if (currentScore2 === 0) {
        return;
    }

    savedScorePlayer2 += currentScore2;
    currentScore2 = 0;
    turn2 = false;
    turn1 = true;
    updateUI();
}


function newGame() {
    currentScore1 = 0;
    currentScore2 = 0;
    savedScorePlayer1 = 0;
    savedScorePlayer2 = 0;
    turn1 = true;
    turn2 = false;

    document.getElementById("winnerMessage").textContent = "";

    document.querySelectorAll("button").forEach(button => button.disabled = false);

    showMessage("🔄 New Game Started!");
    updateUI();
}

// Initialize UI
updateUI();



// this creats dice itself in the form of a div called dice and returns dice
function createDice(number){
  // this matrix contain each dice face's dot co-ordinates(top, left)
  const dotPositionMatrix = {
      1: [
          [50, 50]
      ],
      2: [
          [20, 20],
          [80, 80]
      ],
      3: [
          [20, 20],
          [50, 50],
          [80, 80]
      ],
      4: [
          [20, 20],
          [20, 80],
          [80, 20],
          [80, 80]
      ],
      5: [
          [20, 20],
          [20, 80],
          [50, 50],
          [80, 20],
          [80, 80]
      ],
      6: [
          [20, 20],
          [20, 80],
          [50, 20],
          [50, 80],
          [80, 20],
          [80, 80]
      ]
  };

  // creats a div 
  const dice = document.createElement("div");

  // adds class to the div
  dice.classList.add('dice');

  // generates dots for each face 
  for(const dotPosition of dotPositionMatrix[number]){
      const dot = document.createElement('div');

      dot.classList.add('dice-dot');
      dot.style.setProperty("--top", dotPosition[0] +'%');
      dot.style.setProperty("--left", dotPosition[1] + '%');

      dice.appendChild(dot);
  }
  // returns the generated dic face
  return dice;
}

// this appends dice div to dice-container div (which is initially empty)
const diceContainer = document.querySelector('.dice-container');
// this initialises the dice with 5 number 
diceContainer.appendChild(createDice(5));


function changeColorOnTurn(){
     const playerCard1 = document.getElementById("player1");
     const playerCard2 = document.getElementById("player2");
     if(turn1){
      playerCard1.classList.add("active1");
      playerCard2.classList.remove("active2");
     }
     else{
      playerCard1.classList.remove("active1");
      playerCard2.classList.add("active2");
     }

}
changeColorOnTurn();