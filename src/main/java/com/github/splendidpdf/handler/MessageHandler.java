package com.github.splendidpdf.handler;

import com.github.splendidpdf.bot.SplendidPdfBot;
import com.github.splendidpdf.model.Event;
import com.github.splendidpdf.service.CommandContext;
import com.github.splendidpdf.service.EventService;
import com.github.splendidpdf.service.UserService;
import com.github.splendidpdf.utils.keyboard.ReplyKeyboard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MessageHandler {

    private final CommandContext commandContext;

    private final ReplyKeyboard replyKeyboard;

    private final UserService userService;

    private final EventService eventService;

    public List<SendMessage>  handleMessage(Update update) {
        Message message = update.getMessage();
        String chatId = String.valueOf(message.getChatId());

        SendMessage outMsg = new SendMessage();
        outMsg.setReplyMarkup(replyKeyboard.getInstance());
        outMsg.setParseMode(ParseMode.HTML);
        outMsg.setChatId(chatId);

        if (message.hasText()) {
            String text = message.getText();
            if (text.equals("/start")) {
                return List.of(registerAnswer(outMsg, message));
            }
            if (commandContext.getMenuMap().containsKey(text)) {
                List<Event> events = eventService.findAll();
                List<SendMessage> sendMessages = events.stream()
                        .map(event -> SendMessage
                                .builder()
                                .chatId(chatId)
                                .replyMarkup(replyKeyboard.getInstance())
                                .parseMode(ParseMode.HTML)
                                .text(String.format("""
                                        Event name:
                                        %s
                                        Event description:
                                        %s
                                        Event date: %s""",
                                        event.getName(),
                                        event.getDescription(),
                                        event.getLocalDateTime()))
                                .build())
                        .toList();

                return commandContext.getMenuMap().get(text).execute(sendMessages);
            }
        }
        return List.of(outMsg);
    }

    private SendMessage registerAnswer(SendMessage sendMessage, Message message) {
        try {
            userService.create(message.getFrom());
            sendMessage.setText(message.getFrom().getUserName() + ", hi! Registration completed successfully!");
        } catch (Exception e) {
            log.error(e.getMessage());
            sendMessage.setText("You already registered...");
            return sendMessage;
        }
        return sendMessage;
    }

}