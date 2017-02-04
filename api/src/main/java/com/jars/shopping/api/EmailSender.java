package com.jars.shopping.api;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless

public class EmailSender {

    public boolean isKeepSendingReports() {
        return keepSendingReports;
    }

    public void setKeepSendingReports(boolean keepSendingReports) {
        this.keepSendingReports = keepSendingReports;
    }

    private boolean keepSendingReports;

    @Resource(name = "java:jboss/mail/gmail")
    private Session session;

    public void send(String addresses, String topic, String textMessage) {

        System.out.println("send!!!");
        try {

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
            message.setSubject(topic);
            message.setText(textMessage);

            Transport.send(message);

        } catch (MessagingException e) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.WARNING, "Cannot send mail", e);
        }
    }

    @Schedule(minute = "*/1", hour = "*")
    private void sendScheduled() {
        if (keepSendingReports) {
            send("kkubicki2@gmail.com", "Test email", "Message body tra la la la la la");
        }
    }
}