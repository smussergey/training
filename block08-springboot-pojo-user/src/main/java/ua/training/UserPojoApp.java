package ua.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.training.config.UserConfig;
import ua.training.model.entity.User;

@SpringBootApplication
public class UserPojoApp {
    private static User user;

    public static void main(String[] args) {
        SpringApplication.run(UserPojoApp.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        user = applicationContext.getBean(User.class);
        System.out.println(user.toString());
    }
}
