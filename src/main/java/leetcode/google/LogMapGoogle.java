package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class LogMapGoogle {

    public Map<String, Integer> logMap;

    LogMapGoogle() {
        logMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(String message, int timeStamp) {
        if (!logMap.containsKey(message) || timeStamp >= logMap.get(message)) {
            logMap.put(message, timeStamp + 10);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LogMapGoogle logMapGoogle = new LogMapGoogle();
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 1));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 2));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 10));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 11));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 18));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 20));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 21));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 27));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 30));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 31));
        System.out.println(logMapGoogle.shouldPrintMessage("foo", 34));
    }

}
