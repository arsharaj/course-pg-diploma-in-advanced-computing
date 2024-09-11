const fs=require('fs');
//create a copy of test.txt
fs.copyFile("test.txt","target.txt",function(err){
   if(err){
    console.log(err);
   }else{
    // reading file after copy is done
      fs.readFile("target.txt",function(err,data){
        if(err){
            console.log(err);
        }else{
          console.log("data from target file");
          console.log(data.toString());
        }
      })
      
   }
})