const express=require("express");
const app=express();
const bodyparser=require("body-parser");
const bodyParser = require("body-parser");
const m1=require("./module1");
//this is middleware which helps to parse the url and separate data from the url
//it will generate a object by name query in req object if method is get
//it will generate object by name body in req object if the method is post
app.use(bodyParser.urlencoded({extended:false}));

app.get("/login",function(req,resp){
    resp.sendFile("/public/login.html",{root:__dirname})
});
app.post("/validate",function(req,resp){
    var u=m1.validateuser(req.body.uname,req.body.pass);
    if(u===null){
        resp.send("<h1>invalid user</h1>");
    }else{
        resp.sendFile("/public/form.html",{root:__dirname});
    }
   // resp.send("uname: "+req.body.uname+ " Password: "+req.body.pass)

});

app.get("/calculate",function(req,resp){
    var num1=parseInt(req.query.num1);
    var btn=req.query.btn;
    if(btn==="add"){
        var num2=parseInt(req.query.num2);
        var ans=m1.addition(num1,num2);
        resp.send("<h1>Addition : "+ans+"</h1>" )
    }else{
        var ans=m1.factorial(num1);
        resp.send("<h1>Factorial : "+ans+"</h1>" )
    }    

})

app.listen(9090,function(req,resp){
    console.log("server started at prot 9090");

})

