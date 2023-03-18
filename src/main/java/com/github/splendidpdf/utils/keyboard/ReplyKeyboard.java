package com.github.splendidpdf.utils.keyboard;

import com.github.splendidpdf.command.MainMenuCommand;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class ReplyKeyboard {

    private ReplyKeyboardMarkup instance;

    public ReplyKeyboardMarkup getInstance() {
        return initReplyKeyboardMarkup();
    }

    public ReplyKeyboardMarkup initReplyKeyboardMarkup() {
        if (instance == null) {
            KeyboardRow firstRow = new KeyboardRow();
            firstRow.add(new KeyboardButton(MainMenuCommand.EVENTS_CALENDAR.getName()));
            firstRow.add(new KeyboardButton(MainMenuCommand.CREATE_EVENT.getName()));

            KeyboardRow secondRow = new KeyboardRow();
            secondRow.add(new KeyboardButton(MainMenuCommand.MY_PROFILE.getName()));
            secondRow.add(new KeyboardButton(MainMenuCommand.PROJECT.getName()));
            secondRow.add(new KeyboardButton(MainMenuCommand.INFO.getName()));

            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(firstRow);
            keyboard.add(secondRow);

            instance = new ReplyKeyboardMarkup();
            instance.setKeyboard(keyboard);
            instance.setSelective(true);
            instance.setResizeKeyboard(true);
            instance.setOneTimeKeyboard(false);
        }
        return instance;
    }
}