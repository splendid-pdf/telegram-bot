package com.github.splendidpdf.service;

import com.github.splendidpdf.command.MainMenuCommand;
import com.github.splendidpdf.keyboard.reply.LocationKeyboard;
import com.github.splendidpdf.keyboard.reply.MainMenuKeyboard;
import com.github.splendidpdf.keyboard.reply.PersonalMenuKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MainMenuKeyboard mainMenuKeyboard;

    private final LocationKeyboard locationKeyboard;

    private final PersonalMenuKeyboard personalMenuKeyboard;

    private final UserService userService;

    public SendMessage getAnswer(String text, String chatId) {
        return null;
    }


    public SendMessage mainMenuAnswer(MainMenuCommand mainMenuCommand, String chatId) {
        SendMessage sendMessage = new SendMessage();
        switch (mainMenuCommand) {
            case EVENTS_CALENDAR -> sendMessage.setText("Show all ivents");
            case CREATE_EVENT -> sendMessage.setText("Crete ivent");
            case MY_PROFILE -> sendMessage.setText("Server error");
            default -> sendMessage.setText("Server_error");
        }
        sendMessage.setReplyMarkup(mainMenuKeyboard.getKeyboard());
        sendMessage.setChatId(chatId);
        return sendMessage;
    }

    public SendMessage locationAnswer(Message message) {
        userService.updateLocation(message.getFrom(), message.getLocation());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("location was updated");
        sendMessage.setReplyMarkup(mainMenuKeyboard.getKeyboard());
        sendMessage.setChatId(message.getChatId());
        return sendMessage;
    }



    public BotApiMethod<?> registerAnswer(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        try {
            userService.create(message.getFrom());
        } catch (Exception e) {
            sendMessage.setText("u already registered");
            sendMessage.setReplyMarkup(mainMenuKeyboard.getKeyboard());
            return sendMessage;
        }
        sendMessage.setText("Send to me your geolocation");
        sendMessage.setReplyMarkup(locationKeyboard.getKeyboard());
        return sendMessage;
    }
}
