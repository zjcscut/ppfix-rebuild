package com.ppfix.web.common;

import java.util.Date;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/10/29-15:37
 */
public class SchedulerJob {

    public void run(){
        System.out.println("test:"+ new Date().toString());
    }
}
