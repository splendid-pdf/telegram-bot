package com.github.splendidpdf.keyboard.reply;

import com.github.splendidpdf.model.Role;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleKeyboard extends AbstractReplyKeyboard {

    private ReplyKeyboardMarkup replyKeyboardMarkup;

    @Override
    public ReplyKeyboardMarkup getKeyboard() {
        replyKeyboardMarkup = replyKeyboardMarkup == null ? createKeyboard() : replyKeyboardMarkup;
        return replyKeyboardMarkup;
    }

    private ReplyKeyboardMarkup createKeyboard() {
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        int i = 0;
        for(Role role : Role.values()) {
            if(i == 2) {
                keyboardRows.add(keyboardRow);
                keyboardRow = new KeyboardRow();
                i = 0;
            }
            keyboardRow.add(new KeyboardButton(role.name()));
            i++;
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        return replyKeyboardMarkup;
    }
}
