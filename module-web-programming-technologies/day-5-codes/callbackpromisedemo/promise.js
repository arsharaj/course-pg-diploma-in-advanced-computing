var blogs=[{name:'blog1',content:'blog1 content'},
   {name:'blog2',content:'blog2 content'},
   {name:'blog3',content:'blog3 content'}
]

var getblogs=()=>{
    setTimeout(()=>{
        console.log("getblogs called")
        var str="<ul>"
        for(var ob of blogs){
            str+=`<li>${ob.name}-----${ob.content}</li>`
        }
        str+="</ul>"
        document.getElementById("mydiv").innerHTML=str;
        
    },1000);
    
}
var createblogs=(newblog,f)=>{
     return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            console.log("createblogs called")
            blogs.push(newblog);
            error=false;
            console.log(blogs);
            if(!error){
                resolve();
            }else{
                 reject("error occured");
            }
            
            
        },2000);
     });
}

async function greet(){
    return "hello";
}
var ans=greet();
console.log(ans);
ans.then((data)=>{
    console.log("print the hello",data);
})
console.log("before createblog")
createblogs({name:'blog4',content:'blog4 content' })
.then(getblogs)
.catch((error)=>{console.log(error);})
console.log("after createblog")