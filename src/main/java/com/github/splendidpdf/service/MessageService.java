package com.github.splendidpdf.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final UserService userService;

    public BotApiMethod<?> locationAnswer(SendMessage sendMessage, Message message) {
        userService.updateLocation(message.getFrom(), message.getLocation());
        sendMessage.setText("location was updated");
        return sendMessage;
    }

    public  BotApiMethod<?> registerAnswer(SendMessage sendMessage, Message message) {
        try {
            userService.create(message.getFrom());
        } catch (Exception e) {
            sendMessage.setText("u already registered");
            return sendMessage;
        }
        sendMessage.setText("Send to me your geolocation");
        return sendMessage;
    }
}