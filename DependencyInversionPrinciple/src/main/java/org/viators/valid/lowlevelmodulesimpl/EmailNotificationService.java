package org.viators.valid.lowlevelmodulesimpl;

import org.viators.valid.lowlevelmodulesinterfaces.NotifService;

public class EmailNotificationService implements NotifService {
    @Override
    public void sendNotification(String receiver, String subject, String body) {
        System.out.println("Sending email to " + receiver + " with subject: " + subject);
    }
}
