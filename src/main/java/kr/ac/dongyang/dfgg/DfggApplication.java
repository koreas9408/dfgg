package kr.ac.dongyang.dfgg;

import kr.ac.dongyang.dfgg.config.DatabaseConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class DfggApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfggApplication.class, args);
    }

}
