package com.github.splendidpdf.handler;

import com.github.splendidpdf.command.MainMenuCommand;
import com.github.splendidpdf.service.CallbackService;
import com.github.splendidpdf.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class MessageHandler {


    private final CallbackService callbackService;

    private final MessageService messageService;

    public BotApiMethod<?> handleUpdate(Update update) {
        return update.hasCallbackQuery() ? handleCallback(update) : handleMessage(update);
    }

    private BotApiMethod<?> handleMessage(Update update) {
        Message message = update.getMessage();
        String chatId = String.valueOf(message.getChatId());
        if (message.hasLocation()) {
            return messageService.locationAnswer(message);
        }
        if(message.hasText()) {
            String text = message.getText();
            if(text.equals("/start")) {
                return messageService.registerAnswer(message);
            }
            if(isMainMenuCommand(message)) {
                MainMenuCommand mainMenuCommand = getMainMenuCommand(message);
                return messageService.mainMenuAnswer(mainMenuCommand, chatId);
            }
//            if(isPersonalMenuCommand(message)) {
//                PersonalMenuCommand personalMenuCommand = getPersonalMenuCommand(message);
//                return messageService.getAnswer(mainMenuCommand, chatId);
//            }
        }
        return null;
    }

    private BotApiMethod<?> handleCallback(Update update) {
        return null;
    }

    private MainMenuCommand getMainMenuCommand(Message message) {
        String text = message.getText();
        return Arrays.stream(MainMenuCommand.values())
                .filter(command -> command.getName().equals(text))
                .findFirst()
                .orElse(null);
    }

    private boolean isMainMenuCommand(Message message) {
        String text = message.getText();
        return Arrays.stream(MainMenuCommand.values())
                .filter(command -> command.getName().equals(text))
                .map(command -> command.getName().equals(text))
                .findFirst()
                .orElse(false);
    }

}