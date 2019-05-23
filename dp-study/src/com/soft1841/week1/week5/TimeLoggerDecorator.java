package com.soft1841.week1.week5;

import java.util.Calendar;

public class TimeLoggerDecorator implements Logger {
    private Logger decoratorLogger;
    public TimeLoggerDecorator(Logger decoratorLogger){
        this.decoratorLogger = decoratorLogger;
    }
    @Override
    public void log(String message) {
        decoratorLogger.log(message);
        logTime();
    }
    public void logTime(){
        System.out.println(Calendar.getInstance().getTime());
    }
}
