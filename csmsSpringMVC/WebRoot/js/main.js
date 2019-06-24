autodivheight()
    //获取页面高度
function autodivheight() {
    //函数：获取尺寸
    //获取浏览器窗口高度
    var winHeight = 0;
    if (window.innerHeight) {
        winHeight = window.innerHeight;
    } else if ((document.body) && (document.body.clientHeight)) {
        winHeight = document.body.clientHeight;
    }
    //通过深入Document内部对body进行检测，获取浏览器窗口高度
    if (document.documentElement && document.documentElement.clientHeight) {
        winHeight = document.documentElement.clientHeight;
    }

    var topheight = document.getElementById("top").offsetHeight;
    //var footerheight = document.getElementById("footer").offsetHeight;
    document.getElementById("main").style.height = winHeight - topheight + "px";
}
window.onresize = autodivheight;

var h = document.documentElement.clientHeight - 110;
x = document.getElementById("iframe");
x.height = h

window.onresize = function() {
    var h = document.documentElement.clientHeight - 110;
    x = document.getElementById("iframe");
    x.height = h
}

function gethref(val) {
    document.getElementById("iframe").src = val;
}
$(".a-nav").click(function() {
    gethref($(this).attr("href"));
    return false;
});