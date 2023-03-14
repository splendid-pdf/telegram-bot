package com.github.splendidpdf.config;

import com.github.splendidpdf.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SplendidPdfBotConfig {

    private final SplendidPdfBotTelegram splendidPdfBotTelegram;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(splendidPdfBotTelegram.getBotPath()).build();
    }

    @Bean
    public SplendidPdfBot springWebhookBot(SetWebhook setWebhook, SimpleService simpleService) {
        SplendidPdfBot bot = new SplendidPdfBot(simpleService, setWebhook);
        bot.setToken(splendidPdfBotTelegram.getToken());
        bot.setBotUsername(splendidPdfBotTelegram.getUserName());
        bot.setBotPath(splendidPdfBotTelegram.getBotPath());
        return bot;
    }
}
