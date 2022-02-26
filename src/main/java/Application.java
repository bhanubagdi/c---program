import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.stringoperations.solutions.service.CharCountService;

@ComponentScan(basePackages = "org.stringoperations.solutions.*")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application extends SpringBootServletInitializer  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
