var p = parseInt(prompt("Enter principle amount"))
var r = parseInt(prompt("Enter rate"))
var t = parseInt(prompt("Enter time"))
var ci = ((p + Math.pow(1 + (r / 100), t)) - p).toPrecision(2)
document.write("****************************<br>")
document.write("****** Compond Interest ******<br>")
document.write("****************************<br>")
document.write("Principal           -    " + p + " Rs<br>");
document.write("Rate of Interest    -    " + r + "%<br>");
document.write("Period              -    " + t + " yr<br>");
document.write("Compound Interest   -    " + ci);