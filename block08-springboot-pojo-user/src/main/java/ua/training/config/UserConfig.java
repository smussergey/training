package ua.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.training.model.entity.User;

@Configuration
public class UserConfig {

    @Bean(name = "user")
    public User getUser() {
        return new User(1L, "Segey", "sergey@gmail.com", "Sergeypassword");
    }
}
