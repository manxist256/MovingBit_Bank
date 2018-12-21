/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xmlhttp = new XMLHttpRequest();
function getBalance() {
    if (xmlhttp.readyState === 0 || xmlhttp.readyState === 4) {
        xmlhttp.open("GET", "ViewBalance", true);
        xmlhttp.send(null);
        
        xmlhttp.onreadystatechange = updateBalance;
    } else {
        setTimeout(getBalance, 1000);
    }
}
function updateBalance() {
    if (xmlhttp.readyState === 4) {
        document.getElementById("balance_show_section").innerHTML = xmlhttp.responseText;
    }
}
setTimeout(getBalance);

