package com.github.splendidpdf.config;

import com.github.splendidpdf.service.SimpleService;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
public class SplendidPdfBot extends SpringWebhookBot {

    private final SimpleService simpleService;

    private String botPath;

    private String botUsername;

    private String token;

    public SplendidPdfBot(SimpleService simpleService, DefaultBotOptions options, SetWebhook setWebhook) {
        super(options, setWebhook);
        this.simpleService = simpleService;
    }

    public SplendidPdfBot(SimpleService simpleService, SetWebhook setWebhook) {
        super(setWebhook);
        this.simpleService = simpleService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return simpleService.handleUpdate(update);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
