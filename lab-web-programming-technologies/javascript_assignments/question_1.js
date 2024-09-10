var first = parseInt(prompt("Enter first number"));
var second = parseInt(prompt("Enter second number"));
var third = parseInt(prompt("Enter third number"))

var largest = first;

if (second > largest) {
    largest = second;
}

if (third > largest) {
    largest = third;
}

alert(largest + " is the largest.");