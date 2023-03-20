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

    public InlineKeyboardMarkup createInlineKeyboardMarkup(Long eventId) {
        String buttonName = CallbackDataAndBotState.ADD_TO_FAVORITE.getName();
        String buttonCallbackData = String.format(CallbackDataAndBotState.ADD_TO_FAVORITE.getSyntax(), eventId);
        List<List<InlineKeyboardButton>> profileMenuCommand = new ArrayList<>();
        profileMenuCommand.add(InlineKeyboard.getButton(buttonName, buttonCallbackData));
        return InlineKeyboardMarkup
                .builder()
                .keyboard(profileMenuCommand)
                .build();
    }

}
