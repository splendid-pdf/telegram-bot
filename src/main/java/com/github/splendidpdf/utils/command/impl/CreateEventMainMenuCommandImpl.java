package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component
public class CreateEventMainMenuCommandImpl implements MainMenuCommand {

    @Override
    public String getCommandSyntax() {
        return MainMenu.CREATE_EVENT.getName();
    }

    @Override
    public InlineKeyboardMarkup execute() {
        return null;
    }
}