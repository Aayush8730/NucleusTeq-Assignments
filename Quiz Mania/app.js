let mainDiv = document.querySelector(".main-container");
let aboutDiv = document.querySelector(".about");
let quizDiv = document.querySelector(".quiz-box");
let winnerDiv = document.querySelector("winner-container");
let selectedCategory = "";
let selectedDifficulty = "";
let data = {};
let currentQuestionNumber  = 0 ;
let interval; 
let score  = 0 ; 
let correctOptionId = 0;
let correctOption = "";

// let new0ptionsArray = [];

function displayAbout() {
  mainDiv.style.display = "none";
  aboutDiv.style.display = "block";
  quizDiv.style.display = "none";
}

function backToHome() {
  mainDiv.style.display = "flex";
  aboutDiv.style.display = "none"; 
  quizDiv.style.display = "none";
}

async function startGame() {
  // check whether the category and difficulty is selected or not 
  if(selectedCategory == "" || selectedDifficulty == ""){
     alert("Please select both Category and Difficulty");
  }
  else{
  mainDiv.style.display = "none";
  quizDiv.style.display = "block";

  data  = await getData(); // since it is a asynchronous call
  createNewOptionsArray();
  let startCountDown = 3;
  // disable the buttons here and think when to enable the buttons again
  disableOptions();
  document.querySelector(".about-button").style.pointerEvents = "none"; // Disable About button
  document.querySelector(".next").style.pointerEvents = "none"; // Disable Next button
  document.querySelector(".logo").style.pointerEvents = "none"; // Disable Logo div

  // Reduce opacity to indicate disabled state
  document.querySelector(".about-button").style.opacity = "0.5";
  document.querySelector(".next").style.opacity = "0.5";
  document.querySelector(".logo").style.opacity = "0.5";

  showMessage(`Your game starts in ${startCountDown} seconds`, startCountDown);
  }
}

// fetching the data here 
async function getData() {
  try {
    let response = await fetch(`https://opentdb.com/api.php?amount=10&category=${selectedCategory}&difficulty=${selectedDifficulty}&type=multiple`);
    
    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    data = await response.json();
    console.log(data);
    return data;
  } catch (error) {
    console.error("Error fetching data:", error);
    //refresh lagana hai 
  }
}

// adding the event listeners on the select category and difficulty level

document.getElementById("category-types").addEventListener("change", function (e) {
  selectedCategory = e.target.value;
  console.log("Category changed to:", selectedCategory);
});

document.getElementById("difficulty-types").addEventListener("change",function(e){
  selectedDifficulty = e.target.value;
  console.log("Category changed to:", selectedDifficulty);

})

// pop up messages to show 
function showMessage(message, startCountDown) {
  const messageBox = document.querySelector(".messageBox");
  messageBox.textContent = message;
  messageBox.style.display = "block"; 

  let count = startCountDown;
  
  let interval = setInterval(() => {
    count--;
    if (count > 0) {
      messageBox.textContent = `Your game starts in ${count} seconds`;
    }
    else if(count==0){
      messageBox.textContent = `lets Go!!`;
      enableOptions();
      displayQuestion(data , currentQuestionNumber);
      startTimer();
    }
     else {
      messageBox.style.display = "none"; 
      clearInterval(interval); 
    }
  }, 1000);
}


// function to display questions after every 15 seconds 
function displayQuestion(data,currentQuestionNumber) {
  let que = data.results[currentQuestionNumber].question;
  console.log("Question:", que);
  let queDiv = document.querySelector("#question");
   queDiv.textContent = `${que}`;
  displayOptions(currentQuestionNumber);
}

function startTimer() {
  let i = 15; // Start from 15 to display 15 first
  let timer = document.querySelector("#timer");
  if(i==15){
     timer.textContent = `${i}`;
    //  console.log(i);
     i--;
  }
  interval = setInterval(() => {
    timer.textContent = `${i}`;
    // console.log(i);
    
    if (i === 0) { 
      document.querySelector(".next").style.pointerEvents = "auto";
      document.querySelector(".next").style.opacity = "1";
      clearInterval(interval); // Stop when countdown reaches 0
      correctOption = data.results[currentQuestionNumber].incorrect_answers[correctOptionId];
      document.getElementById(correctOptionId).textContent = `${correctOption}      ✅`;
    }
    i--; // Decrement after checking to prevent displaying -1
  }, 1000);
}
// stop the timer 
function stopTimer(){
    clearInterval(interval);
}


