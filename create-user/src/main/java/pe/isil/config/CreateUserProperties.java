package pe.isil.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.queue")
public class CreateUserProperties {

    private String createUserQueue;

    public String getCreateUserQueue() {
        return createUserQueue;
    }

    public void setCreateUserQueue(String createUserQueue) {
        this.createUserQueue = createUserQueue;
    }
}
