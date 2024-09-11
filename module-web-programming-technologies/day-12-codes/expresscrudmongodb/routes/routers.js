var express=require("express");
var mongoose=require("mongoose");
var schema=mongoose.Schema;
var router=express.Router();

//design model using mongoose schema
var empschema=new schema({
   // _id:Number,
    empid:String,
    ename:{type:String,trim:true,required:true},
    sal:String
//sal:{type:Number,validate:/[0-9]*/}
})

//retireve data from emptab collection and 
//its scema is defined using empschema
//model(name,scema object, collection name)
//collection name is optional if model name and collection name is same
var Emp=mongoose.model('emptab',empschema,'emptabs')


//to retrieve all records from mongodb and display 
//it in browser in table format
router.get("/employee",function(req,resp){
     Emp.find().exec(function(err,data){
         if(err){
             resp.status(500).send("no data found");
         }
         else{
             console.log(data);
            // response.render("index",{empdata:data})
             // return data in json format
             resp.send(data);
         }

     });

});

//read one employee object
router.get("/employee/:empid",function(req,resp){
    Emp.find({empid:req.params.empid}).exec(function(err,data){
        if(err){
            resp.status(500).send("no data found");
        }
        else{
            console.log(data);
           // response.render("index",{empdata:data})
            // return data in json format
            resp.send(data);
        }

    });

});



//this add new document in the collection
router.post("/employee",function(req,resp){
    var emp=new Emp({
        //_id:req.body._id,
        empid:req.body.empid,ename:req.body.ename,sal:req.body.sal})
    emp.save(function(err,data){
        if(err){
            //if error comes while saving the data
            resp.status(500).send({message:"no data added"});
        }
        else{
        //if success then same object will be returned as response
        resp.send(data);
        }
    });
});


//update the document retrived with id and modify it in the database
router.put("/employee/:empid",function(req,resp){
    console.log(req.body);
    Emp.findOne({empid:req.body.empid},function(err,doc){
        if(err){
            resp.status(500).send("no data updated");
        }
        else{
            console.log("in else")
            doc.empid=req.body.empid;
            doc.ename=req.body.ename;
            doc.sal=req.body.sal;
            doc.save(function(err,data){
                if(err){
                    resp.status(500).send({message:"no data updated"});
                }
                resp.send(data);
            })
        }
       
    })
});

//delete the document with given id and go back to the table
router.delete("/employee/:empid",function(req,resp){
    Emp.remove({empid:req.params.empid},function(err,doc){
        if(err){
            resp.status(500).send({message:"no data found"});
        }
        resp.status(200).send({message:"data deleted successfully"});
    });
});

module.exports=router;


