package devops.exam.rca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RcaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RcaApplication.class, args);
	}

}
