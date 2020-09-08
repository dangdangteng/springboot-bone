package xiaobai.angle.ereg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EregApplication {

	public static void main(String[] args) {
		SpringApplication.run(EregApplication.class, args);
	}

}
