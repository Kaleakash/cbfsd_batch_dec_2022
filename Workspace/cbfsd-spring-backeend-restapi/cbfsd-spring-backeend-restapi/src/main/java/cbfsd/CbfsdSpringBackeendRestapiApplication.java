package cbfsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "cbfsd")	// Enable @Restcontroller, @Service and @Repository annotation 
@EnableJpaRepositories(basePackages = "cbfsd.com.repository")
@EntityScan(basePackages = "cbfsd.com.entity")		// @Entity classes enable in spring boot 
public class CbfsdSpringBackeendRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CbfsdSpringBackeendRestapiApplication.class, args);
		System.out.println("Server Up");
	}

}
