function f1(){
    console.log("in function f1");
    console.log(arguments)
}
f1();
f1(12,13,14)
f1(1,2,'c','f')

function f2(x,y,...p){
    //var s=x+y;
    console.log(x,y,arguments);
    var s=0;
    for(var num in arguments){
        s=s+num;
    }
}

f2(1,2,3,4,5,6,7,8)

//arguments array is not available with => functions
//... are called as rest operator
const f5=(x,y,...z)=>{
   console.log("in f5");
   console.log(x,y,z);
}
f5();
f5(1,2);
f5(1,2,2,3,4,5,6);

//self calling function
//gets executed only once
(function(){
    console.log("in function f5")
})()


(function(x,y){
    console.log("in f6",x,y)
})(12,13)


//closure functions
//if there is a function which has access to its parent function scope
//then it is called as closure functions


function combination(n,r){
    var d=45;
    //closure function, because it has accees to its parent scope
    function factorial(n){
        var f=1;
        for(var i=1;i<=n;i++){
            f=f*i;
        }
        return f;
    }
    nf=factorial(n);
    nrf=factorial(n-r);
    var ans=nf/nrf;
    return ans;
}
