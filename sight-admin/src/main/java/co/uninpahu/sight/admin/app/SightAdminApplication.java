package co.uninpahu.sight.admin.app;

import co.uninpahu.sight.admin.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        TestController.class
}
)
public class SightAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SightAdminApplication.class, args);
    }
}
