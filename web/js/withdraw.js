/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xmlhttp = new XMLHttpRequest();
function withdraw() {
    if (xmlhttp.readyState === 0 || xmlhttp.readyState === 4) {
        var amt = document.getElementById("withdraw_amt").value;
        xmlhttp.open("GET", "Withdraw?amount=" + amt,  true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = updateMessage;
    } else {
        setTimeout(withdraw, 1000);
    }
}
function updateMessage() {
    if (xmlhttp.readyState === 4) {
        document.getElementById("withdraw_result").innerHTML = xmlhttp.responseText;
    }
}