// create a new options array where the correct answwer is in the random position

let wholeOptionsArray = []; // new option array for all the questions options 

  function createNewOptionsArray(){
    for(let i  = 0 ; i<10 ; i++){
     let new0ptionsArray = data.results[i].incorrect_answers;
     console.log(new0ptionsArray ,"incorrect"); // incorrect 
     let randomIndex  = Math.floor(Math.random()*(new0ptionsArray.length + 1));
     new0ptionsArray.splice(randomIndex , 0 ,data.results[i].correct_answer);
     console.log(new0ptionsArray , "incorrect + correct"); // incorrect + correct 
     wholeOptionsArray.push(new0ptionsArray);
    }
    console.log(wholeOptionsArray);
  }


  document.querySelectorAll(".option").forEach(option => {
    option.addEventListener("click", (event) => {
      let selectedOption = event.target.textContent; // Get the clicked option's text
      let selectedOptionID = event.target.id;
      // console.log(selectedOptionID);
      console.log("You selected:", selectedOption);
      checkAnswer(selectedOption,selectedOptionID);
      document.querySelector(".next").style.pointerEvents = "auto"; 
      document.querySelector(".next").style.opacity = "1";
    });
  });

   //check the Answer
   function checkAnswer(selectedOption, selectedOptionID){
    let correctAnswer = data.results[currentQuestionNumber].correct_answer;
    
    if(selectedOption === correctAnswer){
       console.log("Correct answer");
       document.getElementById(selectedOptionID).textContent = `${selectedOption} ✅`;
       document.getElementById(selectedOptionID).classList.add("correct-option");
       score++;
       updateScore();
    } else {
       console.log("Wrong answer");
       document.getElementById(selectedOptionID).textContent = `${selectedOption} ❌`;
       document.getElementById(selectedOptionID).classList.add("wrong-option");

       let correctIndex = wholeOptionsArray[currentQuestionNumber].indexOf(correctAnswer);
       document.getElementById(correctIndex).textContent = `${correctAnswer} ✅`;
       document.getElementById(correctIndex).classList.add("correct-option");
    }
    
    stopTimer();
    disableOptions();
}

  
  function displayOptions(currentQuestionNumber){
      let options  = wholeOptionsArray[currentQuestionNumber];
      let i = 0;
      document.querySelectorAll(".option").forEach((element)=>{
          element.innerText = `${options[i]}`;
          i++;
      })
  }
  // as soon as i clicked any option stop the timer and display the correct answer
  function nextQuestion() {
    if (currentQuestionNumber < data.results.length - 1) {
        currentQuestionNumber++;
        displayQuestion(data, currentQuestionNumber);
        startTimer();
        enableOptions();
        displayOptions(currentQuestionNumber);

        document.querySelector(".next").style.pointerEvents = "none";
        document.querySelector(".next").style.opacity = "0.5";
    } else {
        console.log("Quiz Over!");

        // Hide the quiz and show the winner page
        quizDiv.style.display = "none";
        document.getElementById("winnerSection").style.display = "block";
        // Update the score on the winners page
        document.querySelector(".winner-score").textContent = score;
        document.querySelector(".logo").style.pointerEvents = "auto"
        document.querySelector(".about-button").style.pointerEvents = "auto"
        document.querySelector(".logo").style.opacity = "1";
        document.querySelector(".about-button").style.opacity = "1";

    }
}




  function updateScore(){
      document.querySelector(".score-value").textContent = score;
  }
  function disableOptions(){
    document.querySelectorAll(".option").forEach(option => {
      option.style.pointerEvents = "none";
    });
  }

  function enableOptions(){
    document.querySelectorAll(".option").forEach(option => {
      option.style.pointerEvents = "auto";
    });
  }

console.log(currentQuestionNumber);





