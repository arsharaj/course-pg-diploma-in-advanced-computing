arr1=new Array(12,13,14,"hdfsdjh",100,200,300);
arr2=[1,2,32,'dddd']
arr3=[10,23,12,arr1,34,5,6,]
arr4=[10,23,11,...arr1]  //spread operator will create a new copy of values
console.log("length of arr3",arr3.length,arr3);  // 4
console.log("length of arr3",arr4.length,arr4);  // 7

//to add a new value in the array
arr1.push(100);
arr1.unshift(1000);
console.log(arr1,arr3)

//to remove a new value in the array
arr1.pop();
arr1.shift();
console.log(arr1,arr3)
//delete the value at 3 rd position
arr1.splice(3,1)
console.log("delete from 3 rd position",arr1)
//insert the value at 3 rd position
arr1.splice(3,0,11,22,33,44)
console.log("insert at 3 rd position",arr1)
//replace the value from 3 rd position onward
arr1.splice(3,2,11,22,33,44);
console.log("insert at 3 rd position",arr1)