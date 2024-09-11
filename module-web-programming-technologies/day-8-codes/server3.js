const http=require('http');
var server=http.createServer(function(req,resp){
    resp.writeHeader(200,{"content-type":"text/html"});
    switch(req.url){
        case "/home":
            resp.write("<h1>in home page</h1>");
            resp.end("<h3>How can I help you?</h3>");
            break;
        case "/aboutus":
            resp.write("<h1>in aboutus page</h1>");
            resp.end("<h3>Pls read consitions carefully</h3>");
            break;
        default:
            resp.write("<h1>in default page</h1>");
            resp.end("<h3>use /home to goto home page</h3>")
            break;
           
    }
});
server.listen(9090,function(){
    console.log("listening on port 9090");
})