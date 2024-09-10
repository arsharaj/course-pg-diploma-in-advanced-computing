var rec = require("./rectangle")
var cir = require("./circle")
var tri = require("./triangle")

console.log("Rectangle Area: "  + rec.calcArea(12, 123));
console.log("Rectangle Perimeter: "  + rec.calcPerimeter(123, 123));
console.log("Circle Area: "  + cir.calcArea(2));
console.log("Circle Perimeter: " + cir.calcPerimeter(3));
console.log(("Circle Diameter: " + cir.calcDiameter(33)));
console.log("Triangle Equilateral check : " + tri.isEquilateral(2,2,2));
console.log("Triangle Perimeter: " + tri.calcPerimeter(2,3,4));