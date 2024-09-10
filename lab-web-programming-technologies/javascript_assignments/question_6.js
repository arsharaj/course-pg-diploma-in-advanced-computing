var num = prompt("Enter a number")

var sum = 0
for (var i = 0; i < num.length; i++) {
    sum += parseInt(num.charAt(i))
}

alert("Sum = " + sum);