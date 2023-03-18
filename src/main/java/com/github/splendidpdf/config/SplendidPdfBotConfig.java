package com.github.splendidpdf.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SplendidPdfBotConfig {

    @Value("${telegram-bot.webHookPath}")
    String webHookPath;

    @Value("${telegram-bot.username}")
    String userName;

    @Value("${telegram-bot.token}")
    String botToken;
}
