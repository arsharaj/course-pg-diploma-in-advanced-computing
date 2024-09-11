const http=require('http');
var server=http.createServer(function(req,resp){
    console.log("received request"+req.url+" Method: "+req.method);
    resp.writeHeader(200,{"content-type":"text/html"});
    resp.write("<h1>Hello World!!</h1>");
    resp.write("<h3>Welcome to nodejs serverside programming</h3>");
    resp.end("<h4>this is the end event</h4>");

})
server.listen(9090,function(){
    console.log("server running at port 9090")
})