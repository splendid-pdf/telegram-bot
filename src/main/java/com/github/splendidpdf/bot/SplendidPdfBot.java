package com.github.splendidpdf.bot;

import com.github.splendidpdf.config.SplendidPdfBotConfig;
import com.github.splendidpdf.handler.MessageHandler;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
@Component
public class SplendidPdfBot extends SpringWebhookBot {

    private String botPath;

    private String botUsername;

    private MessageHandler messageHandler;

    private SplendidPdfBotConfig splendidPdfBotConfig;

    @Autowired
    public SplendidPdfBot(
            MessageHandler messageHandler,
            SetWebhook setWebhook,
            SplendidPdfBotConfig splendidPdfBotConfig
    ) {
        super(setWebhook, splendidPdfBotConfig.getBotToken());
        this.messageHandler = messageHandler;
        this.botUsername = splendidPdfBotConfig.getUserName();
        this.botPath = splendidPdfBotConfig.getWebHookPath();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return messageHandler.handleUpdate(update);
    }

}