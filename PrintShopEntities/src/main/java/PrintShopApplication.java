import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:main.config.xml")
public class PrintShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrintShopApplication.class, args);







    }

}
