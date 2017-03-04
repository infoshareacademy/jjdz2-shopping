package com.jars.shopping.api;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.inject.Inject;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by k on 02.03.17.
 */

@Singleton
public class EmailTimer {

    private int hour;
    private int minute;
    private String address = "";

    @Inject
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
        if (address != "") {
            timer = timerService.createTimer(0,TimeUnit.HOURS.toMillis(hour), "Created New Programmatic timeout");
        } else
            Logger.getLogger(EmailSender.class.getName()).log(Level.FINEST, "\n\nAddress field is Empty, IGNORE THIS MEESSAGE IF THIS IS SYSTEM RESTART\n\n");
    }

    @Timeout
    public void execute(Timer timer) {

        //TODO: Investigate why is this method invoked at startup?
        System.out.println("Timer Service    : " + timer.getInfo());
        System.out.println("Execution Time   : " + new Date());
        System.out.println("____________________________________________");
        System.out.println("This method should be invoked every " + hour + " hour(s)");
        if (address != "") {
            emailSender.send(address, "Report from API system", "Report String to be put here!!!!");
        }
    }
}
