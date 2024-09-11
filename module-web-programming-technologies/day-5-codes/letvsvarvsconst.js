//var duplicate declaration is possible, 
//let duplicate declaration is not possibe

var x=23;
var x="xxxx";

let y=34;
//let y=50;   ///error because of redeclaration

//var is global or function scope
//let is blocked scope

var d=34;   //global

let z=45;   //global

for(var i=23;i<30;i++){
    y++;
}

console.log("after the loop:",i);
//j is accessible only inside the for loop
for(let j=23;j<30;j++){
    y++;
}

//console.log("after the loop let:",j);  //error

function f1(){
    var g=34;
    let f=50;
    if(g>30){
        var x='aaa';
        let v=300;
    }
    console.log("using var",g,x)
    //console.log("using let",f,v)  //error for v
    console.log("using let",f);
}

f1();   //calling function f1

//varible hoisting is possible in var 
//hoisting is not possible in let

console.log("variable without declaration",p);
var p=23;


//console.log("variable without declaration",q);
let q=25;

const c=34;
//c=45;  //change in the value of constant is not allowed


function f2(){

}
//ECHMA5
const f3=function(){

}
f3();
//f3=100;

//ECHMA6
const f4=()=>{

}

f4()