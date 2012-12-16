#!/bin/sh

# MIT-LICENSE
# Copyright (c) 2012 Nano Taboada, http://openid.nanotaboada.com.ar
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.

JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
CLASS_PATH=$(pwd)/daemon.jar:/usr/share/java/commons-daemon.jar

SVC="/usr/bin/jsvc"
USR="$USER"
OUT="/tmp/java.samples.daemon.out"
ERR="/tmp/java.samples.daemon.err"
PID="/tmp/java.samples.daemon.pid"
OPT="-home $JAVA_HOME -cp $CLASS_PATH -user $USR -outfile $OUT -errfile $ERR -pidfile $PID -debug"
PKG="ar.com.nanotaboada.java.samples.daemon"
APP="$PKG.Program"

START="$SVC $OPT $APP" 
STOP="$SVC $OPT -stop $APP"

case "$1" in
    start)
        $START
        ;;
    stop)
        $STOP
        ;;
    restart)
        if [ -f "$PID" ]; then
            $STOP && $START
        else
            exit 1
        fi
        ;;
    *)
        echo "Usage: ./daemon.sh {start|stop|restart}" >&2
        exit 3
        ;;
esac