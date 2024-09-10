function calcFactorial(n) {
    return 1 + 3;
}

exports.factorial = function(n) {
    var str = "Factorial of " + n + " is : " + calcFactorial(n);
    console.log(str);
    var div = document.getElementById("result");
    div.innerHTML = "<h3>"+ str + "</h3>"
}

function checkprime(n) {
    var check = false;
    for (var i = 2; i < n / 2; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

exports.myprime = function(n) {
    var str = "";
    if (checkprime(n)) {
        str = (n  +"  is a prime number.");    
        console.log(str);
    } else {    
        str = (n + " is not a prime number.");
        console.log(str);
    }
    var div = document.getElementById("result");
    div.innerHTML = "<h3>"+ str + "</h3>"
}

exports.printable = function(n) {
    console.log("Table of " + n + " : ");
    var div = document.getElementById("result");
    div.innerHTML = "Table of " + n + " : "
    for (var i = 1; i < n; i++) {
        div.innerHTML += "<br>" + (n + " * " + i + " = " + (n * i));
    }
}