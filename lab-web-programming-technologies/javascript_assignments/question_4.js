var first = parseInt(prompt("Enter first number"))
var second = parseInt(prompt("Enter second number"))
var operator = prompt("Enter a valid operator (+,-,*,/)")

function doOperation(first, second, operator) {
    if (operator == "+") {
        return first + second;
    } else if (operator == "-") {
        return first - second;
    } else if (operator == "*") {
        return first * second;
    } else if (operator == "/") {
        return first / second;
    } else {
        return "Enter a valid value";
    }
}

alert(doOperation(first, second, operator))