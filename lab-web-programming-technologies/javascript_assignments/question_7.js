var count = parseInt(prompt("Enter the count of numbers"))

var min = undefined
for (var i = 0; i < count; i++) {
    var num = prompt("Enter " + (i + 1) + " number");
    if (min == undefined) {
        min = num
    } 
    if (num < min) {
        min = num
    }
}

alert("Minimum : " + min)