package br.com.hotmart.apiteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.hotmart.apiteste")
@EntityScan(basePackages = "br.com.hotmart.apiteste.model")
public class ApiTesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTesteApplication.class, args);
    }

}
