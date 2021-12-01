package pe.isil.notification.service;

import freemarker.template.TemplateException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import pe.isil.notification.integration.model.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final Configuration configuration;

    public EmailService(JavaMailSender javaMailSender, Configuration configuration) {
        this.javaMailSender = javaMailSender;
        this.configuration = configuration;
    }

    public void sendMail(User user) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Tradebooks");
        helper.setTo(user.getEmail());
        String emailBody = getEmailBody(user);
        helper.setText(emailBody, true);;
        javaMailSender.send(mimeMessage);
    }

    private String getEmailBody(User user) throws IOException, TemplateException {
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        StringWriter stringWriter = new StringWriter(());
        configuration.getTemplate("email.html").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
