package com.github.splendidpdf.controller;

import com.github.splendidpdf.bot.SplendidPdfBot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WebHookController {

    private final SplendidPdfBot splendidPdfBot;

    @PostMapping("/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return splendidPdfBot.onWebhookUpdateReceived(update);
    }
}
