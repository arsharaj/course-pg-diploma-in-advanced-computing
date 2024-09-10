var http = require("http");
var url = require("url");
var myMod = require("./mymodule")

var server = http.createServer(function (req, resp) {
    var q = url.parse(req.url, true);
    if (q.pathname == "/result") {
        var n = q.query.num;
        console.log("Num " + n);
        var result = myMod.factorial(n)

        resp.writeHeader(200, { "content-type": "text/html" })
        resp.write("<h1>Result</h1>");
        resp.write(result);
        resp.end("<h1>this is end</h1>");

    }

});

server.listen(9090, function () {
    console.log("server started on port 9090");
})