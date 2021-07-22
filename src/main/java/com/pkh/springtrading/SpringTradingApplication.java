package com.pkh.springtrading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTradingApplication.class, args);
    }

}
