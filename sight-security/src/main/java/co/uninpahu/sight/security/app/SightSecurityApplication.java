package co.uninpahu.sight.security.app;

import co.uninpahu.sight.security.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {
		TestController.class
	}
)
public class SightSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SightSecurityApplication.class, args);
	}

}
