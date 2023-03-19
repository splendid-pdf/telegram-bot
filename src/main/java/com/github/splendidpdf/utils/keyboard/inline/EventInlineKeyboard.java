package com.github.splendidpdf.utils.keyboard.inline;

import com.github.splendidpdf.command.CallbackDataAndBotState;
import com.github.splendidpdf.utils.keyboard.InlineKeyboard;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class EventInlineKeyboard {

    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    public EventInlineKeyboard() {
        inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(initProjectInlineKeyboard());
    }

    private List<List<InlineKeyboardButton>> initProjectInlineKeyboard() {
        List<List<InlineKeyboardButton>> profileMenuCommand = new ArrayList<>();
        profileMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.ADD_TO_FAVORITE.getName(),
                CallbackDataAndBotState.ADD_TO_FAVORITE.getSyntax())
        );

        return profileMenuCommand;
    }

}
