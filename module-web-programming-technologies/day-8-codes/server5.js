const http=require('http');
const fs=require("fs");
const url=require("url");
const m1=require("./module1");
var server=http.createServer(function(req,resp){
    resp.writeHeader(200,{"content-type":"text/html"});
    //it will separate the url and data and generate a object and store in variable q
    //q={pathname:"/submit_data",query:{num1:23,num2:300}}
    var q=url.parse(req.url,true)
    console.log(q);
    switch(q.pathname){
        case "/form":
            //read data from file and display it in the browser
             var rs=fs.createReadStream("./public/form1.html");
             rs.pipe(resp);
             //rs.on("error",function(){})
            break;
            //  /submit_data?num1=23&num2=300
        case "/submit_data":
              resp.write("you enetered num1 : "+q.query.num1+"<br>");
              
              if(q.query.btn=="add"){
                resp.write("you enetered num1 : "+q.query.num2+"<br>" );
                var ans=m1.addition(parseInt(q.query.num1),parseInt(q.query.num2));
                resp.end("Addition : "+ans);
              }
             
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