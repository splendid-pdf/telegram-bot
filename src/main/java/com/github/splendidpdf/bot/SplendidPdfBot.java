package com.github.splendidpdf.bot;

import com.github.splendidpdf.config.SplendidPdfBotConfig;
import com.github.splendidpdf.handler.CallbackHandler;
import com.github.splendidpdf.handler.MessageHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import java.lang.reflect.Method;
import java.util.List;

@Slf4j
@Getter
@Setter
@Component
public class SplendidPdfBot extends SpringWebhookBot {

    private String botPath;

    private String botUsername;

    private MessageHandler messageHandler;

    private CallbackHandler callbackHandler;

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


    /*������ ���� ������ �������� �������������� ����������� �����, ������� � ���������� ���. ��� ����� ����������, � � ������ ������!
    ������ �� ������� ����� ���� �����, � ������ ������ �� ������ ��� � ����� ��� �� �������. � ��� �������� ��� � �������
    ������, ����� ��� ���������� ��� ��������������. � �� ��������
    �������� ���� �� ����� � �� ��� ����� ���������, �� �� ���-�� ��������� ���� �����
    ���� ����� ������ �� ��� ������� �������� ��� �� ���������� ��� ��������� �������,
    �� � ��� � �� ����� �� ������ ��� �������� ��� �� ��� ��� - �� ����������/
    ���� �� ������ ��� ��������, �� � �� ������� �����, ������ �� �������.
    ���� �� ��� ��� - �� ����������, �� � �� ������� ���. � �� ����� ��� �� ��� �� ���� ��������. �������� �� ���
    ������ � �� ��������. ���� ���� ������ ��� Ruben Bermudez ������. ��� ����, �� ���� ��� �� ��� ����������� �� ���
    � ���� ��� ��� ���������� ������, �� ���� ����� ������ �� �����.
     */
    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    public void onWebhookUpdateReceived1(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            log.info("New message from User: {}, chatId: {}, with text: {}",
                    message.getFrom().getUserName(), chatId, message.getText());
            List<SendMessage> messages = messageHandler.handleMessage(update);
            sendMessage(messages);
            return;
        }
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Long chatId = callbackQuery.getFrom().getId();
        log.info("New CallbackQuery from User: {}, userId:{}, data:{}",
                callbackQuery.getFrom().getUserName(), chatId, callbackQuery.getData());
//        return callbackHandler.handleCallback(update);
    }

    public void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(Iterable<SendMessage> sendMessages) {
        sendMessages.forEach(this::sendMessage);
    }
}