const express=require("express");
var router=express.Router();
var connection=require("../db/dbconnect");

//retrieve all products and return in json format
router.get("/products",function(req,resp){
   connection.query("select * from product",(err,data,fields)=>{
   if(err){
    console.log(err);
    resp.status(500).send("no data found")
   }else{
    console.log(data);
    resp.send(data);
   }
   })

});

//add new product received via request body and add it in the database
router.post("/products/product/:pnum",function(req,resp){
    connection.query("insert into product values(?,?,?,?)",[req.body.pid,req.body.pname,req.body.qty,req.body.price],(err,result)=>{
        if(err){
            console.log(err);
            resp.status(500).send("no data found")
           }else{
            console.log(result);
           resp.status(200).send("data added successfully")
           }
    })
});

//delete product from the database, whose id is received via params in pnum
router.delete("/products/product/:pnum",function(req,resp){
    connection.query("delete from product where pid=?",[req.params.pnum],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("no data found")
           }else{
            console.log(result);
            resp.status(200).send("data deleted successfully")
           }

    })

});
//retrieve details of one product with id received via params pnum 
router.get("/products/product/:pnum",function(req,resp){
    connection.query("select * from product where pid=?",[req.params.pnum],function(err,data){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data found</h3>")
           }else{
            
            console.log(data);
            resp.status(200).send(data[0])
           }
    })

})
//update product received via request body and update it in the database
router.put("/products/product/:pnum",function(req,resp){
    connection.query("update product set pname=?,qty=?,price=? where pid=?",[req.body.pname,req.body.qty,req.body.price,req.body.pid],function(err,result){
        if(err){
            console.log(err);
            resp.status(500).send("<h3>no data updated</h3>")
           }else{
            console.log(result);
            resp.status(200).send("data updated successfully")
           }

    })

})

//this is same object rotes in app.js
module.exports=router;