var EXIT_TIMES = 40;

function scrollSlowly() {
    var height = 0;
    var currentHeight = null;
    var sameHeightTimes = 0;
    var timer = setInterval(function() {
        if (document.body.scrollHeight === currentHeight) {
            sameHeightTimes++;
        } else {
            sameHeightTimes = 0;
        }
        if (sameHeightTimes > EXIT_TIMES) {
            clearInterval(timer);
            console.log("It's already bottom");
        }
        currentHeight = document.body.scrollHeight;
        window.scrollTo(0, height);
        height += 500;
    }, 100);
}
scrollSlowly()