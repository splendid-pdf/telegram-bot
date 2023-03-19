package com.github.splendidpdf.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final UserService userService;

//    public BotApiMethod<?> getLocationAnswer(SendMessage sendMessage, Message message) {
//        userService.updateLocation(message.getFrom(), message.getLocation());
//        sendMessage.setText("location was updated");
//        return sendMessage;
//    }

    public  BotApiMethod<?> getRegisterAnswer(SendMessage sendMessage, Message message) {
        try {
            userService.create(message.getFrom());
        } catch (Exception e) {
            log.error(e.getMessage());
            sendMessage.setText("u already registered");
            return sendMessage;
        }
        return sendMessage;
    }

}