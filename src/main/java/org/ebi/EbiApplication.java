package org.ebi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.ebi.repository")
@EnableSwagger2
public class EbiApplication {
    public static void main(String[] args){
        SpringApplication.run(EbiApplication.class, args);
    }
}
