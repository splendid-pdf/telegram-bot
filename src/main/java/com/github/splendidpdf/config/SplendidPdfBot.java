package com.github.splendidpdf.config;

import com.github.splendidpdf.service.BotApiService;
import lombok.Getter;
import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Getter
@Setter
public class SplendidPdfBot extends SpringWebhookBot {

    private final BotApiService botApiService;

    private String botPath;

    private String botUsername;

    private String token;

    public SplendidPdfBot(BotApiService botApiService, SetWebhook setWebhook) {
        super(setWebhook);
        this.botApiService = botApiService;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return botApiService.handleUpdate(update);
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}