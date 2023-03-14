package com.github.splendidpdf.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SplendidPdfBotTelegram {

    @Value("${telegram-bot.webHookPath}")
    private String botPath;

    @Value("${telegram-bot.username}")
    private String userName;

    @Value("${telegram-bot.token}")
    private String token;

}
