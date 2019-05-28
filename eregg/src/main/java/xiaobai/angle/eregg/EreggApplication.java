package xiaobai.angle.eregg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EreggApplication {

	public static void main(String[] args) {
		SpringApplication.run(EreggApplication.class, args);
	}

}
