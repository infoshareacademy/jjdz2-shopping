package com.jars.shopping.api;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by k on 02.03.17.
 */

@Singleton
public class EmailTimer {

    private int hour;
    private int minute;
    private String address = "";

    @EJB
    EmailSender emailSender;

    @Resource
    private TimerService timerService;
    private Timer timer;

    public void start(int hour, int minute, String address) {
        System.out.println("\n\n\n\n\n\n\n\n" +
                "THIS SHOULD NOT BE INVOKED AT STARTUP\n\n\n\n\n\n\n\n\n\n\n\n\n");
        this.hour = hour;
        this.minute = minute;
        this.address = address;
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("Bla bla bla");
        timer = timerService.createTimer(1000, TimeUnit.HOURS.toMillis(hour), "Created New Programmatic timeout");

    }
    @Timeout
    public void execute(Timer timer) {
        System.out.println("Timer Service    : " + timer.getInfo());
        System.out.println("Execution Time   : " + new Date());
        System.out.println("____________________________________________");
        emailSender.send(address, "Report from API system", "Report String to be put here!!!!");
    }
}
