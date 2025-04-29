package org.bits.bitsdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BitsDiscoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitsDiscoveryServiceApplication.class, args);
    }

}
