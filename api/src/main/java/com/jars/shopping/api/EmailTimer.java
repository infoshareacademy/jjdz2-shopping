package com.jars.shopping.api;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;

/**
 * Created by k on 02.03.17.
 */

@Singleton
public class EmailTimer {

    private int hour;
    private int minute;
    private String address;

    @EJB
    EmailSender emailSender;

    @Resource
    private TimerService timerService;
    private Timer timer;

    public void start(int hour, int minute, String address) {
        this.hour = hour;
        this.minute = minute;
        this.address = address;
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("Bla bla bla");
        timer = timerService.createTimer(1000, hour * 60 * 60 * 1000, "Created New Programmatic timeout");

    }
    @Timeout
    public void execute(Timer timer) {
        System.out.println("Timer Service    : " + timer.getInfo());
        System.out.println("Execution Time   : " + new Date());
        System.out.println("____________________________________________");
        emailSender.send(address, "Report from API system", "Report String to be put here!!!!");
    }
}
