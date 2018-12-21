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
        


