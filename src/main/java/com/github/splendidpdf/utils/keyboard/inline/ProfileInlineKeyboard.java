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
public class ProfileInlineKeyboard {

    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    public ProfileInlineKeyboard() {
        inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(initProjectInlineKeyboard(new ArrayList<>()));
    }

    private List<List<InlineKeyboardButton>> initProjectInlineKeyboard(
            List<List<InlineKeyboardButton>> profileMenuCommand) {
        profileMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROFILE_FAVORITES.getName(),
                CallbackDataAndBotState.PROFILE_FAVORITES.getSyntax()));

        profileMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROFILE_EVENTS.getName(),
                CallbackDataAndBotState.PROFILE_EVENTS.getSyntax()));

        profileMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROFILE_ROLE.getName(),
                CallbackDataAndBotState.PROFILE_ROLE.getSyntax()));

        profileMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROFILE_LOCATION.getName(),
                CallbackDataAndBotState.PROFILE_LOCATION.getSyntax()));

        return profileMenuCommand;
    }
}