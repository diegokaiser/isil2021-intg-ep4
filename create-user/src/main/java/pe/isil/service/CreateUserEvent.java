package pe.isil.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import pe.isil.config.CreateUserProperties;
import pe.isil.model.User;
import pe.isil.util.Formatter;

@Slf4j
@Service
public class CreateUserEvent {

    private final JmsTemplate jmsTemplate;
    private final Formatter formatter;
    private final CreateUserProperties props;

    public CreateUserEvent(JmsTemplate jmsTemplate, Formatter formatter, CreateUserProperties props) {
        this.jmsTemplate = jmsTemplate;
        this.formatter = formatter;
        this.props = props;
    }

    public void sendEvent(User user) {
        final String userString = formatter.toString(user);
        jmsTemplate.convertAndSend(props.getCreateUserQueue(), userString);
        log.info("Se envió un mensaje a la cola ["+props.getCreateUserQueue()+"]");
    }

}
