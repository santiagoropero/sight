package co.uninpahu.sight.assignments.app;

import co.uninpahu.sight.assignments.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
        TestController.class
}
)
public class SightAssignmentsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SightAssignmentsApplication.class, args);
    }

}
