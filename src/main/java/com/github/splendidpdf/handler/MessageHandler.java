package com.github.splendidpdf.handler;

import com.github.splendidpdf.service.CommandContext;
import com.github.splendidpdf.service.MessageService;
import com.github.splendidpdf.utils.keyboard.ReplyKeyboard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MessageHandler {

    private final CommandContext commandContext;

    private final ReplyKeyboard replyKeyboard;

    private final MessageService messageService;

    public BotApiMethod<?> handleUpdate(Update update) {
        log.info("Received a request from a user {}, message {}", update.getMessage().getChatId(), update.getMessage().getText());
        return update.hasCallbackQuery() ? handleCallback(update) : handleMessage(update);
    }

    private BotApiMethod<?> handleMessage(Update update) {
        Message message = update.getMessage();
        String chatId = String.valueOf(message.getChatId());

        SendMessage outMsg = new SendMessage();
        outMsg.setReplyMarkup(replyKeyboard.getInstance());
        outMsg.setParseMode(ParseMode.HTML);
        outMsg.setChatId(chatId);

        if (message.hasLocation()) {
            return messageService.locationAnswer(outMsg, message);
        } else if (message.hasText()) {
            String text = message.getText();
            if (text.equals("/start")) {
                return messageService.registerAnswer(outMsg, message);
            } else if (commandContext.getMenuMap().containsKey(text)) {
                outMsg.setText("Choose an action: ");
                outMsg.setReplyMarkup(commandContext.retrieveMenu(text).execute());
            }
        }
        return outMsg;
    }

    private BotApiMethod<?> handleCallback(Update update) {
        return null;
    }

}