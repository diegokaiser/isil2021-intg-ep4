package pe.isil.notification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import pe.isil.notification.integration.model.User;
import pe.isil.notification.util.Formatter;

@Slf4j
@Service
public class NotificationEventListener {

    private final EmailService emailService;
    private final Formatter formatter;

    public NotificationEventListener(EmailService emailService, Formatter formatter) {
        this.emailService = emailService;
        this.formatter = formatter;
    }

    @JmsListener(destination = "${app.queue.notificationQueue}")
    public void receiveEvent(String message) {
        User user = formatter.toObject(message, User.class);
        try {
            emailService.sendMail(user);
            log.info("Se envió el mail satisfactoriamente");
        } catch (Exception e) {
            log.error("Ocurrió un error al enviar el email, ex: {}", e.getMessage());
        }
    }
}
