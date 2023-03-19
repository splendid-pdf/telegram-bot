package com.github.splendidpdf.utils.command.impl;

import com.github.splendidpdf.command.MainMenu;
import com.github.splendidpdf.utils.command.MainMenuCommand;
import com.github.splendidpdf.utils.keyboard.inline.ProfileInlineKeyboard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component
@RequiredArgsConstructor
public class ProfileMainMenuCommandImpl implements MainMenuCommand {

    private final ProfileInlineKeyboard profileInlineKeyboard;

    @Override
    public String getCommandSyntax() {
        return MainMenu.MY_PROFILE.getName();
    }

    @Override
    public InlineKeyboardMarkup execute() {
        return profileInlineKeyboard.getInlineKeyboardMarkup();
    }
}