var custom = (function () {
    var pub = {},
        i,
        at,
        dot,
        items,
        mailto;

    // Created to avoid common spam use cases, using the following convention:
    // "someone at somewhere dot com dot ar" (e.g. foo@bar.com.ar) 
    pub.obfuscateEmailAddress = function () {
        at = /%20at%20/;
        dot = /%20dot%20/g;
        items = document.getElementsByTagName('li');
        for (i = 0; i < items.length; i++) {
            if (items[i].className === 'email') {
                mailto = items[i].innerHTML.replace(at, '@');
                mailto = mailto.replace(dot, '.');
                items[i].innerHTML = mailto;
            }
        }
    };

    // Based on "Flexible JavaScript events" by John Resig: http://goo.gl/xLn4S
    pub.addEvent = function (obj, type, func) {
        if (obj.attachEvent) {
            obj['e' + type + func] = func;
            obj[type + func] = function () {
                obj['e' + type + func](window.event);
            };
            obj.attachEvent('on' + type, obj[type + func]);
        } else {
            obj.addEventListener(type, func, false);
        }
    };

    pub.removeEvent = function (obj, type, func) {
        if (obj.detachEvent) {
            obj.detachEvent('on' + type, obj[type + func]);
            obj[type + func] = null;
        } else {
            obj.removeEventListener(type, func, false);
        }
    };

    return pub;

}());

custom.addEvent(window, 'load', custom.obfuscateEmailAddress);