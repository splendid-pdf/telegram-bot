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
public class ProjectInlineKeyboard {

    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    public ProjectInlineKeyboard() {
        inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(initProjectInlineKeyboard(new ArrayList<>()));
    }

    private List<List<InlineKeyboardButton>> initProjectInlineKeyboard(
            List<List<InlineKeyboardButton>> projectMenuCommand) {
        projectMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROJECT_ADD.getName(),
                CallbackDataAndBotState.PROJECT_ADD.getSyntax()));

        projectMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROJECT_DELETE.getName(),
                CallbackDataAndBotState.PROJECT_DELETE.getSyntax()));

        projectMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROJECT_PEOPLE.getName(),
                CallbackDataAndBotState.PROJECT_PEOPLE.getSyntax()));

        projectMenuCommand.add(InlineKeyboard.getButton(
                CallbackDataAndBotState.PROJECT_ALL.getName(),
                CallbackDataAndBotState.PROJECT_ALL.getSyntax()));

        return projectMenuCommand;
    }
}