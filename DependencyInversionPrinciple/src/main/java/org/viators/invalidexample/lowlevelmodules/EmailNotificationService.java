package org.viators.invalidexample.lowlevelmodules;

public class EmailNotificationService {
    public void sendEmail(String receiver, String subject, String boby) {
        System.out.println("Sending email to " + receiver + " with subject: " + subject);
    }
}
