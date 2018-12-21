/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var xmlhttp = new XMLHttpRequest();
function getname() {
    if (xmlhttp.readyState === 0 || xmlhttp.readyState === 4) {
        xmlhttp.open("GET", "GetName", true);
        xmlhttp.send(null);
        
        xmlhttp.onreadystatechange = updateName;
    } else {
        setTimeout(getname, 1000);
    }
}
function updateName() {
    if (xmlhttp.readyState === 4) {
        document.getElementById("account_holder").innerHTML = xmlhttp.responseText + ",";
        $("#account_holder").addClass("name_added");
    }
}
setTimeout(getname);

