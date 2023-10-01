package co.uninpahu.sight.admin.app;

import co.uninpahu.sight.admin.controller.rol.RolController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
        basePackageClasses = {
        RolController.class
    })
@EntityScan("co.uninpahu.sight.admin.model.entity")
@ComponentScan("co.uninpahu.sight.admin.*")
@EnableJpaRepositories("co.uninpahu.sight.admin.model.*")
public class SightAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SightAdminApplication.class, args);
    }
}
