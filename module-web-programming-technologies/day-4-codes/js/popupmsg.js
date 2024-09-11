 //all these functions are of window object
        //to display the popup box with ok button
        alert("this is alert window");
        //to display the popup box with ok  and cancel button, if you click ok it returns true, otherwise if you click cancel, it returns false
        var ans=confirm("to select ok or cancel");
        if(ans){
             document.write("<h3>you selected ok</h3>");
 
        }else{
         document.write("<h3>you selected Cancel</h3>");
        }
        //to display popup box with message and a text box
        //evry value is treated as string
        var name=prompt("Pls eneter name");
        var sal=prompt("pls enetr salary");
        document.write("name: "+name+"sal : "+sal);