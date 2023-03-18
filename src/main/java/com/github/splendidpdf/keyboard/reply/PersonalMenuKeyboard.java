package com.github.splendidpdf.keyboard.reply;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalMenuKeyboard extends AbstractReplyKeyboard {

    private ReplyKeyboardMarkup replyKeyboardMarkup;

    @Override
    public ReplyKeyboardMarkup getKeyboard() {
        replyKeyboardMarkup = replyKeyboardMarkup == null ? createKeyboard() : replyKeyboardMarkup;
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup createKeyboard() {
        List<KeyboardRow> keyboardRows = new ArrayList<>(2);
        keyboardRows.add(new KeyboardRow(List.of(new KeyboardButton("Избранные события"))));
        keyboardRows.add(new KeyboardRow(List.of(new KeyboardButton("Мои события"))));
        keyboardRows.add(new KeyboardRow(List.of(new KeyboardButton("Назад"))));
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }

}
