const express=require("express");
var router=express.Router();
var connection=require("../db/dbconnect")
router.get("/products",function(req,resp){
   connection.query("select * from product",(err,data,fields)=>{
   if(err){
    console.log(err);
    resp.status(500).send("<h3>no data found</h3>")
   }else{
    console.log(data);
    //this will generate ./views/index.ejs
    resp.render("index",{proddata:data});
   }
   })

});
router.get("/displayaddform",function(req,resp){
    resp.render("add-prod")

})
router.post("/addproduct",function(req,resp){
    connection.query("insert into product values(?,?,?,?)",[req.body.pid,req.body.pname,req.body.qty,req.body.price],(err,result)=>{
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            console.log(result);
            resp.redirect("/products");
           }
    })
});
router.get("/delete/:pnum",function(req,resp){
    connection.query("delete from product where pid=?",[req.params.pnum],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            console.log(result);
            resp.redirect("/products");
           }

    })

});
router.get("/edit/:pnum",function(req,resp){
    connection.query("select * from product where pid=?",[req.params.pnum],function(err,data){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            
            console.log(data);
            resp.render("edit-prod",{prod:data[0]})
           }
    })

})
router.post("/updateproduct",function(req,resp){
    connection.query("update product set pname=?,qty=?,price=? where pid=?",[req.body.pname,req.body.qty,req.body.price,req.body.pid],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data updated</h3>")
           }else{
            console.log(result);
            resp.redirect("/products");
           }

    })

})

//this is same object rotes in app.js
module.exports=router;