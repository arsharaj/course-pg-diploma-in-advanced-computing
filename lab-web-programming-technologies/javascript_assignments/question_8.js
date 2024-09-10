var num = parseInt(prompt("Enter a number"))
var pow = parseInt(prompt("Enter a power"))

function power(num, pow) {
    if (pow === 1) {
        return num
    }
    return num * power(num, pow - 1)
}

alert("Result = "  + power(num, pow))