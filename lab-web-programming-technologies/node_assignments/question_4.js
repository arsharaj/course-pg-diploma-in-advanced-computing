var http = require("http")

function printNum() {
    var str = "";
    for (var i = 1; i < 100; i++) {
        if (i % 3 == 0 && i % 5 == 0) {
            str += "<br> Number " + i + " : " + "FizzBuzz";
        } else if (i % 3 == 0) {
            str += "<br> Number " + i + " : " + "Fizz";
        } else if (i % 5 == 0) {
            str += "<br> Number " + i + " : " + "Buzz";
        } else {
            str += "<br> Number " + i + " : ";
        }
    }
    return str;
}

var server = http.createServer((req, res) => {
    res.writeHeader(200, {"content-type":"text/html"});
    res.end(printNum());
});

server.listen(9090, function() {
    console.log("listening to port 9090");
})