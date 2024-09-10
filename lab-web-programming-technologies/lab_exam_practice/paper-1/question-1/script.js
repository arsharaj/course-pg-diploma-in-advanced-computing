let firstNum = document.getElementById("firstNum")
let secondNum = document.getElementById("secondNum")
let result = document.getElementById("result")
let multiply = document.getElementById("multiply")
let divide = document.getElementById("divide")

multiply.addEventListener("click", () => {
    result.value = firstNum.value * secondNum.value
})

divide.addEventListener("click", () => {
    if (secondNum.value == 0) {
        result.value = "Not Possible"
    } else {
        result.value = (firstNum.value / secondNum.value).toFixed(2)
    }
})