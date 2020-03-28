--Program to blink inbuilt led in beaglebone board--
var b = require('bonescript');
var led = "USR1";
var state = 0;

b.pinMode(led, 'out');
toggleLED = function() {
    state = state ? 0 : 1;
    b.digitalWrite(led, state);
};

timer = setInterval(toggleLED, 500);

stopTimer = function() {
    clearInterval(timer);
};

setTimeout(stopTimer, 3000);
