package bits.current_savings_service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@RequiredArgsConstructor
public class CurrentSavingsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrentSavingsServiceApplication.class, args);
    }

}
