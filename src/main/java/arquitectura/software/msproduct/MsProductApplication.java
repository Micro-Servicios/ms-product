package arquitectura.software.msproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient // para configurar de control
public class MsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProductApplication.class, args);
	}

}
