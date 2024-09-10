exports.add = function(a, b) {
    return parseInt(a) + parseInt(b);
}

exports.subtract = function(a, b) {
    return parseInt(a) - parseInt(b);
}

exports.multiply = function(a, b) {
    return parseInt(a) * parseInt(b);
}

exports.divide = function(a, b) {
    return parseInt(a) / parseInt(b);
}

exports.square = function(a) {
    return parseInt(a) * parseInt(a);
}

exports.sum = function(...a) {
    var summation = 0;
    for (var i = 0; i < a.length; i++) {
        summation += parseInt(a[i]);
    }
    return summation;
} 