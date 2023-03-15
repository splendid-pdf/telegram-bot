package com.github.splendidpdf.config;

import com.github.splendidpdf.service.BotApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SplendidPdfBotConfig {

    @Value("${telegram-bot.webHookPath}")
    private String webHookPath;

    @Value("${telegram-bot.username}")
    private String userName;

    @Value("${telegram-bot.token}")
    private String token;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(webHookPath).build();
    }

    @Bean
    public SplendidPdfBot springWebhookBot(SetWebhook setWebhook, BotApiService botApiService) {
        SplendidPdfBot bot = new SplendidPdfBot(botApiService, setWebhook);
        bot.setToken(token);
        bot.setBotUsername(userName);
        bot.setBotPath(webHookPath);
        return bot;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}