/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var img1 = "source_images/img1.png";
var img2 = "source_images/img2.jpg";
var img3 = "source_images/img3.jpeg";
var flag = 0;
function loopImages() {
    var element = document.getElementById("homepgimg");
    if (flag === 0) {
        element.src = img2;
        flag = 1;
    } else if (flag === 1) {
        element.src = img3;
        flag = 2;
    } else if (flag === 2) {
        element.src = img1;
        flag = 0;
    }
}
var t = 0;
function callTimer() {
    document.getElementById("timer").innerHTML = t++;
}
function changeDate() {
    document.getElementById("date").innerHTML = Date();
}
var loopimages = setInterval(loopImages, 2000);
var changedate = setInterval(changeDate, 1000);
var timer = setInterval(callTimer, 1000);
$(document).ready(function() {
   $("#homepgimg").click(function() {
      clearInterval(loopimages); 
   });
   $("#timer").click(function() {
      $(this).slideUp(3000);
   });
});
var xmlhttp = new XMLHttpRequest();
function validatemobileNumber() {
    if (xmlhttp.readyState === 0 || xmlhttp.readyState === 4) {
        var data = document.getElementById("phone_number").value;
        if (data === "") {
            document.getElementById("mobilenumbervalidation").innerHTML = "";
            return;
        }
        xmlhttp.open("GET", "ValidateMobile?mobile=" + data, true); //readystate = 1;
        xmlhttp.send(null); //readystate = 2;
        xmlhttp.onreadystatechange = updateValidatedMessage;
    }
}    

function updateValidatedMessage() {
    if (xmlhttp.readyState === 4) {
        var response = xmlhttp.responseText;
        if (response == "true") {
            document.getElementById("mobilenumbervalidation").innerHTML =  "mobile no. already registed with some other account";
            $("#mobilenumbervalidation").addClass("redText");
            $("#mobilenumbervalidation").removeClass("whiteText");
        } else if (response == "false") {
            document.getElementById("mobilenumbervalidation").innerHTML = "good to go!";
            $("#mobilenumbervalidation").addClass("whiteText");
            $("#mobilenumbervalidation").addClass("redText");
        }
        setTimeout(validatemobileNumber, 1000); 
    } 
}


