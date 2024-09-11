const mysql=require("mysql");
var mysqlconnection=mysql.createConnection({
    host:'127.0.0.1',
    user:'root',
    password:'root123',
    port:3306,
    database:'test'
    /*multipleSatetments:true*/

})
mysqlconnection.connect((err)=>{
    if(err){
        console.log("error occured",err);

    }else{
        console.log("connection done")
    }

})

module.exports=mysqlconnection;