package backend;

import backend.Authors.Author;
import backend.Prints.Canvas;
import backend.Prints.CanvasType;
import backend.Prints.Print;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:config.xml")
public class PrintShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrintShopApplication.class, args);

        Print print = new Canvas();
        Author author = new Author();




    }

}
