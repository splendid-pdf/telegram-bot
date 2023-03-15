package com.github.splendidpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SplendidTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplendidTelegramBotApplication.class, args);
    }
}
