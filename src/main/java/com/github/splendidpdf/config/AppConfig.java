package com.github.splendidpdf.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final SplendidPdfBotConfig splendidPdfBotConfig;

    @Bean
    public SetWebhook setWebhook() {
        return SetWebhook.builder().url(splendidPdfBotConfig.getWebHookPath()).build();
    }

}
