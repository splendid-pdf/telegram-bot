package com.github.splendidpdf.keyboard.reply;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationKeyboard extends AbstractReplyKeyboard {

    private ReplyKeyboardMarkup replyKeyboardMarkup;

    @Override
    public ReplyKeyboardMarkup getKeyboard() {
        replyKeyboardMarkup = replyKeyboardMarkup == null ? createKeyboard() : replyKeyboardMarkup;
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup createKeyboard() {
        List<KeyboardRow> keyboardRows = new ArrayList<>(2);
        KeyboardButton keyboardButton = new KeyboardButton("Send geolocation");
        keyboardButton.setRequestLocation(true);
        keyboardRows.add(new KeyboardRow(List.of(keyboardButton)));
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
}
