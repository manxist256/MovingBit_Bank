/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xmlhttp = new XMLHttpRequest();
function deposit() {
    if (xmlhttp.readyState === 0 || xmlhttp.readyState === 4) {
        var amt = document.getElementById("deposit_amt").value;
        xmlhttp.open("GET", "Deposit?amount=" + amt,  true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = updateMessage;
    } else {
        setTimeout(deposit, 1000);
    }
}
function updateMessage() {
    if (xmlhttp.readyState === 4) {
        document.getElementById("deposit_result").innerHTML = xmlhttp.responseText;
    }
}
