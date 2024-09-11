const http=require("http");
var server=http.createServer(function(req,resp){
    console.log("recieved request : "+req.url);
    resp.writeHeader(200,{"content-type":"text/html"})
    if(req.url=="/home" && req.method=="GET"){
       resp.write("<h1>Home page</h1>");
       resp.end("<h1>this is end</h1>");
    }else{
        resp.write("<h1>about us page</h1>");
        resp.end("<h1>this is end of aboutus</h1>")
    }

});

server.listen(9090,function(){
    console.log("server started on port 9090");
})