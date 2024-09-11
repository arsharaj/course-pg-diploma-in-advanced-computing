arr1=[1,2,12,15,23,4,20,45,35,12,14]
//find position of first occurence of the given value
pos=arr1.indexOf(12);
console.log("pasition : ",pos)
//find position of first occurence based on condition
pos=arr1.findIndex((val,index,arr)=>val>5);
console.log("pasition : ",pos)  //2
//find values of first occurence based on condition
x=arr1.find((val,index,arr)=>val>5);
console.log("Values : ",x)  //12
//find all values which satisfies the condition on condition
newarr=arr1.filter((val,index,arr)=>val>5);
console.log("array : ",newarr)  //12,15,23,....
//to convert all values into different value based on given expression
newarr=arr1.map((val,index,arr)=>val*val+index);
console.log("array : ",newarr)  //
//to convert all values into asingle value 
addition=arr1.reduce((acc,val)=>acc+val);
console.log("reduce : ",addition)  //
addition=arr1.reduce((acc,val)=>acc+val,100);
console.log("reduce : ",addition) 
minval=arr1.reduce((acc,val)=>acc<val?acc:val);
console.log("reduce : ",addition)
strarr=["python","Perl","linux","os"]
//concatenate first 3 characters of every string
//pytPerlinos                 
str=strarr.reduce((acc,val)=>acc+val.slice(0,3),"")
console.log("string concatenate",str)

arr1=[1,2,100,23,1000,8,500,800]
console.log(arr1.sort())  ///asccii sort
function compare(a,b){
  /* if(a<b)
      return -1
    else if (a===b)
        return 0;
    else 
       return 1;*/
    return a-b
}
//to do numeric sort in descending order
console.log(arr1.sort(compare))
//to do numeric sort in ascending order
console.log(arr1.sort((a,b)=>a-b))
//to do numeric sort in descending order
console.log(arr1.sort((a,b)=>b-a))
strarr=["python","perl","linux","os","program"]
console.log(strarr.filter(val=>val.includes('p')))
//true if perl exists in the arrat
console.log(strarr.includes("perl"))