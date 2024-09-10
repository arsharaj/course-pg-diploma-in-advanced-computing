var today = new Date();

function getGreeting(time) {
    if (time <= 12) {
        return "Welcome, and Good Morning to You.";
    } else if (time <= 16) {
        return "Welcome, and Good Afternoon to You.";
    } else if (time <= 20) {
        return "Welcome, and Good Evening to You.";
    } else {
        return "Welcome, and Good Night to You.";
    }
}

function getDay(day) {
    switch (day) {
        case 1:
            return "Monday";
        case 2:
            return "Tuesday";
        case 3:
            return "Wednesday";
        case 4:
            return "Thursday";
        case 5:
            return "Friday";
        case 6:
            return "Saturday";
        case 7:
            return "Sunday";
    }
}

var day = getDay(today.getDay());
var fullDate = today.getDate() + "/" + today.getMonth() + "/" + today.getFullYear();
var greeting = getGreeting(today.getHours())

document.write("Today is " + day + ", " + fullDate + ", " + greeting)