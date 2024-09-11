exports.combination=function(n,r){
    return factorial(n)/factorial(n-r)
}
exports.user={uid:12,uname:'xxx'};
function factorial(n){
    var f=1;
    for(var i=1;i<=n;i++){
        f=f*i;
    }
    return f;
}